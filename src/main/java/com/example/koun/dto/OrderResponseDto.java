package com.example.koun.dto;


import com.example.koun.domain.Order;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponseDto {
    private Long id;
    private LocalDateTime orderDate;
    private String address;


    /*사용자에게 보여지는 주문의 정보는 id,주문날짜,주소만 있으면 되니까 */
    public OrderResponseDto(Order entity) {
        this.id = entity.getId();
        this.orderDate = entity.getOrderDate();
        this.address = entity.getAddress();
    }

}
