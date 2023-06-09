package product.service;

import product.Product;

public interface IProductService {
    Product findByPid(Long pid);
}
