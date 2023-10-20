import java.time.LocalDateTime;

public class ConsoleLogger implements ConnectLogger {

    @Override
    public void print(String msg) {
        System.out.println(LocalDateTime.now() + " : " +  msg);
    } 
}