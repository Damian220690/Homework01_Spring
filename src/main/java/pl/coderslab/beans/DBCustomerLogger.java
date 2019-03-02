package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

@Component
@Qualifier
public class DBCustomerLogger implements CustomerLogger {

    @Autowired
    DBConnector dbConnector;

    @Override
    public void log() {
        try(Connection connection = DBConnector.getConnection("logsDB")){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS customers(id INT , firstName VARCHAR(30), lastName VARCHAR(40))");
            System.out.println(LocalDateTime.now() + ": Customer operation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
