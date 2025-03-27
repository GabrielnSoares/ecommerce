package br.gabnsoares.dev.ecommerce.service;

import br.gabnsoares.dev.ecommerce.repository.OrderItemRepository;
import br.gabnsoares.dev.ecommerce.repository.OrderRepository;
import br.gabnsoares.dev.ecommerce.repository.ProductRepository;
import br.gabnsoares.dev.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(UserRepository userRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository,
                        OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }
}
