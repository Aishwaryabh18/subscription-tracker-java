package com.proj.subscriptionTracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    private String id;

    private String userId;
    private String name;
    private Double price;
    private String billingCycle;
    private String nextBillingDate;
}