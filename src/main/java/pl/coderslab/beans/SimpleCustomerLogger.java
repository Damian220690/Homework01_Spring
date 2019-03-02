package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Qualifier
public class SimpleCustomerLogger implements CustomerLogger {
    @Override
    public void log() {
        System.out.println(LocalDateTime.now() +": Customer operation");
    }
}
