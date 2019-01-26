package db;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
    private static final Logger log = Logger.getLogger(DbConnection.class);

    public static void Connect()
    {
        Connection conn = null;

        try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/main/resources/task_tracker.db";
            conn = DriverManager.getConnection(url);
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                log.error(ex.getMessage());
            }
        }
    }
}
