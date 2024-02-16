import java.awt.print.Book;
import java.sql.*;
import java.util.*;





public class Functions {
    public static void MemberS(){
        addMember Members = new addMember() {
            @Override
            public void addMem() {
                Scanner userInput = new Scanner(System.in);
                String url = "jdbc:postgresql://localhost:5432/HarlemHeritage";
                String user = "postgres";
                String password = "Hope_2023";

                Connection connection = null;
                try {
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("New Member Process: ");
                    System.out.print("Name:");
                    String name = userInput.nextLine();
                    System.out.print("Number:");
                    int number = userInput.nextInt();
                    System.out.print("Email:");
                    String email = userInput.next();


                    String sql = "INSERT INTO person (name, number, email) VALUES (?,?,?)";
                    try(PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1,name);
                        statement.setInt(2,number);
                        statement.setString(3,email);

                        statement.executeUpdate();
                        statement.close();


                    }catch (SQLException e) {
                        System.out.println("Connection error: " + e.getErrorCode());
                        e.printStackTrace();
                    }

                }catch(SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        Members.addMem();
    }


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

                                System.out.println(" Title: " + btitle + "\n" + " Author: " + Author + "\n" + " Illustrator: " + illustrator + "\n" + " Genre: " + genre + "\n" + " Number of pages: " + pagenum);

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
                    System.out.print("Enter Author's name: ");
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
                    System.out.print("Enter Desired Genre: ");
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
                    System.out.print("Enter Author's name: ");
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
                    System.out.print("Enter Title: ");
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

    public static void SearchS(){
        SearchOptions Searching = new SearchOptions() {
            @Override
            public void searchOption() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(url, user, password);

                    System.out.print("How would you like to Search - [Title] | [Author] | [Illustrator] | [Genre]? \n>");
                    String option = userInput.nextLine();

                    if (Objects.equals(option, "Title")) {
                        TitleS();
                    } else if (Objects.equals(option, "Author")) {
                        AuthorS();
                    } else if (Objects.equals(option, "Author")) {
                        IllustratorS();
                    } else if (Objects.equals(option, "Author")) {
                        GenreS();
                    }
                }
                catch (SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }
        };
        Searching.searchOption();
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

    public static void WelcomeS() {
        WelcomeMessage Welcomes = new WelcomeMessage() {
            @Override
            public void WelcomePage() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(url, user, password);

                    System.out.println("Welcome to HarlemHeritage!");
                    System.out.print("Would you like to [create] a Book instance, [search] for a pre-existing book, or [check in] or [check out] a book? \n>");
                    String action = userInput.nextLine();

                    if (Objects.equals(action, "create")){
                        BookS();  // Call your existing BookS function
                    } else if (Objects.equals(action, "search")) {
                        SearchS();
                    }else if (Objects.equals(action, "check in")){
                        CheckInS();
                    }else if (Objects.equals(action, "check out")){
                        CheckOutS();
                    }
                }
                catch (SQLException e){
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }
        };

        Welcomes.WelcomePage();
    }

    public static void CheckOutS() {
        CheckOutBook checkouts = new CheckOutBook() {
            @Override
            public void BookCheckOut() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Enter the title of the book you want to checkout: ");
                    String title = userInput.nextLine();

                    String sql = "UPDATE library.books SET checked_out = true WHERE title = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, title);
                        int rowsUpdated = statement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Book \"" + title + "\" checked out successfully.");
                        } else {
                            System.out.println("Book \"" + title + "\" not found or already checked out.");
                        }
                    }
                } catch (SQLException e) {
                   System.out.println("Connection error: " + e.getErrorCode());
                   e.printStackTrace();
                }
            }
        };
        checkouts.BookCheckOut();
    }


    public static void CheckInS() {
        CheckInBook checkins = new CheckInBook() {
            @Override
            public void BookCheckIn() {
                String url = DatabaseConfigurations.getUrl();
                String user = DatabaseConfigurations.getUser();
                String password = DatabaseConfigurations.getPassword();

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.print("Enter the title of the book you want to check in: ");
                    String title = userInput.nextLine();

                    String sql = "UPDATE library.books SET checked_out = false WHERE title = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, title);
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Book \"" + title + "\" checked in successfully.");
                        } else {
                            System.out.println("Book \"" + title + "\" not found or already checked in.");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Connection error: " + e.getErrorCode());
                    e.printStackTrace();
                }
            }
        };
        checkins.BookCheckIn();
    }
}

interface WelcomeMessage{
    void WelcomePage();
}
interface BookCreation {
    void bookMake();
}

interface SearchOptions{
    void searchOption();
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

interface addMember{
    void addMem();
}
interface CheckOutBook{
    void BookCheckOut();
}
interface CheckInBook{
    void BookCheckIn();
}


