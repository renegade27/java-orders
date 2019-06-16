package local.naught.orders.service;

import local.naught.orders.model.Agents;
import local.naught.orders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentsRepository restrepos;

    @Override
    public Agents save(Agents agent) {
        Agents newAgent = new Agents();
        newAgent.setAgentcode(agent.getAgentcode());
        newAgent.setAgentname(agent.getAgentname());
        newAgent.setCommission(agent.getCommission());
        newAgent.setCountry(agent.getCountry());
        newAgent.setCustomers(agent.getCustomers());
        newAgent.setOrders(agent.getOrders());
        newAgent.setPhone(agent.getPhone());
        newAgent.setWorkingarea(agent.getWorkingarea());
        return restrepos.save(newAgent);
    }
}
