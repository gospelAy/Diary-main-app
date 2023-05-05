import java.util.Scanner;

import static java.lang.System.exit;


public class Main {
    private static User user = new User();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        userDiary();
    }

    private static void userDiary() {
        System.out.println("""
                Select an option
                1 Register
                2 Login
                3 exit
                """);
        int option = scanner.nextInt();
        switch (option){
            case 1 -> register();
            case 2 -> login();
            case 3 -> exit(3);
        }
    }

    private static void login() {
        print("Enter your email");
        String email = scanner.nextLine();
        scanner.next();
        print("Enter your password");
        String password = scanner.nextLine();
        scanner.next();
      User log = user.login(email, password);
      diary(email);
    }

    private static void diary(String email) {
        System.out.println("""
                Select an option
                1 Add new diary content
                2 update
                3 Find Content By Date
                """);
        int option = scanner.nextInt();
        switch (option){
            case 1 -> addDiaryContent(email);
            case 2 -> update(email);
            case 3 -> findContentByDate(email);
        }
    }

    private static void update(String email) {
    }

    private static void findContentByDate(String email) {
        print("Enter Date");
        String date = scanner.next();
        scanner.nextLine();
        System.out.println(user.findContentByDate(date, email));
    }

    private static void addDiaryContent(String email) {
        print("Enter Diary Title");
        String title = scanner.next();
        scanner.nextLine();
        print("Enter Diary Body");
        String body = scanner.next();
        scanner.nextLine();
        user.createDiaryContent(title, body,email);
        diary(email);
    }

    private static void register() {
        print("Enter your email");
        String email = scanner.nextLine();
        scanner.next();
        print("Enter your password");
        String password = scanner.nextLine();
        scanner.next();
        user.register(email, password);
        System.out.println("Registration successful");
        userDiary();
    }
    private static void print(String message){
        System.out.println(message);
    }
}