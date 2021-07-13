package AMS.dao;

import AMS.dto.AdminDTO;
import AMS.dto.UserDTO;
import AMS.utils.DBManager;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class UserDAO
{

    public List getUsers(String userid)
        throws Exception
    {
        String sql = "SELECT * FROM `db_archivesmanagementsystem`.`ams_users`";
        String sqlByNo = "select * FROM `db_archivesmanagementsystem`.`ams_users` where userid = ?";
        List list = new ArrayList();
        conn = dbm.getConn();
        if(userid == null || userid.isEmpty())
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } else
        {
            ps = conn.prepareStatement(sqlByNo);
            ps.setString(1, userid);
            rs = ps.executeQuery();
        }
        for(; rs.next(); list.add(new UserDTO(new SimpleStringProperty(rs.getString(Usercolumn[0])), new SimpleStringProperty(rs.getString(Usercolumn[1])), new SimpleStringProperty(rs.getString(Usercolumn[2])), new SimpleStringProperty(rs.getString(Usercolumn[3])), new SimpleStringProperty(rs.getString(Usercolumn[4])), new SimpleStringProperty(rs.getString(Usercolumn[5])), new SimpleStringProperty(rs.getString(Usercolumn[6])))));
        if(userid == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return list;
    }

    public boolean insertUser(UserDTO dto)
    {
        boolean flag;
        String sql;
        flag = false;
        sql = "INSERT INTO `db_archivesmanagementsystem`.`ams_users`(`userid`, `username`, `gender`, `unit`, `department`, `tel`, `passwd`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getuserid());
        ps.setString(2, dto.getusername());
        ps.setString(3, dto.getgender());
        ps.setString(4, dto.getunit());
        ps.setString(5, dto.getdepartment());
        ps.setString(6, dto.gettel());
        ps.setString(7, dto.getpassword());
        int i = ps.executeUpdate();
        if(i >= 0)
            flag = true;
        DBManager.Close(conn, ps);
        break MISSING_BLOCK_LABEL_228;
        SQLException e;
        e;
        System.out.println((new StringBuilder()).append("ERRORCODE:").append(e.getErrorCode()).toString());
        e.printStackTrace();
        DBManager.Close(conn, ps);
        break MISSING_BLOCK_LABEL_228;
        Exception exception;
        exception;
        DBManager.Close(conn, ps);
        throw exception;
        return flag;
    }

    public boolean updateUser(String userid, UserDTO dto)
        throws Exception
    {
        boolean flag = false;
        String sql = "UPDATE `db_archivesmanagementsystem`.`ams_users` SET  `username` = ?, `gender` = ?, `unit` = ?, `department` = ?, `tel` = ?, `passwd` = ? WHERE (`userid` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getusername());
        ps.setString(2, dto.getgender());
        ps.setString(3, dto.getunit());
        ps.setString(4, dto.getdepartment());
        ps.setString(5, dto.gettel());
        ps.setString(6, dto.getpassword());
        ps.setString(7, userid);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public UserDTO getUserByNo(String userid)
        throws Exception
    {
        String sqlByNo = "select * from ams_users where userid = ?";
        UserDTO dto = null;
        conn = dbm.getConn();
        ps = conn.prepareStatement(sqlByNo);
        ps.setString(1, userid);
        for(rs = ps.executeQuery(); rs.next();)
            dto = new UserDTO(new SimpleStringProperty(rs.getString(Usercolumn[0])), new SimpleStringProperty(rs.getString(Usercolumn[1])), new SimpleStringProperty(rs.getString(Usercolumn[2])), new SimpleStringProperty(rs.getString(Usercolumn[3])), new SimpleStringProperty(rs.getString(Usercolumn[4])), new SimpleStringProperty(rs.getString(Usercolumn[5])), new SimpleStringProperty(rs.getString(Usercolumn[6])));

        if(userid == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return dto;
    }

    public AdminDTO setManagerByNo(String userid)
        throws Exception
    {
        String sqlByNo = "select * from ams_users where userid = ?";
        AdminDTO dto = null;
        conn = dbm.getConn();
        ps = conn.prepareStatement(sqlByNo);
        ps.setString(1, userid);
        for(rs = ps.executeQuery(); rs.next();)
            dto = new AdminDTO(new SimpleStringProperty(rs.getString(Usercolumn[0])), new SimpleStringProperty(rs.getString(Usercolumn[1])), new SimpleStringProperty(rs.getString(Usercolumn[2])), new SimpleStringProperty(rs.getString(Usercolumn[3])), new SimpleStringProperty(rs.getString(Usercolumn[4])), new SimpleStringProperty(rs.getString(Usercolumn[5])), new SimpleStringProperty(rs.getString(Usercolumn[6])));

        if(userid == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return dto;
    }

    public boolean deleteUser(String userid)
        throws Exception
    {
        boolean flag = false;
        String sql = "DELETE FROM `db_archivesmanagementsystem`.`ams_users` WHERE (`userid` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, userid);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public String getNextUserID()
        throws Exception
    {
        int nextID = 0;
        String sql = "SELECT * FROM `db_archivesmanagementsystem`.`ams_users`";
        conn = dbm.getConn();
        stmt = conn.createStatement();
        for(rs = stmt.executeQuery(sql); rs.next();)
            nextID = rs.getInt(Usercolumn[0]);

        return String.valueOf(nextID + 1);
    }

    public UserDAO()
    {
        dbm = new DBManager();
        conn = null;
        stmt = null;
        ps = null;
        rs = null;
    }

    DBManager dbm;
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    String Usercolumn[] = {
        "userid", "username", "gender", "unit", "department", "tel", "passwd"
    };
}
