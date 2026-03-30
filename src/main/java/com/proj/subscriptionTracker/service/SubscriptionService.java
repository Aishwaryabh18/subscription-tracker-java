package com.proj.subscriptionTracker.service;

import com.proj.subscriptionTracker.model.Subscription;
import com.proj.subscriptionTracker.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repo;

    public Subscription create(Subscription sub) {
        return repo.save(sub);
    }

    public List<Subscription> getUserSubs(String userId) {
        return repo.findByUserId(userId);
    }
}
