package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier
public class MemoryCustomerRepository implements CustomerRepository{

    @Autowired
    @Qualifier("fileCustomerLogger")
    private CustomerLogger customerLogger;

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerLogger.log();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
        customerLogger.log();
    }

    @Override
    public List<Customer> getAllCustomers() {
        customerLogger.log();
        return customers;
    }
}
