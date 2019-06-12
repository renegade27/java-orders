package local.naught.orders.service;

import local.naught.orders.model.Customers;
import local.naught.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomersRepository restrepos;

    @Override
    public ArrayList<Customers> findAll() {
        ArrayList<Customers> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomersByCustname(String name) {
        return restrepos.findCustomersByCustname(name);
    }

    @Override
    public void deleteByCustcode(long id) {
        if(restrepos.findById(id).isPresent()) {
            restrepos.deleteById(id);
        }
        else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Customers update(Customers customer, long id) {
        Customers currentCustomer = restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if(customer.getCustname() != null) {
            currentCustomer.setCustname(customer.getCustname());
        }
        if(customer.getCustcity() != null) {
            currentCustomer.setCustcity(customer.getCustcity());
        }
        if(customer.getCustname() != null) {
            currentCustomer.setCustname(customer.getCustname());
        }
        if(customer.getCustcountry() != null) {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }
        if(customer.getGrade() != null) {
            currentCustomer.setGrade(customer.getGrade());
        }
        if(customer.getOpeningamt() != 0.0) {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if(customer.getPaymentamt() != 0.0) {
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if(customer.getOutstandingamt() != 0.0) {
            currentCustomer.setOutstandingamt(customer.getOutstandingamt());
        }
        if(customer.getPhone() != null) {
            currentCustomer.setPhone(customer.getPhone());
        }
        if(customer.getReceiveamt() != 0.0) {
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if(customer.getWorkingarea() != null) {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if(customer.getOrders().size() > 0) {
            currentCustomer.getOrders().clear();
            currentCustomer.getOrders().addAll(customer.getOrders());
        }
        if(customer.getAgent() != null) {
            currentCustomer.setAgent(customer.getAgent());
        }
        return restrepos.save(currentCustomer);
    }

    @Transactional
    @Override
    public Customers save(Customers customer) {
        Customers newCustomer = new Customers();
        newCustomer.setAgent(customer.getAgent());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcode(customer.getCustcode());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setOrders(customer.getOrders());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        return restrepos.save(newCustomer);
    }
}
