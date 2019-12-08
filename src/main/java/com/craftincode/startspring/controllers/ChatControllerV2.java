package com.craftincode.startspring.controllers;

import com.craftincode.startspring.model.ChatMessage;
import com.craftincode.startspring.model.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ChatControllerV2 {
    ChatService chatService = new ChatService();

    @RequestMapping (method = RequestMethod.GET, value = "/v2/chat")
    @ResponseBody
    public String getAllMessages(@RequestParam(required = false) String author,
    @RequestParam (required = false) String dateFrom,
                                 @RequestParam (required = false) String dateTo) {
        //CharServiceFilter todo
        List<ChatMessage> filteredMessages = chatService.getAllMessages();

        if (author != null) {
            Predicate<ChatMessage> predicate = chatMessage -> chatMessage.getAuthor().equals(author);
            filteredMessages = chatService.filterList(filteredMessages, predicate);
        }
        if (dateFrom != null) {
            OffsetDateTime dateFromODT = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
            Predicate<ChatMessage> predicate = chatMessage -> chatMessage.getDate().isAfter(dateFromODT);
            filteredMessages = chatService.filterList(filteredMessages, predicate);
        }
        if (dateTo != null) {
            OffsetDateTime dateToODT = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
            Predicate<ChatMessage> predicate = chatMessage -> chatMessage.getDate().isBefore(dateToODT);
            filteredMessages = chatService.filterList(filteredMessages, predicate);
        }
        return filteredMessages.toString();
    }

    @RequestMapping (method = RequestMethod.POST, value = "/v2/chat")
    @ResponseBody
    public String addMessage(@RequestBody String chatMessage) {
        ChatMessage message = new ChatMessage("Pretkej", chatMessage);
        chatService.addMessage(message);
        return chatMessage;
    }

    @RequestMapping (method = RequestMethod.DELETE, value = "/v2/chat/{index}")
    @ResponseBody
    public String deletedSpecifiedMessage(@PathVariable int index) {
        chatService.removeMessageByIndex(index);
        return "Messege with index " + index + " has been deleted";
    }
}
