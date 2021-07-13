package AMS.dto;

import javafx.beans.property.SimpleStringProperty;

public class ArchivesDTO
{

    public ArchivesDTO(SimpleStringProperty fn, SimpleStringProperty wn, SimpleStringProperty responsible, SimpleStringProperty title, SimpleStringProperty classification, SimpleStringProperty type, SimpleStringProperty receivedtime, 
            SimpleStringProperty validity)
    {
        this.fn = fn;
        this.wn = wn;
        this.responsible = responsible;
        this.title = title;
        this.classification = classification;
        this.type = type;
        this.receivedtime = receivedtime;
        this.validity = validity;
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

    public String getwn()
    {
        return wn.get();
    }

    public SimpleStringProperty wnProperty()
    {
        return wn;
    }

    public void setwn(String wn)
    {
        this.wn.set(wn);
    }

    public String getresponsible()
    {
        return responsible.get();
    }

    public SimpleStringProperty responsibleProperty()
    {
        return responsible;
    }

    public void setresponsible(String responsible)
    {
        this.responsible.set(responsible);
    }

    public String gettitle()
    {
        return title.get();
    }

    public SimpleStringProperty titleProperty()
    {
        return title;
    }

    public void settitle(String title)
    {
        this.title.set(title);
    }

    public String getclassification()
    {
        return classification.get();
    }

    public SimpleStringProperty classificationProperty()
    {
        return classification;
    }

    public void setclassification(String classification)
    {
        this.classification.set(classification);
    }

    public String gettype()
    {
        return type.get();
    }

    public SimpleStringProperty typeProperty()
    {
        return type;
    }

    public void settype(String type)
    {
        this.type.set(type);
    }

    public String getreceivedtime()
    {
        return receivedtime.get();
    }

    public SimpleStringProperty receivedtimeProperty()
    {
        return receivedtime;
    }

    public void setreceivedtime(String receivedtime)
    {
        this.receivedtime.set(receivedtime);
    }

    public String getvalidity()
    {
        return validity.get();
    }

    public SimpleStringProperty validityProperty()
    {
        return validity;
    }

    public void setvalidity(String validity)
    {
        this.validity.set(validity);
    }

    public String toString()
    {
        return (new StringBuilder()).append("StudentDTO{fn=").append(fn).append(", wn=").append(wn).append(", responsible=").append(responsible).append(", title=").append(title).append(", classification=").append(classification).append(", type=").append(type).append(", receivedtime=").append(receivedtime).append(", validity=").append(validity).append('}').toString();
    }

    private SimpleStringProperty fn;
    private SimpleStringProperty wn;
    private SimpleStringProperty responsible;
    private SimpleStringProperty title;
    private SimpleStringProperty classification;
    private SimpleStringProperty type;
    private SimpleStringProperty receivedtime;
    private SimpleStringProperty validity;
}
