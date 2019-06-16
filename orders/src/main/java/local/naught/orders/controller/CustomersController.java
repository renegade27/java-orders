package local.naught.orders.controller;

import local.naught.orders.model.Customers;
import local.naught.orders.model.Orders;
import local.naught.orders.service.AgentService;
import local.naught.orders.service.CustomerService;
import local.naught.orders.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/orders")
    public ResponseEntity<?> findAllCustomers() {
        ArrayList<Customers> custList = customerService.findAll();
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

    @GetMapping(value="/name/{name}")
    public ResponseEntity<?> findCustomerOrders(@PathVariable String name) {
        List<Orders> list = customerService.findCustomersByCustname(name).getOrders();
        if(list.size() == 0) {
            return new ResponseEntity<>("No orders found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerService.findCustomersByCustname(name).getOrders(), HttpStatus.OK);
        }
    }

    @PostMapping(value="/data/customer/new")
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer) {
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/data/customer/delete/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode) {
        customerService.deleteByCustcode(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/data/customer/update/{custcode}")
    public ResponseEntity<?> updateCustomerById(@Valid @RequestBody Customers updateCustomer, @PathVariable long custcode) {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
}
