package AMS.dao;

import AMS.dto.ArchivesDTO;
import AMS.utils.DBManager;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class ArchivesDAO
{

    public List getArchives(String fn, String wn, String title)
        throws Exception
    {
        String sql = "select * from ams_archives";
        String sqlfn = "select * from ams_archives where fn = ?";
        String sqlwn = "select * from ams_archives where wn = ?";
        String sqltitle = "select * from ams_archives where title = ?";
        List list = new ArrayList();
        conn = dbm.getConn();
        if(fn != "null")
        {
            ps = conn.prepareStatement(sqlfn);
            ps.setString(1, fn);
            rs = ps.executeQuery();
        } else
        if(wn != "null")
        {
            ps = conn.prepareStatement(sqlwn);
            ps.setString(1, wn);
            rs = ps.executeQuery();
        } else
        if(title != "null")
        {
            ps = conn.prepareStatement(sqltitle);
            ps.setString(1, title);
            rs = ps.executeQuery();
        } else
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }
        for(; rs.next(); list.add(new ArchivesDTO(new SimpleStringProperty(rs.getString(Archivescolumn[0])), new SimpleStringProperty(rs.getString(Archivescolumn[1])), new SimpleStringProperty(rs.getString(Archivescolumn[2])), new SimpleStringProperty(rs.getString(Archivescolumn[3])), new SimpleStringProperty(rs.getString(Archivescolumn[4])), new SimpleStringProperty(rs.getString(Archivescolumn[5])), new SimpleStringProperty(rs.getString(Archivescolumn[6])), new SimpleStringProperty(rs.getString(Archivescolumn[7])))));
        if(fn == "null" && wn == "null" && title == "null")
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return list;
    }

    public boolean insertArchives(ArchivesDTO dto)
    {
        boolean flag;
        String sql;
        flag = false;
        sql = "INSERT INTO `db_archivesmanagementsystem`.`ams_archives`(`fn`, `wn`, `responsible`, `title`, `classification`, `type`, `receivedtime`, `validity`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getfn());
        ps.setString(2, dto.getwn());
        ps.setString(3, dto.getresponsible());
        ps.setString(4, dto.gettitle());
        ps.setString(5, dto.getclassification());
        ps.setString(6, dto.gettype());
        ps.setString(7, dto.getreceivedtime());
        ps.setString(8, dto.getvalidity());
        int i = ps.executeUpdate();
        if(i >= 0)
            flag = true;
        DBManager.Close(conn, ps);
        break MISSING_BLOCK_LABEL_243;
        SQLException e;
        e;
        System.out.println((new StringBuilder()).append("ERRORCODE:").append(e.getErrorCode()).toString());
        e.printStackTrace();
        DBManager.Close(conn, ps);
        break MISSING_BLOCK_LABEL_243;
        Exception exception;
        exception;
        DBManager.Close(conn, ps);
        throw exception;
        return flag;
    }

    public boolean updateArchives(String fn, ArchivesDTO dto)
        throws Exception
    {
        boolean flag = false;
        String sql = "UPDATE `db_archivesmanagementsystem`.`ams_archives` SET  `wn` = ?, `responsible` = ?, `title` = ?, `classification` = ?, `type` = ?, `receivedtime` = ? , `validity` = ? WHERE (`fn` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, dto.getwn());
        ps.setString(2, dto.getresponsible());
        ps.setString(3, dto.gettitle());
        ps.setString(4, dto.getclassification());
        ps.setString(5, dto.gettype());
        ps.setString(6, dto.getreceivedtime());
        ps.setString(7, dto.getvalidity());
        ps.setString(8, dto.getfn());
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public ArchivesDTO getArchivesByNo(String fn)
        throws Exception
    {
        String sqlByNo = "select * from ams_archives where fn = ?";
        ArchivesDTO dto = null;
        conn = dbm.getConn();
        ps = conn.prepareStatement(sqlByNo);
        ps.setString(1, fn);
        for(rs = ps.executeQuery(); rs.next();)
            dto = new ArchivesDTO(new SimpleStringProperty(rs.getString(Archivescolumn[0])), new SimpleStringProperty(rs.getString(Archivescolumn[1])), new SimpleStringProperty(rs.getString(Archivescolumn[2])), new SimpleStringProperty(rs.getString(Archivescolumn[3])), new SimpleStringProperty(rs.getString(Archivescolumn[4])), new SimpleStringProperty(rs.getString(Archivescolumn[5])), new SimpleStringProperty(rs.getString(Archivescolumn[6])), new SimpleStringProperty(rs.getString(Archivescolumn[7])));

        if(fn == null)
            DBManager.Close(conn, stmt, rs);
        else
            DBManager.Close(conn, ps, rs);
        return dto;
    }

    public boolean deleteArchives(String fn)
        throws Exception
    {
        boolean flag = false;
        String sql = "DELETE FROM `db_archivesmanagementsystem`.`ams_archives` WHERE (`fn` = ?)";
        conn = dbm.getConn();
        ps = conn.prepareStatement(sql);
        ps.setString(1, fn);
        int i = ps.executeUpdate();
        if(i > 0)
            flag = true;
        DBManager.Close(conn, ps);
        return flag;
    }

    public ArchivesDAO()
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
    String Archivescolumn[] = {
        "fn", "wn", "responsible", "title", "classification", "type", "receivedtime", "validity"
    };
}
