package com.gsh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsh.entity.Order;
import com.gsh.mapper.OrderMapper;
import com.gsh.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * ClassName: OrderServiceImpl
 * Package: com.gsh.service.impl
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 20:27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public Order getOne(Order order) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId, order.getUserId());
        queryWrapper.eq(Order::getVoucherId, order.getVoucherId());
        Order orderDB = baseMapper.selectOne(queryWrapper);
        return orderDB;
    }
}
