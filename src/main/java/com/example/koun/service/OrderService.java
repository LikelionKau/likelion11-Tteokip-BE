package com.example.koun.Service;

public interface OrderService {

    public Long createOrder(Long userId, Long raffleId);



    public void cancelOrder(Long orderId);


}
