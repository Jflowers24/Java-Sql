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
        String url = "jdbc:postgresql://localhost:5432/HarlemHeritage";
        String user = "postgres";
        String password = "71805Ml$";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("successfully Logged in");
        } catch (SQLException e) {

            System.err.println("Connection error" + e.getErrorCode());
            e.printStackTrace();


        }
        Boolean condition = true;
        while (condition == true) {
            Functions.BookS();
            Functions.TitleS();
            Functions.AuthorS();
            Functions.GenreS();
            Functions.IllustratorS();
            Functions.AllS();
        }





    }
}

