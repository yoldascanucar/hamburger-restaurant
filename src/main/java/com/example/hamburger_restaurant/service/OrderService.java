    package com.example.hamburger_restaurant.service;


    import com.example.hamburger_restaurant.entity.order_entity.Order;
    import com.example.hamburger_restaurant.repository.OrderRepository;
    import jakarta.servlet.http.HttpSession;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class OrderService {
        private final OrderRepository orderRepository;

        @Autowired
        public OrderService(OrderRepository orderRepository){
            this.orderRepository = orderRepository;
        }

        // database'e kaydedip session oluşturma
        @Transactional
        public void saveOrderToDB(Order order) {
            orderRepository.saveAndFlush(order);
        }

        public List<Order> showOrderByCustomerId(int customerId) {
           return orderRepository.findAllByCustomer_Id(customerId);
        }
    }
