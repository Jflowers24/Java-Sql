import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/practice";
        String user = "postgres";
        String password = "Marvin123+";

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HarlemHeritage", "postgres", "71805Ml$")) {
            System.out.println("successfully Logged in");
        } catch (SQLException e) {

            System.err.println("Connection error" + e.getErrorCode());
            e.printStackTrace();


        }
        Functions.BookS();






    }
}

