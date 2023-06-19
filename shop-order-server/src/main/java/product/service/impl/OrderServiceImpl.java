package product.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import product.Product;
import product.dao.OrderDao;
import product.domain.Order;
import product.feign.ProductFeignApi;
import product.service.OrderService;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductFeignApi productFeignApi;
    @Override
    public Order createOrder(Long productId, Long userId){
        Product product = productFeignApi.findByPid(productId);
        log.info("查询到{}号商品的信息,内容是:{}", productId,
                JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(userId);
        order.setUsername("叩丁狼教育");
        order.setPid(productId);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }
}
