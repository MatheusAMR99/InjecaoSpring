package com.projeto.injecaoDependecia.services;

import com.projeto.injecaoDependecia.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double discountValue = order.getBasic() - (order.getBasic() * (order.getDicount() / 100));

        return discountValue + shippingService.shipment(order);
    }
}
