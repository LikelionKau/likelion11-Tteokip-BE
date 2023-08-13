package com.example.koun.dto;

import com.example.koun.domain.DeliveryStatus;
import com.example.koun.domain.Order;
import com.example.koun.domain.Raffle;
import com.example.koun.domain.User;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderSaveRequestDto {
    private LocalDateTime orderDate;
    private DeliveryStatus deliveryStatus;
    private String address;
    private Long userId;
    private Long raffleId;


    @Builder
    public OrderSaveRequestDto(LocalDateTime orderDate, DeliveryStatus deliveryStatus,
        String address, Long userId, Long raffleId) {

        this.orderDate = orderDate;
        this.deliveryStatus = deliveryStatus;
        this.address = address;
        this.userId = userId;
        this.raffleId = raffleId;
    }


    public Order toEntity(User user , Raffle raffle){
        return Order.builder()
            .orderDate(orderDate)
            .deliveryStatus(deliveryStatus)
            .address(address)
            .user(user)
            .raffle(raffle)
            .build();
    }

}
