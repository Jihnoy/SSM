package product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import product.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
