    package com.myhamburgerapp.hamburger_restaurant.service;


    import com.myhamburgerapp.hamburger_restaurant.entity.order_entity.Order;
    import com.myhamburgerapp.hamburger_restaurant.repository.OrderRepository;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.PersistenceContext;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class OrderService {
        private final OrderRepository orderRepository;

        @PersistenceContext
        private EntityManager entityManager;

        @Autowired
        public OrderService(OrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

        @Transactional
        public void saveOrderToDB(Order order) {
            orderRepository.saveAndFlush(order);
        }

        public List<Order> showOrderByCustomerId(int customerId) {
            return orderRepository.findAllByCustomer_Id(customerId);
        }


        @Transactional
        public void emptyBasket(int customerId) {
            // Fetch orders first
            List<Order> orders = orderRepository.findAllByCustomer_Id(customerId);

            for (Order order : orders) {
                // Detach from persistence context first
                entityManager.detach(order);

                // Use explicit delete queries
                entityManager.createQuery("DELETE FROM OrderDrink od WHERE od.order.orderId = :orderId")
                        .setParameter("orderId", order.getOrderId())
                        .executeUpdate();

                entityManager.createQuery("DELETE FROM OrderSauce os WHERE os.order.orderId = :orderId")
                        .setParameter("orderId", order.getOrderId())
                        .executeUpdate();

                entityManager.createQuery("DELETE FROM OrderSide os WHERE os.order.orderId = :orderId")
                        .setParameter("orderId", order.getOrderId())
                        .executeUpdate();

                entityManager.createQuery("DELETE FROM OrderHamburger oh WHERE oh.order.orderId = :orderId")
                        .setParameter("orderId", order.getOrderId())
                        .executeUpdate();

                // Finally delete the order
                entityManager.createQuery("DELETE FROM Order o WHERE o.orderId = :orderId")
                        .setParameter("orderId", order.getOrderId())
                        .executeUpdate();
            }

            entityManager.flush();
        }
    }
