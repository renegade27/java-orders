package local.naught.orders.repos;

import local.naught.orders.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
