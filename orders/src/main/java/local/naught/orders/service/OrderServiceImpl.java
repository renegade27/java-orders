package local.naught.orders.service;

import local.naught.orders.model.Orders;
import local.naught.orders.repos.CustomersRepository;
import local.naught.orders.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepository restrepos;

    @Override
    public ArrayList<Orders> findAll() {
        ArrayList<Orders> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Orders save(Orders order) {
        Orders newOrder = new Orders();
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setAgent(order.getAgent());
        newOrder.setCustomer(order.getCustomer());
        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setOrdnum(order.getOrdnum());
        return restrepos.save(newOrder);
    }

}
