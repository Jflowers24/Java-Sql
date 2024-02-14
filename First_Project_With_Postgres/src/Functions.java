import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;



public class Functions {

    static Scanner userInput = new Scanner(System.in);

    public static void OwnerS(){
        ViewOwnerOfBooK Owners = new ViewOwnerOfBooK() {
            @Override
            public void ViewOwner() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try{
                    connection = DriverManager.getConnection(url, user, password);
                    String author = userInput.nextLine();
                    String sql = "SELECT * From Boo";




                }catch (SQLException e){

                }
            }
        };
        Owners.ViewOwner();
    }

    public static void AllS(){
        ViewDatabase Views = new ViewDatabase(){
            @Override
            public void ViewAllBooks(){
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(url,user, password);

                    String author = userInput.nextLine();
                    String sql = "SELECT * FROM library.books";
                    try(PreparedStatement statement = connection.prepareStatement(sql)){
                        ResultSet resultSet = statement.executeQuery();{
                            while (resultSet.next()){
                                String btitle = resultSet.getString("title");
                                String Author = resultSet.getString("author");
                                String illustrator = resultSet.getString("illustrator");
                                String genre = resultSet.getString("genre");
                                int pagenum = resultSet.getInt("pagenum");

                                System.out.println(" Title: " + btitle + " Author: " + Author + " Illustrator: " + illustrator + " Genre: " + genre + " Number of pages: " + pagenum);

                            }
                        }
                    }

                }catch (SQLException e){


                }

            }
        };
        Views.ViewAllBooks();
    }

    public static void IllustratorS(){
        illustratorSearch Illustrators = new illustratorSearch() {
            @Override
            public void ByIllustrator() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try{
                    connection = DriverManager.getConnection(url,user, password);
                    System.out.println("Enter Author's name:");
                    String author = userInput.nextLine();
                    String sql = "SELECT * FROM library.books WHERE illustrator = (?)";

                    try(PreparedStatement statement = connection.prepareStatement(sql)){
                        statement.setString(1,author);
                        ResultSet resultSet = statement.executeQuery();{
                            while (resultSet.next()){
                                String btitle = resultSet.getString("title");
                                String Author = resultSet.getString("author");
                                String illustrator = resultSet.getString("illustrator");
                                String genre = resultSet.getString("genre");
                                int pagenum = resultSet.getInt("pagenum");

                                System.out.println(" Title: " + btitle + " Author: " + Author + " Illustrator: " + illustrator + " Genre: " + genre + " Number of pages: " + pagenum);
                            }
                        }
                    }


                }catch (SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }

            }
        }; {
            Illustrators.ByIllustrator();
        }

    }

    public static void GenreS(){
        GenreSearch Genres = new GenreSearch() {
            public void ByGenre(){
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try{
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Enter Desired Genre");
                    String Genre = userInput.nextLine();
                    String sql = "SELECT * FROM library.books WHERE genre = (?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)){
                        statement.setString(1,Genre);
                        ResultSet resultSet = statement.executeQuery();{
                            while (resultSet.next()){
                                String btitle = resultSet.getString("title");
                                String Author = resultSet.getString("author");
                                String illustrator = resultSet.getString("illustrator");
                                String genre = resultSet.getString("genre");
                                int pagenum = resultSet.getInt("pagenum");

                                System.out.println(" Title: " + btitle + " Author: " + Author + " Illustrator: " + illustrator + " Genre: " + genre + " Number of pages: " + pagenum);
                            }
                        }
                    }
                }catch (SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }
        };
        Genres.ByGenre();
    }

    public static void AuthorS(){
        SearchBookAuthor Authors = new SearchBookAuthor() {
            @Override
            public void ByAuthor() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try{
                    connection = DriverManager.getConnection(url,user, password);
                    System.out.println("Enter Author's name:");
                    String author = userInput.nextLine();
                    String sql = "SELECT * FROM library.books WHERE author = (?)";

                    try(PreparedStatement statement = connection.prepareStatement(sql)){
                        statement.setString(1,author);
                        ResultSet resultSet = statement.executeQuery();{
                            while (resultSet.next()){
                                String btitle = resultSet.getString("title");
                                String Author = resultSet.getString("author");
                                String illustrator = resultSet.getString("illustrator");
                                String genre = resultSet.getString("genre");
                                int pagenum = resultSet.getInt("pagenum");

                                System.out.println(" Title: " + btitle + " Author: " + Author + " Illustrator: " + illustrator + " Genre: " + genre + " Number of pages: " + pagenum);
                            }
                        }
                    }


                }catch (SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }
        }; {

        };
        Authors.ByAuthor();
    }

    public static void TitleS(){
        SearchBookName Titles = new SearchBookName() {
            @Override
            public void nameSearch() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try{
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Enter Title:");
                    String title = userInput.nextLine();
                    String sql = "SELECT * FROM library.books WHERE title = (?)";

                    try (PreparedStatement statement = connection.prepareStatement(sql)){
                        statement.setString(1,title);
                        ResultSet resultSet = statement.executeQuery();{

                            while (resultSet.next()){
                                String btitle = resultSet.getString("title");
                                String Author = resultSet.getString("author");
                                String illustrator = resultSet.getString("illustrator");
                                String genre = resultSet.getString("genre");
                                int pagenum = resultSet.getInt("pagenum");

                                System.out.println(" Title: " + btitle + " Author: " + Author + " Illustrator: " + illustrator + " Genre: " + genre + " Number of pages: " + pagenum);

                            }
                        }

                    }




                }
                catch (SQLException e) {
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }

        };
        Titles.nameSearch();


    }

    public static void BookS(){
        BookCreation Books = new BookCreation() {
            @Override
            public void bookMake() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

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
                    String sql = "INSERT INTO library.books (author, illustrator, genre, pagenum, title) VALUES (?,?,?,?,?)";

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

    public static void WelcomeS(){

        WelCome Books = new WelCome() {
            public void welcomePage(){
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;
            }
        };
        WelCome.welcomePage();
    }

}

interface WelcomeMessage{
    void WelcomePage();
}
interface BookCreation {
    void bookMake();
}
interface SearchBookName {
    void nameSearch();
}

interface SearchBookAuthor {
    void ByAuthor();
}
interface GenreSearch{
   void ByGenre();
}
interface illustratorSearch{
    void ByIllustrator();
}
interface ViewDatabase{
    void ViewAllBooks();
}

interface ViewOwnerOfBooK{
    void ViewOwner();
}



