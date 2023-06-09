package product.contoller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.Product;
import product.service.IProductService;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @RequestMapping("/product/{pid}")
    public Product findBypid(@PathVariable("pid") Long pid){
        log.info("接下来要进⾏{}号商品信息的查询", pid);
        Product product = iProductService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}
