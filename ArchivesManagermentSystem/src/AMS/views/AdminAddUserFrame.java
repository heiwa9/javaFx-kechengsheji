package AMS.views;

import AMS.dao.UserDAO;
import AMS.dto.UserDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddUserFrame
    implements Initializable
{

    public AdminAddUserFrame()
    {
        flag = false;
        userID = null;
    }

    public void userAddBtnOnAction()
        throws Exception
    {
        UserDTO userDTO = new UserDTO(new SimpleStringProperty(useridField.getText()), new SimpleStringProperty(usernameField.getText()), new SimpleStringProperty(genderField.getText()), new SimpleStringProperty(unitField.getText()), new SimpleStringProperty(departmentField.getText()), new SimpleStringProperty(telField.getText()), new SimpleStringProperty(passwordField.getText()));
        if(flag)
        {
            if(userDTO.getuserid().length() == 0 || userDTO.getgender().length() == 2 || userDTO.getusername().length() == 0 || userDTO.getpassword().length() < 6)
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("\u8BF7\u586B\u5199\u5FC5\u586B\u4FE1\u606F(UserID,\u6027\u522B,\u59D3\u540D,\u5BC6\u7801)\u4E14\u5BC6\u7801\u957F\u5EA6\u5927\u4E8E6\u4F4D");
                alert.showAndWait();
            } else
            if((new UserDAO()).updateUser(userID, userDTO))
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setContentText("\u4FEE\u6539\u6210\u529F");
                alert.showAndWait();
                Stage stage = (Stage)userAddBtn.getScene().getWindow();
                stage.close();
            } else
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("\u4FEE\u6539\u5931\u8D25");
                alert.showAndWait();
            }
        } else
        if(userDTO.getuserid().length() == 0 || userDTO.getgender().length() == 2 || userDTO.getusername().length() == 0 || userDTO.getpassword().length() < 6)
        {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("\u8BF7\u586B\u5199\u5FC5\u586B\u4FE1\u606F(UserID,\u6027\u522B,\u59D3\u540D,\u5BC6\u7801)\u4E14\u5BC6\u7801\u957F\u5EA6\u5927\u4E8E6\u4F4D");
            alert.showAndWait();
        } else
        if((new UserDAO()).insertUser(userDTO))
        {
            useridField.setText(null);
            usernameField.setText(null);
            genderField.setText(null);
            unitField.setText(null);
            departmentField.setText(null);
            telField.setText(null);
            passwordField.setText(null);
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setContentText("\u6DFB\u52A0\u6210\u529F");
            alert.showAndWait();
        } else
        {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("\u6DFB\u52A0\u5931\u8D25");
            alert.showAndWait();
        }
    }

    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            useridField.setEditable(false);
            useridField.setText((new UserDAO()).getNextUserID());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void initData(String userID)
        throws Exception
    {
        flag = true;
        this.userID = userID;
        UserDTO user = (new UserDAO()).getUserByNo(userID);
        useridField.setText(user.getuserid());
        usernameField.setText(user.getusername());
        genderField.setText(user.getgender());
        unitField.setText(user.getunit());
        departmentField.setText(user.getdepartment());
        telField.setText(user.gettel());
        passwordField.setText(user.getpassword());
    }

    public TextField useridField;
    public TextField usernameField;
    public TextField genderField;
    public TextField unitField;
    public TextField departmentField;
    public TextField telField;
    public TextField passwordField;
    public Button userAddBtn;
    private boolean flag;
    private String userID;
}
