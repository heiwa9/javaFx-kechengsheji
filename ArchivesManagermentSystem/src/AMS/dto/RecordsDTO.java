package AMS.dto;

import javafx.beans.property.SimpleStringProperty;

public class RecordsDTO
{

    public RecordsDTO(SimpleStringProperty fn, SimpleStringProperty userid, SimpleStringProperty borrowway, SimpleStringProperty borrowtime, SimpleStringProperty reborrowTime)
    {
        this.fn = fn;
        this.userid = userid;
        this.borrowway = borrowway;
        this.borrowtime = borrowtime;
        this.reborrowTime = reborrowTime;
    }

    public RecordsDTO()
    {
    }

    public String getfn()
    {
        return fn.get();
    }

    public SimpleStringProperty fnProperty()
    {
        return fn;
    }

    public void setfn(String fn)
    {
        this.fn.set(fn);
    }

    public String getuserid()
    {
        return userid.get();
    }

    public SimpleStringProperty useridProperty()
    {
        return userid;
    }

    public void setuserid(String userid)
    {
        this.userid.set(userid);
    }

    public String getborrowway()
    {
        return borrowway.get();
    }

    public SimpleStringProperty borrowwayProperty()
    {
        return borrowway;
    }

    public void setborrowway(String borrowway)
    {
        this.borrowway.set(borrowway);
    }

    public String getborrowtime()
    {
        return borrowtime.get();
    }

    public SimpleStringProperty borrowtimeProperty()
    {
        return borrowtime;
    }

    public void setborrowtime(String borrowtime)
    {
        this.borrowtime.set(borrowtime);
    }

    public String getreborrowTime()
    {
        return reborrowTime.get();
    }

    public SimpleStringProperty reborrowTimeProperty()
    {
        return reborrowTime;
    }

    public void setreborrowTime(String reborrowTime)
    {
        this.reborrowTime.set(reborrowTime);
    }

    public String toString()
    {
        return (new StringBuilder()).append("StudentDTO{fn=").append(fn).append(", userid=").append(userid).append(", borrowway=").append(borrowway).append(", borrowtime=").append(borrowtime).append(", reborrowTime=").append(reborrowTime).append('}').toString();
    }

    private SimpleStringProperty fn;
    private SimpleStringProperty userid;
    private SimpleStringProperty borrowway;
    private SimpleStringProperty borrowtime;
    private SimpleStringProperty reborrowTime;
}
