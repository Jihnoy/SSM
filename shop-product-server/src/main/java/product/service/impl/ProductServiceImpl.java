package product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.Product;
import product.dao.ProductDao;
import product.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Long pid){
        return productDao.findById(pid).get();
    }
}
