import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MonitoringService monitoringService = new MonitoringService();
        start(monitoringService);



    }

    private static String authorization(MonitoringService monitoringService, Scanner in){
        System.out.print("Enter login: ");
        String login = in.next();
        System.out.print("Enter password: ");
        String password = in.next();
        if (!monitoringService.getUsers().containsKey(login)){
            System.out.println("No such User!!! Please try again or exit!");
            return "no";
        }else if (monitoringService.getUsers().get(login).getPassword().equals(password)){
            System.out.println("Success!!!");
            return login;
        }else {
            System.out.println("Wrong password!!!");
            return "wrong";
        }
    }

    private static void run(Scanner in, MonitoringService monitoringService){
        int option = in.nextInt();
        while (option != 0){
            switch (option){
                case 1 ->{
                    System.out.println("Please, choose an option:\n" +
                            "1 - Authorization\n" +
                            "2 - Registration\n" +
                            "0 - Exit");
                    option = in.nextInt();
                    switch (option){
                        case 1 -> {
                            String guest = authorization(monitoringService, in);
                            if (!guest.equals("no") && !guest.equals("wrong")) {
                                while (true){
                                    System.out.println("Please, choose an option:\n" +
                                            "1 - Add bill\n" +
                                            "2 - Show bills\n" +
                                            "3 - Show bills by month\n" +
                                            "4 - Get actual bill\n" +
                                            "0 - Exit");
                                    UserService userService = new UserService();
                                    User user = monitoringService.getUsers().get(guest);
                                    option = in.nextInt();
                                    switch (option){
                                        case 1 -> {
                                            System.out.println("Enter bill!!!");
                                            System.out.println("Heating: ");
                                            double heating = in.nextDouble();
                                            System.out.println("Hot Water: ");
                                            double hotWater = in.nextDouble();
                                            System.out.println("Cold Water: ");
                                            double coldWater = in.nextDouble();
                                            userService.addBill(user, new Bill(heating, hotWater, coldWater, LocalDate.now()));
                                        }
                                        case 2 -> userService.showBills(user);
                                        case 3 -> {
                                            System.out.println("Please, enter the month number:");
                                            int month = in.nextInt();
                                            userService.showBillsByMonth(user, month);
                                        }
                                        case 4 -> {
                                            System.out.println("Actual bill is: ");
                                            userService.getActual(user);
                                        }
                                        case 0 -> System.out.println("Exit...");
                                        default -> System.out.println("No such operation!");
                                    }
                                    if (option == 0){
                                        break;
                                    }

                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Enter your email:");
                            String email = in.next();
                            System.out.println("Enter your password:");
                            String password = in.next();
                            User newUser = new User(email, password, new ArrayDeque<>());
                            monitoringService.getUsers().put(email, newUser);
                            String guest = authorization(monitoringService, in);
                            if (!guest.equals("no") || !guest.equals("wrong")) {
                                while (true){
                                    System.out.println("Please, choose an option:\n" +
                                            "1 - Add bill\n" +
                                            "2 - Show bills\n" +
                                            "3 - Show bills by month\n" +
                                            "4 - Get actual bill\n" +
                                            "0 - Exit");
                                    UserService userService = new UserService();
                                    User user = monitoringService.getUsers().get(guest);
                                    option = in.nextInt();
                                    switch (option){
                                        case 1 -> {
                                            System.out.println("Enter bill!!!");
                                            System.out.println("Heating: ");
                                            double heating = in.nextDouble();
                                            System.out.println("Hot Water: ");
                                            double hotWater = in.nextDouble();
                                            System.out.println("Cold Water: ");
                                            double coldWater = in.nextDouble();
                                            userService.addBill(user, new Bill(heating, hotWater, coldWater, LocalDate.now()));
                                        }
                                        case 2 -> userService.showBills(user);
                                        case 3 -> {
                                            System.out.println("Please, enter the month number:");
                                            int month = in.nextInt();
                                            userService.showBillsByMonth(user, month);
                                        }
                                        case 4 -> {
                                            System.out.println("Actual bill is: ");
                                            userService.getActual(user);
                                        }
                                        case 0 -> System.out.println("Exit...");
                                        default -> System.out.println("No such operation!");
                                    }
                                    if (option == 0){
                                        break;
                                    }

                                }
                            }
                        }
                        case 0 -> System.out.println("Exit...");
                        default -> System.out.println("No such operation!");
                    }
                }
                case 2 -> {
                    //admin
                }
            }
        }
    }

    private static void start(MonitoringService monitoringService){

        Scanner in = new Scanner(System.in);
        System.out.println("Hello! It's Monitoring System!\n" +
                "Please, tell me who you are?\n" +
                "1 - User;\n" +
                "2 - Admin;\n" +
                "0 - Exit.");
        run(in, monitoringService);



    }

}