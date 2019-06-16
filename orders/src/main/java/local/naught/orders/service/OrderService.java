package local.naught.orders.service;

import local.naught.orders.model.Orders;

import java.util.ArrayList;

public interface OrderService {
    ArrayList<Orders> findAll();
    Orders save(Orders order);
}
