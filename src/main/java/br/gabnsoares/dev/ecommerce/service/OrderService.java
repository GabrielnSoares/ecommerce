package br.gabnsoares.dev.ecommerce.service;

import br.gabnsoares.dev.ecommerce.controller.dto.CreateOrderDto;
import br.gabnsoares.dev.ecommerce.controller.dto.OrderItemDto;
import br.gabnsoares.dev.ecommerce.entities.*;
import br.gabnsoares.dev.ecommerce.exception.CreateOrderException;
import br.gabnsoares.dev.ecommerce.repository.OrderRepository;
import br.gabnsoares.dev.ecommerce.repository.ProductRepository;
import br.gabnsoares.dev.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(UserRepository userRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDto dto) {

        var order = new OrderEntity();

        // 1. Validate User
        var user = validateUser(dto);

        // 2. Validate Order Items
        var orderItems = validateOrderItems(order, dto);

        // 3. Calculate order total
        var total =  calculateOrderTotal(orderItems);

        // 4. Map to Entity
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItems(orderItems);
        order.setTotal(total);

        // 5. Repository save
        return orderRepository.save(order);
    }

    private UserEntity validateUser(CreateOrderDto dto) {
        return userRepository.findById(dto.userId())
                .orElseThrow(() -> new CreateOrderException("user not found"));
    }

    private List<OrderItemEntity> validateOrderItems(OrderEntity order,
                                                     CreateOrderDto dto) {

        if (dto.items().isEmpty()) {
            throw new CreateOrderException("order items is empty");
        }

        return dto.items()
                .stream()
                .map(ordemItemDto -> getOrderItem(order, ordemItemDto))
                .toList();

    }

    private OrderItemEntity getOrderItem(OrderEntity order,
                                         OrderItemDto ordemItemDto) {

        var orderItemEntity = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(ordemItemDto.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItemEntity.setId(id);
        orderItemEntity.setQuantity(ordemItemDto.quantity());
        orderItemEntity.setSalePrice(product.getPrice());

        return orderItemEntity;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CreateOrderException("product not found"));
    }

    private BigDecimal calculateOrderTotal(List<OrderItemEntity> items) {
        return items.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}

