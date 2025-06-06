package com.gsh.tools;

import com.gsh.entity.Order;
import com.gsh.service.OrderService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: OrderTools
 * Package: com.gsh.tools
 * Description:
 *
 * @Author Gush
 * @Create 2025/5/20 20:46
 */
@Component
public class OrderTools {
    @Autowired
    private OrderService orderService;
    @Tool(name="cancel_order", value = "根据参数，查询订单是否存在，如果存在则删除订单记录并返回取消订单成功，否则返回取消订单失败。")
    public String cancelOrder(Order order) {
        //查找数据库中是否包含对应的预约记录
        Order orderDB = orderService.getOne(order);
        if(orderDB != null){
            //删除
            if(orderService.removeById(orderDB.getId())){
                return "取消订单成功";
            }else{
                return "取消订单失败";
            }
        }
        return "未查到订单记录，请核对订单号。";
    }
}
