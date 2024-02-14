import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;



public class Functions {
    public static void BookS(){
        BookCreation Books = new BookCreation() {
            @Override
            public void bookMake() {
                Scanner userInput = new Scanner(System.in);
                String url = "jdbc:postgresql://localhost:5432/HarlemHeritage";
                String user = "postgres";
                String password = "71805Ml$";

                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("You will be creating a book instance");
                    System.out.print("Enter Book Title:");
                    String title = userInput.nextLine();
                    System.out.print("Enter Book Author:");
                    String author = userInput.nextLine();
                    System.out.print("Enter Book Illustrator:");
                    String illustrator = userInput.nextLine();
                    System.out.print("Enter Book Genre:");
                    String genre = userInput.nextLine();
                    System.out.print("Enter Book Number of Pages:");
                    int pagenum = userInput.nextInt();
                    String sql = "INSERT INTO books(author, illustrator, genre, pagenum, title) VALUES (?,?,?,?,?)";

                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1,author);
                        statement.setString(2,illustrator);
                        statement.setString(3,genre);
                        statement.setInt(4,pagenum);
                        statement.setString(5,title);
                        statement.executeUpdate();
                        statement.close();


                    } catch (SQLException e) {
                        System.out.println("Connection error: " + e.getErrorCode());
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            };
        Books.bookMake();
        }
}


interface BookCreation {
    void bookMake();
}

