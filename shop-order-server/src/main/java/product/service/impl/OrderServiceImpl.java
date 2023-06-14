package product.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.Product;
import product.dao.OrderDao;
import product.domain.Order;
import product.service.OrderService;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order createOrder(Long productId, Long userId){
        log.info("接收到{}号商品的下单请求,接下来调⽤商品微服务查询此商品信息", productId);
        Product product = null;
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
