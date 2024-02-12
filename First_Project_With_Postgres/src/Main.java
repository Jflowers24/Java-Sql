import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/practice";
        String user = "postgres";
        String password = "Marvin123+";

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice","postgres", "Marvin123+")){
            System.out.println("successfully Logged in");
        }

        }
    }
