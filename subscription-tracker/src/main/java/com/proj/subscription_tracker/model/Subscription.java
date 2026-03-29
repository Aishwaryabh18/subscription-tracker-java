package com.proj.subscription_tracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "subscriptions")
@Data
public class Subscription {

    @Id
    private String id;

    private String name;
    private Double price;
    private String renewalDate;
    private String userId;
}