package AMS.dto;

import javafx.beans.property.SimpleStringProperty;

public class AdminDTO
{

    public AdminDTO(SimpleStringProperty adminid, SimpleStringProperty adminname, SimpleStringProperty gender, SimpleStringProperty unit, SimpleStringProperty department, SimpleStringProperty tel, SimpleStringProperty password)
    {
        this.adminid = adminid;
        this.adminname = adminname;
        this.gender = gender;
        this.unit = unit;
        this.department = department;
        this.tel = tel;
        this.password = password;
    }

    public AdminDTO()
    {
    }

    public String getadminid()
    {
        return adminid.get();
    }

    public SimpleStringProperty adminidProperty()
    {
        return adminid;
    }

    public void setadminid(String adminid)
    {
        this.adminid.set(adminid);
    }

    public String getadminname()
    {
        return adminname.get();
    }

    public SimpleStringProperty adminnameProperty()
    {
        return adminname;
    }

    public void setadminname(String adminname)
    {
        this.adminname.set(adminname);
    }

    public String getgender()
    {
        return gender.get();
    }

    public SimpleStringProperty genderProperty()
    {
        return gender;
    }

    public void setgender(String gender)
    {
        this.gender.set(gender);
    }

    public String getunit()
    {
        return unit.get();
    }

    public SimpleStringProperty unitProperty()
    {
        return unit;
    }

    public void setunit(String unit)
    {
        this.unit.set(unit);
    }

    public String getdepartment()
    {
        return department.get();
    }

    public SimpleStringProperty departmentProperty()
    {
        return department;
    }

    public void setdepartment(String department)
    {
        this.department.set(department);
    }

    public String gettel()
    {
        return tel.get();
    }

    public SimpleStringProperty telProperty()
    {
        return tel;
    }

    public void settel(String tel)
    {
        this.tel.set(tel);
    }

    public String getpassword()
    {
        return password.get();
    }

    public SimpleStringProperty passwordProperty()
    {
        return password;
    }

    public void setpassword(String password)
    {
        this.password.set(password);
    }

    public String toString()
    {
        return (new StringBuilder()).append("StudentDTO{adminid=").append(adminid).append(", adminname=").append(adminname).append(", gender=").append(gender).append(", unit=").append(unit).append(", department=").append(department).append(", tel=").append(tel).append(", password=").append(password).append('}').toString();
    }

    private SimpleStringProperty adminid;
    private SimpleStringProperty adminname;
    private SimpleStringProperty gender;
    private SimpleStringProperty unit;
    private SimpleStringProperty department;
    private SimpleStringProperty tel;
    private SimpleStringProperty password;
}
