import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class User {

    private String email;
    private String password;

    private Deque<Bill> bills;

    public User(String email, String password, Deque<Bill> bills){
        this.email = email;
        this.password = password;
        this.bills = bills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Deque<Bill> getBills() {
        return bills;
    }
}
