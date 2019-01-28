package db;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
    private static final Logger log = Logger.getLogger(DbConnection.class);

    private static Connection conn = null;

    public static void Connect()
    {
        try
        {
            String url = "jdbc:sqlite:src/main/resources/task_tracker.db";
            conn = DriverManager.getConnection(url);

            log.info("Connection - OK");

            DbQuerries.selectAll(conn);
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
                    log.warn("Connection has been closed\n" +
                            "\n---------------------------\n");
                }
            }
            catch (SQLException ex)
            {
                log.error("Connection hasn't been closed successfully\n");
                log.error(ex.getMessage());
            }
        }
    }

    public Connection getConnection()
    {
        return conn;
    }

    public static void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch (SQLException ex)
        {
            log.error("Connection hasn't been closed successfully\n");
            log.error(ex.getMessage());
        }
    }
}
