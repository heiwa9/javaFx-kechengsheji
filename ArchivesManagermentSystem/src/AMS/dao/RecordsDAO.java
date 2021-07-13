package AMS.dao;

import AMS.dto.RecordsDTO;
import AMS.utils.DBManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class RecordsDAO
{

    public RecordsDAO()
    {
        dbm = new DBManager();
        conn = null;
        stmt = null;
        ps = null;
        rs = null;
    }

    public List getRecords(String fn)
        throws Exception
    {
        String sql = "select * from ams_records";
        String sqlByNo = "select * from ams_records where fn = ?";
        List list = new ArrayList();
        conn = dbm.getConn();
        if(fn == null || fn.isEmpty())
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } else
        {
            ps = conn.prepareStatement(sqlByNo);
            ps.setString(1, fn);
            rs = ps.executeQuery();
        }
        for(; rs.next(); list.add(new RecordsDTO(new SimpleStringProperty(rs.getString(recordscolumn[0])), new SimpleStringProperty(rs.getString(recordscolumn[1])), new SimpleStringProperty(rs.getString(recordscolumn[2])), new SimpleStringProperty(rs.getString(recordscolumn[3])), new SimpleStringProperty(rs.getString(recordscolumn[4])))));
        if(fn == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return list;
    }

    public boolean insertRecords(RecordsDTO dto)
        throws Exception
    {
        boolean flag = false;
        String sql = "INSERT INTO `db_archivesmanagementsystem`.`ams_records` (`fn`, `userid`, `borrowway`, `borrowtime`, `reborrowTime`) VALUES ( ?, ?, ?, ?, ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getfn());
        ps.setString(2, dto.getuserid());
        ps.setString(3, dto.getborrowway());
        ps.setString(4, dto.getborrowtime());
        ps.setString(5, dto.getreborrowTime());
        int i = ps.executeUpdate();
        if(i >= 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public boolean updateRecords(String fn, RecordsDTO dto)
        throws Exception
    {
        boolean flag = false;
        String sql = "UPDATE `db_archivesmanagementsystem`.`ams_records` SET  `userid` = ?, `borrowway` = ?, `borrowtime` = ?, `reborrowTime` = ?   WHERE (`fn` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getuserid());
        ps.setString(2, dto.getborrowway());
        ps.setString(3, dto.getborrowtime());
        ps.setString(4, dto.getreborrowTime());
        ps.setString(5, fn);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public RecordsDTO getRecordsByNo(String fn)
        throws Exception
    {
        String sqlByNo = "select * from ams_recoreds where fn = ?";
        RecordsDTO dto = null;
        conn = dbm.getConn();
        ps = conn.prepareStatement(sqlByNo);
        ps.setString(1, fn);
        for(rs = ps.executeQuery(); rs.next();)
            dto = new RecordsDTO(new SimpleStringProperty(rs.getString(recordscolumn[0])), new SimpleStringProperty(rs.getString(recordscolumn[1])), new SimpleStringProperty(rs.getString(recordscolumn[2])), new SimpleStringProperty(rs.getString(recordscolumn[3])), new SimpleStringProperty(rs.getString(recordscolumn[4])));

        if(fn == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return dto;
    }

    public boolean deleteRecordsByNo(String fn, String userid)
        throws Exception
    {
        boolean flag = false;
        String sql = "DELETE FROM `db_archivesmanagementsystem`.`ams_records` WHERE (`fn` = ? AND `userid` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, fn);
        ps.setString(2, userid);
        int i = ps.executeUpdate();
        if(i >= 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    DBManager dbm;
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    String recordscolumn[] = {
        "fn", "userid", "borrowway", "borrowtime", "reborrowTime"
    };
}
