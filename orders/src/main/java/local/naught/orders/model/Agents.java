package local.naught.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agents
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;
    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private List<Customers> customers = new ArrayList<>();

    @OneToMany(mappedBy = "agent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();

    public Agents()
    {
    }

    public Agents(String agentname, String workingarea, double commission, String phone, String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getAgentname()
    {
        return agentname;
    }

    public void setAgentname(String agentname)
    {
        this.agentname = agentname;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public List<Customers> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customers> customers)
    {
        this.customers = customers;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }
}
