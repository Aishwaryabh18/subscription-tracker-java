package com.proj.subscriptionTracker.controller;

import com.proj.subscriptionTracker.model.Subscription;
import com.proj.subscriptionTracker.service.SubscriptionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping
    public Subscription create(@RequestBody Subscription sub, HttpServletRequest req) {
        String userId = (String) req.getAttribute("userId");
        sub.setUserId(userId);
        return service.create(sub);
    }

    @GetMapping
    public List<Subscription> getAll(HttpServletRequest req) {
        String userId = (String) req.getAttribute("userId");
        return service.getUserSubs(userId);
    }
}