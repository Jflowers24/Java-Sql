class DatabaseConfig {
    static String url = "jdbc:postgresql://localhost:5432/HarlemHeritage";
    static String user = "postgres";
    static String password = "71805Ml$";
}
public class DatabaseConfigurations {
    public static String getUrl() {
        return DatabaseConfig.url;
    }

    public static String getUser() {
        return DatabaseConfig.user;
    }

    public static String getPassword() {
        return DatabaseConfig.password;
    }
}
