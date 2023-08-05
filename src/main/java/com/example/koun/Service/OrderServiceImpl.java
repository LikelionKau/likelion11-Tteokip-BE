package com.example.koun.Service;

import com.example.koun.Repository.OrderRepository;
import com.example.koun.domain.Order;
import com.example.koun.domain.Raffle;
import com.example.koun.domain.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RaffleRepository raffleRepository;



    @Override
    public Long createOrder(Long userId, Long raffleId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Raffle> optionalRaffle = raffleRepository.findById(raffleId);
        Raffle raffle = raffleRepository.findById(raffleId);
        if (optionalUser.isPresent() && optionalRaffle.isPresent()
            && raffle.getRaffleStatus() == "T") {       //이거 맞나?
            User findUser = optionalUser.get();
            Raffle findRaffle = optionalRaffle.get();
            Order order = Order.builder().user(findUser).raffle(findRaffle).build();
            orderRepository.save(order);
            return order.getId();

        } else {
            throw new IllegalAccessException("잘못된 요청입니다.");
        }

    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order findOrder = optionalOrder.get();
            orderRepository.delete(findOrder);

        }
    }
}
