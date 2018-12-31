import java.sql.*;

public class UseJDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";

        try(Connection conn = DriverManager.getConnection(url, "demouser", "demopass");
            Statement stmt = conn.createStatement())
        {

            ResultSet rs = stmt.executeQuery("select name from superhero");
            showColumnContent(rs, 1);


            int result = stmt.executeUpdate("insert into superhero (name, first_name, good) values ('Goku', 'Kakarot', 1)");
            System.out.println("result: rows affected = " + result);

            ResultSet rs2 = stmt.executeQuery("select name from superhero");
            showColumnContent(rs2, 1);
        }
    }

    private static void showColumnContent(ResultSet rs, int columnIndex) throws SQLException {
        while(rs.next()){
            System.out.println(rs.getString(columnIndex));
        }
    }
}
