package com.gsh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsh.entity.Order;
import dev.langchain4j.service.spring.AiService;
import org.springframework.stereotype.Service;

/**
 * ClassName: OrderService
 * Package: com.gsh.service
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 20:26
 */
public interface OrderService extends IService<Order> {
    Order getOne(Order order);
}
