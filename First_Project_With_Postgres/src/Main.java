import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);
        String url = DatabaseConfigurations.getUrl();
        String user = DatabaseConfigurations.getUser();
        String password = DatabaseConfigurations.getPassword();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("successfully Logged in");
        } catch (SQLException e) {

            System.err.println("Connection error" + e.getErrorCode());
            e.printStackTrace();


        }
        Boolean condition = true;
        while (condition == true) {
            Functions.WelcomeS();
            Functions.TitleS();
            Functions.AuthorS();
            Functions.GenreS();
            Functions.IllustratorS();
            Functions.AllS();
        }





    }
}

