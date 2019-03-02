package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;

public class AppInit {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        CustomerLogger simpleCustomeLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
//        simpleCustomeLogger.log();

        Customer customer1 = new Customer(1,"Janusz","Wolski");
        Customer customer2 = new Customer(2,"Wioletta","Anders");
        Customer customer3 = new Customer(3,"Arkadiusz","Malinowski");
//
//
        CustomerRepository memoryCustomerRepository = context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        memoryCustomerRepository.addCustomer(customer1);
        memoryCustomerRepository.addCustomer(customer2);
        memoryCustomerRepository.addCustomer(customer3);

        memoryCustomerRepository.deleteCustomer(customer1);
        System.out.println(memoryCustomerRepository.getAllCustomers());

//        CustomerLogger dbCustomerLogger = context.getBean("DBCustomerLogger", DBCustomerLogger.class);
//        dbCustomerLogger.log();

//            CustomerRepository customerRepository = context.getBean("DBCustomerRepository", DBCustomerRepository.class);
//            customerRepository.addCustomer(customer1);
//            customerRepository.addCustomer(customer2);
//            customerRepository.addCustomer(customer3);
//            customerRepository.deleteCustomer(customer2);
//            System.out.println(customerRepository.getAllCustomers());
    }
}
