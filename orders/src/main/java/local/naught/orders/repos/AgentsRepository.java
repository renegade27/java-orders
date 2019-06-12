package local.naught.orders.repos;

import org.springframework.data.repository.CrudRepository;
import local.naught.orders.model.Agents;

public interface AgentsRepository extends CrudRepository<Agents, Long>{
}
