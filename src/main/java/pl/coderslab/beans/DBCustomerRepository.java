package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBCustomerRepository implements CustomerRepository {
    @Autowired
    @Qualifier("DBCustomerLogger")
    private CustomerLogger customerLogger;


    @Override
    public void addCustomer(Customer customer) {
        customerLogger.log();
        try(Connection connection = DBConnector.getConnection("logsDB")){
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO customers(id,firstName, lastName) VALUES"+
                    "('"+ customer.getId()+"','"+customer.getFirstName()+"','" +customer.getLastName()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerLogger.log();
        try(Connection connection = DBConnector.getConnection("logsDB")){
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM customers WHERE id =" + customer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerLogger.log();
        try(Connection connection = DBConnector.getConnection("logsDB")){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                customers.add(new Customer(id,firstName,lastName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
