package product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import product.domain.Order;

public interface OrderDao extends JpaRepository<Order, Long> {
}
