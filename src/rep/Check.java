package rep;

import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

public class Check {

    static ArrayList<User> users = new ArrayList<>();




    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        users.add(new User("Sanjarbek", "Pass200", true ));

        registration();
    }

    public static void registration() {
        while (true){
            System.out.print("Master registration :\n" +
                    "1. Sign up \n"+
                    "2. Sign in \n" +
                    "?: " );
            String option = scanner.nextLine();
            switch (option){
                case "1" -> {
                    isRightData();
                }
                case "2" ->{
                    login();
                }

                case "0" ->{
                    return;
                }

                default -> {
                    System.out.println("Invalid value try again");
                    continue;
                }

            }
        }

    }

    public static void isRightData(){
        String name;
        String password;
        while(true) {

                System.out.print("Your full name (e.x.  Steve Jobs ) : ");
                name= scanner.nextLine();
                Pattern patternName = Pattern.compile(" +( )");
                Matcher matcherName = patternName.matcher(name);
                if (matcherName.matches()) {
                    System.out.println("Name cannot cosist of numbers or Symbols");
                    continue;
                }
                break;

            }

           while (true){
                System.out.print("Your full name (e.x.  Steve Jobs ) : ");
                System.out.println("Password must consist of (Capital letters, symbols, and size must be no  more than 8 characters) \n ");
                password = scanner.nextLine();
                Pattern patternPassword = Pattern.compile("(\\d & \\s)");
                Matcher matcherPassword = patternPassword.matcher(password);
                if ((password.length() >= 8) && matcherPassword.matches()) {
                    System.out.println("Password must consist of (Capital letters, symbols, and size must be no  more than 8 characters) ");
                    continue;
                }
                break;
            }
            users.add(new User(name, password,false));
//        System.out.println(users);
        System.out.println("Success!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
    public static void login(){
        System.out.println("Full name : ");
        String name = scanner.nextLine();
        String password="";
        User nowUser = new User();
        boolean isUser=false;
        for (User user : users) {
            if(name.equals(user.getFullName())){
                nowUser=user;
                password=user.getPassword();
                isUser=true;
                break;
            }
        }
        if ( !isUser){
            System.out.println("Name not found try again");
            login();
        }

        while (true) {
            System.out.println("Password : ");
            String uiPass = scanner.nextLine();
            if(!uiPass.equals(password)){
                System.out.println("Password is incorrect!!");
                continue;
            }
            break;
        }
        if(nowUser.isAdmin()){
            System.out.println("You are admin now!!!");
            adminPanel(nowUser);
        }
        System.out.println("Successfully signed in!!!!!!");
        userPanel(nowUser);
    }

    private static void userPanel(User user){
        System.out.println("You are" + user  +" now : ");
        while (true){
            System.out.print("Master action :\n" +
                    "1. exit \n"+
                    "?: " );
            String option = scanner.nextLine();
            switch (option){


                case "1" ->{
                    return;
                }

                default -> {
                    System.out.println("Invalid value try again");
                    continue;
                }

            }
        }

    }

    private static void adminPanel(User user){

        System.out.println("You are" + user  +" now : ");
        while (true){
            System.out.print("Master action :\n" +
                            "1. exit \n" +
                    "2. user list "+
                    "?: " );
            String option = scanner.nextLine();
            switch (option){


                case "1" ->{
                    return;
                }
                case "2" ->{
                    System.out.println(user);
                }

                default -> {
                    System.out.println("Invalid value try again");
                    continue;
                }

            }
        }
    }
}


