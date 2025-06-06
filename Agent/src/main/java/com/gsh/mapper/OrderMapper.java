package com.gsh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsh.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.gsh.mapper
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 20:23
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
