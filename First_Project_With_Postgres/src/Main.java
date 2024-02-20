import java.sql.*;
import java.util.Objects;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = DatabaseConfigurations.getUrl();
        String user = DatabaseConfigurations.getUser();
        String password = DatabaseConfigurations.getPassword();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("successfully Logged in");
            System.out.println("Welcome Back to Harlem Heritage Staff!");
        } catch (SQLException e) {

            System.err.println("Connection error" + e.getErrorCode());
            e.printStackTrace();


        }
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("select [e] to enter. If you would like to quit select [q].");
            String action = userInput.nextLine();
            while (Objects.equals(action, "e")){
                Functions.WelcomeS();
            } if (Objects.equals(action, "q")) {
                break;
            } else {
                break;
            }

        }






    }
}










