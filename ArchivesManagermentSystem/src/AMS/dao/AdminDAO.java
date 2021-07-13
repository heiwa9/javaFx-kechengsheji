package AMS.dao;

import AMS.dto.AdminDTO;
import AMS.utils.DBManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class AdminDAO
{

    public List getAdmins(String adminid)
        throws Exception
    {
        String sql = "SELECT * FROM `db_archivesmanagementsystem`.`ams_managers`";
        String sqlByNo = "select * FROM `db_archivesmanagementsystem`.`ams_managers` where adminid = ?";
        List list = new ArrayList();
        conn = dbm.getConn();
        if(adminid == null || adminid.isEmpty())
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } else
        {
            ps = conn.prepareStatement(sqlByNo);
            ps.setString(1, adminid);
            rs = ps.executeQuery();
        }
        for(; rs.next(); list.add(new AdminDTO(new SimpleStringProperty(rs.getString(mgrcolumn[0])), new SimpleStringProperty(rs.getString(mgrcolumn[1])), new SimpleStringProperty(rs.getString(mgrcolumn[2])), new SimpleStringProperty(rs.getString(mgrcolumn[3])), new SimpleStringProperty(rs.getString(mgrcolumn[4])), new SimpleStringProperty(rs.getString(mgrcolumn[5])), new SimpleStringProperty(rs.getString(mgrcolumn[6])))));
        if(adminid == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return list;
    }

    public boolean insertAdmin(AdminDTO dto)
    {
        boolean flag;
        String sql;
        flag = false;
        sql = "INSERT INTO `db_archivesmanagementsystem`.`ams_managers`(`adminid`, `adminname`, `gender`, `unit`, `department`, `tel`, `passwd`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getadminid());
        ps.setString(2, dto.getadminname());
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

    public boolean updateAdmin(String adminid, AdminDTO dto)
        throws Exception
    {
        boolean flag = false;
        String sql = "UPDATE `db_archivesmanagementsystem`.`ams_managers` SET  `adminname` = ?, `gender` = ?, `unit` = ?, `department` = ?, `tel` = ?, `passwd` = ? WHERE (`adminid` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getadminname());
        ps.setString(2, dto.getgender());
        ps.setString(3, dto.getunit());
        ps.setString(4, dto.getdepartment());
        ps.setString(5, dto.gettel());
        ps.setString(6, dto.getpassword());
        ps.setString(7, adminid);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public AdminDTO getAdminByNo(String adminid)
        throws Exception
    {
        String sqlByNo = "select * from ams_managers where adminid = ?";
        AdminDTO dto = null;
        conn = dbm.getConn();
        ps = conn.prepareStatement(sqlByNo);
        ps.setString(1, adminid);
        for(rs = ps.executeQuery(); rs.next();)
            dto = new AdminDTO(new SimpleStringProperty(rs.getString(mgrcolumn[0])), new SimpleStringProperty(rs.getString(mgrcolumn[1])), new SimpleStringProperty(rs.getString(mgrcolumn[2])), new SimpleStringProperty(rs.getString(mgrcolumn[3])), new SimpleStringProperty(rs.getString(mgrcolumn[4])), new SimpleStringProperty(rs.getString(mgrcolumn[5])), new SimpleStringProperty(rs.getString(mgrcolumn[6])));

        if(adminid == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return dto;
    }

    public boolean deleteAdmin(String adminid)
        throws Exception
    {
        boolean flag = false;
        String sql = "DELETE FROM `db_archivesmanagementsystem`.`ams_managers` WHERE (`adminid` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, adminid);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public AdminDAO()
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
    String mgrcolumn[] = {
        "adminid", "adminname", "gender", "unit", "department", "tel", "passwd"
    };
}
