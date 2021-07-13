package AMS.dto;

import javafx.beans.property.SimpleStringProperty;

public class UserDTO
{

    public UserDTO(SimpleStringProperty userid, SimpleStringProperty username, SimpleStringProperty gender, SimpleStringProperty unit, SimpleStringProperty department, SimpleStringProperty tel, SimpleStringProperty password)
    {
        this.userid = userid;
        this.username = username;
        this.gender = gender;
        this.unit = unit;
        this.department = department;
        this.tel = tel;
        this.password = password;
    }

    public UserDTO()
    {
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

    public String getusername()
    {
        return username.get();
    }

    public SimpleStringProperty usernameProperty()
    {
        return username;
    }

    public void setusername(String username)
    {
        this.username.set(username);
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
        return (new StringBuilder()).append("StudentDTO{userid=").append(userid).append(", username=").append(username).append(", gender=").append(gender).append(", unit=").append(unit).append(", department=").append(department).append(", tel=").append(tel).append(", password=").append(password).append('}').toString();
    }

    public static String currentuser;
    private SimpleStringProperty userid;
    private SimpleStringProperty username;
    private SimpleStringProperty gender;
    private SimpleStringProperty unit;
    private SimpleStringProperty department;
    private SimpleStringProperty tel;
    private SimpleStringProperty password;
}
