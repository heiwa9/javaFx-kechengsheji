package AMS.utils;

import java.sql.*;

public class DBManager
{

    public DBManager()
    {
        conn = null;
        stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConn()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql:///db_archivesmanagementsystem", "", "");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public static void Close(Connection conn, Statement stmt, ResultSet rs)
    {
        try
        {
            if(!rs.isClosed())
                rs.close();
            if(!stmt.isClosed())
                stmt.close();
            if(!conn.isClosed())
                conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void Close(Connection conn, PreparedStatement ps, ResultSet rs)
    {
        try
        {
            if(!rs.isClosed())
                rs.close();
            if(!ps.isClosed())
                ps.close();
            if(!conn.isClosed())
                conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void Close(Connection conn, Statement stmt)
    {
        try
        {
            if(!stmt.isClosed())
                stmt.close();
            if(!conn.isClosed())
                conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://xxxxxxxxx/db_archivesmanagementsystem";
    static final String USERNAME = "xxxx";
    static final String PASSWORD = "xxxxxx";
    Connection conn;
    Statement stmt;
}
