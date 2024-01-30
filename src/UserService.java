import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

    private final List<User> USERS = new ArrayList<>();
    public UserService(){}

    public List<User> getUSERS(){
        return USERS;
    }

    public void addUser(String email, String password){
        USERS.add(new User(email, password, new ArrayDeque<>()));
    }

    public void addBill(User user, Bill bill){
        user.getBills().add(bill);
    }

    public void showBills(User user){
        user.getBills().forEach(bill -> System.out.println("Bill " + "(" + bill.getDate() + ")" +
                " {heating: "+ bill.getHeating() +
                ", hot water: " + bill.getHotWater() +
                ", cold water: " + bill.getColdWater() + "}\n"));
    }

    public void getActual(User user){
        System.out.println(user.getBills().getLast());
    }

    public void showBillsByMonth(User user, int month){
        user.getBills().forEach(bill -> {
            if (bill.getDate().getMonthValue() == month){
                System.out.println(bill.toString());
            }
        });
    }

    public void showHistory(User user){
        user.getBills().forEach(bill -> System.out.println(bill.toString()));
    }



}
