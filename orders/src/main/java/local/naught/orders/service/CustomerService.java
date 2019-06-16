package local.naught.orders.service;

import local.naught.orders.model.Customers;

import java.util.ArrayList;

public interface CustomerService {
    Customers save(Customers customer);
    ArrayList<Customers> findAll();
    Customers findCustomersByCustname(String name);
    void deleteByCustcode (long id);
    Customers update(Customers customer, long id);
}
