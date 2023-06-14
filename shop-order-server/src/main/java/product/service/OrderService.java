package product.service;

import product.domain.Order;

public interface OrderService {
    Order createOrder(Long productId, Long userId);
}
