package net.javaguides.orderservices.controller;

import net.javaguides.basedomain.dto.Order;
import net.javaguides.basedomain.dto.OrderEvent;
import net.javaguides.orderservices.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderevent = new OrderEvent();
       // orderevent.setStatus("PENDING");
        //orderevent.setMessage("order status is in pending status");
        orderevent.setOrder(order);
        orderProducer.sendMessages(orderevent);
        return "Order Placed Successfully";
    }
}
