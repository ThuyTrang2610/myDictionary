package Dictionary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.TreeMap;

public class WordManager {
    private static String DB_URL = "jdbc:mysql://localhost:3306/dictionary";
    private static String USER_NAME = "dict";
    private static String PASSWORD = "password";
    private Connection conn;

    public WordManager() {
        try {
            // connnect to database 'testdb'
            this.conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void addWord(String word, String definition) {
        try {
            String query = "insert into words(word, definition) values(?,?);";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, word);
            ps.setString(2, definition);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getWordDefinition(String word) {
        String definition = "";
        try {
            String query = "select definition from words where word=?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, word);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                definition = result.getString("definition");
            }
            System.out.println(definition);
        } catch (Exception ex) {
            ex.printStackTrace();
            definition = "Error connecting to db";
        }

        if (definition.length() == 0 && word.length() > 0) {
            definition = "No definition. Edit this section and press 'Save definition' to save to the database";
        }
        System.out.println(definition);
        return definition;
    }

    public void updateWordDefinition(String word, String definition) {
        try {
            String query = " update words set definition=? where word = ?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, definition);
            ps.setString(2, word);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteWord(String word) {

    }

    public ArrayList<TreeMap<String, String>> getWordList() {
        ArrayList<TreeMap<String, String>> x = new ArrayList();
        return x;
    }

    public static void main(String args[]) {

    }

    /**
     * create connection
     *
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
