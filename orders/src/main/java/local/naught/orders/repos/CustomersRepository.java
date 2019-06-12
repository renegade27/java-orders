package local.naught.orders.repos;

import local.naught.orders.model.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
    Customers save(Customers customer);
    ArrayList<Customers> findAll();
    Customers findCustomersByCustname(String name);
}
