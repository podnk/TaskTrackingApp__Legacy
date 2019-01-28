package db;

import org.apache.log4j.Logger;

import java.sql.*;

public class DbQuerries
{
    DbQuerries(){}

    private static final Logger log = Logger.getLogger(DbQuerries.class);

    public static void selectAll(Connection conn)
    {
        String sqlSelectAll = "SELECT * FROM Tasks";

        try
        {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sqlSelectAll);

            // loop through the result set
            System.out.println("\n<<< SELECT START >>>\n");
            while (rs.next())
            {
                System.out.println(rs.getInt("id") +  " |\t" +
                        rs.getInt("type") + " |\t" +
                        rs.getInt("content") + " |\t" +
                        rs.getString("comment") + " |");
            }
            System.out.println("\n<<< SELECT END >>>\n");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
        }
    }

    public static void insert(Connection conn, int type, int content, String comment)
    {
        String sqlInsert = "INSERT INTO Tasks(type,content,comment) VALUES(?,?,?)";

        try
        {
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setInt(1, type);
            pstmt.setInt(2, content);
            pstmt.setString(3, comment);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
        }
    }
}
