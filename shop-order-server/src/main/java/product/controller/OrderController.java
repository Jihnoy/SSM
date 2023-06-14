package product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.dao.OrderDao;
import product.domain.Order;
import product.service.OrderService;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/save")
    public Order order(Long pid, Long uid){
        return orderService.createOrder(pid, uid);
    }
}
