import java.sql.*;

public class ConnectMySQL {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";

        try(Connection conn = DriverManager.getConnection(url, "demouser", "demouser");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("select last_name from superhero where first_name = ?");

            ResultSet rs = stmt.executeQuery("select name from superhero")){
            showColumnContent(rs, 1);

            String firstname = "Bruce";
            pstmt.setString(1, firstname);
            ResultSet rs2 = pstmt.executeQuery();
            showColumnContent(rs2, 1);

        }


    }

    private static void showColumnContent(ResultSet rs, int columnIndext) throws SQLException {

        while(rs.next()){
            System.out.println(rs.getString(columnIndext));
        }
    }
}
