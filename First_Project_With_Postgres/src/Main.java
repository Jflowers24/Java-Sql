import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/HarlemHeritage";
        String user = "postgres";
        String password = "Hope_2023";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HarlemHeritage", "postgres", "Hope_2023")) {
            System.out.println("successfully Logged in");
            System.out.println("Welcome Back to Harlem Heritage Staff!");
        } catch (SQLException e) {

            System.err.println("Connection error" + e.getErrorCode());
            e.printStackTrace();


        }
        Boolean condition = true;
        while (condition == true) {

            Functions.WelcomeS();
        }






    }
}










