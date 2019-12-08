package com.craftincode.startspring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int userId = 0;

    static {
        users.add(new User(userId++, "Byczek", "byk00", "siemaema", 2010));
        users.add(new User(userId++, "Byczek2", "byk002", "siemaem2a", 2011));
        users.add(new User(userId++, "Bycze3k2", "byk0302", "siemaem2a3", 2011));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> findUsersByBirthYear(Integer birthYear) {
        return users.stream()
                .filter((u) -> u.getBirthYear().equals(birthYear))
                .collect(Collectors.toList());
    }

    public User getUserById(int id) {
        return users.stream().
                filter((u) -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        user.setId(userId++);
        users.add(user);
    }

    public void updateUserById(int id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setName(user.getName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setBirthYear(user.getBirthYear());
    }

    public void deleteUserById(int id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
