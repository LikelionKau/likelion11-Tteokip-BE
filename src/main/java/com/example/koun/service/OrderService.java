package com.example.koun.service;

public interface OrderService {

    public Long createOrder(Long userId, Long raffleId);



    public void cancelOrder(Long orderId);


}
