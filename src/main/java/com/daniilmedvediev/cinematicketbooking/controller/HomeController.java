package com.daniilmedvediev.cinematicketbooking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Cinema Ticket Booking System is Running!";
    }
}
