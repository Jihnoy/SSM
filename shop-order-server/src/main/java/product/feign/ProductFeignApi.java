package product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import product.Product;

@FeignClient(name = "product-service")
public interface ProductFeignApi {
    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable("pid") Long pid);
}
