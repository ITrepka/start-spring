package com.craftincode.startspring.model;

import com.craftincode.startspring.dto.CreateUserDto;
import com.craftincode.startspring.dto.UpdateUserDto;
import com.craftincode.startspring.dto.UserDto;
import com.craftincode.startspring.exceptions.AlreadyExists;
import com.craftincode.startspring.exceptions.InvalidData;
import com.craftincode.startspring.exceptions.NotFound;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static Integer userId = 0;

    static {
        users.add(new User(userId++, "Byczek", "byk00", "siemaema", 2010, OffsetDateTime.now()));
        users.add(new User(userId++, "Byczek2", "byk002", "siemaem2a", 2011, OffsetDateTime.now()));
        users.add(new User(userId++, "Smyczek", "smyk0302", "siemaem2a3", 2011, OffsetDateTime.now()));
    }

    public List<UserDto> getAllUsers(Integer birthYear, String sortBy, String sortOrder) {
        List<User> sortedUsers = users;
        if (birthYear != null) {
            sortedUsers = findUsersByBirthYear(birthYear);
        }

        if ("name".equalsIgnoreCase(sortBy)) {
            //stałe comparatory, aaale to w serwisie
            Comparator<User> comparator = (user1, user2) ->
                    String.CASE_INSENSITIVE_ORDER.compare(user1.getName(), user2.getName());
            if ("desc".equalsIgnoreCase(sortOrder)) {
                comparator = (user1, user2) ->
                        String.CASE_INSENSITIVE_ORDER.compare(user2.getName(), user1.getName());
            }
            Collections.sort(sortedUsers, comparator);
        }

//        if(sortOrder.equalsIgnoreCase("desc")) {
//            Collections.reverse(sortedUsers);
//        }

        return sortedUsers.stream().map((user -> mapUserToDto(user))).collect(Collectors.toList());
    }

    public List<User> findUsersByBirthYear(Integer birthYear) {
        return users.stream()
                .filter((u) -> u.getBirthYear().equals(birthYear))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int id) throws NotFound {
        User user = users.stream().
                filter((u) -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFound(id + "id, cannot find user"));
        return mapUserToDto(user);
    }

    public UserDto addUser(CreateUserDto userDto) throws AlreadyExists, InvalidData {
        validate(userDto);
        validateLoginExists(userDto.getLogin());
        User user = new User(userId++, userDto.getName(), userDto.getLogin(), userDto.getPassword(), userDto.getBirthYear(), OffsetDateTime.now());
        users.add(user);
        return mapUserToDto(user);
    }

    private void validate(CreateUserDto user) throws InvalidData {
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new InvalidData("User must have an non-empty login!");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidData("User must have an non-empty password!");
        }
    }

    private void validate(UpdateUserDto user) throws InvalidData {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidData("User must have an non-empty password!");
        }
    }

    public UserDto updateUserById(int id, UpdateUserDto updateUserDto) throws NotFound, AlreadyExists, InvalidData {
        validate(updateUserDto);
        User user = users.stream().
                filter((u) -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFound(id + "id, cannot find user"));
        user.setName(updateUserDto.getName());
        user.setPassword(updateUserDto.getPassword());
        user.setBirthYear(updateUserDto.getBirthYear());
        user.setUpdatedAt(OffsetDateTime.now());
        return mapUserToDto(user);
    }

    private void validateLoginExists(String login) throws AlreadyExists {
        boolean exist = users.stream().allMatch((u) -> u.getLogin().equals(login));
        if (exist) throw new AlreadyExists("conflict login");
    }

    public void deleteUserById(int id) throws NotFound {
        users.remove(getUserById(id));
    }

    //todo do tego nad klasa glowna adnotacja
    @Scheduled()
    public void method() {

    }

    public UserDto mapUserToDto(User user) {
        return new UserDto(user.getName(), user.getLogin(), user.getBirthYear(), user.getId(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
