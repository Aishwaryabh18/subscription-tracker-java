package com.proj.subscription_tracker.repository;

import com.proj.subscription_tracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository  extends MongoRepository<User, String> {

    User findByEmail(String email);

}