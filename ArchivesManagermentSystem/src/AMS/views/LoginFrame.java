// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginFrame.java

package AMS.views;

import AMS.dao.AdminDAO;
import AMS.dao.UserDAO;
import AMS.dto.AdminDTO;
import AMS.dto.UserDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginFrame
    implements Initializable
{

    public LoginFrame()
    {
    }

    public void initialize(URL location, ResourceBundle resources)
    {
        comboBox.getItems().setAll(new String[] {
            "\u7BA1\u7406\u5458", "\u7528\u6237"
        });
    }

    protected void ButtonAction(ActionEvent event)
        throws Exception
    {
        String loginType = (String)comboBox.getValue();
        String username = userName.getText();
        String password = userPassword.getText();
        if(loginType == "\u7BA1\u7406\u5458")
            try
            {
                AdminDTO adm = (new AdminDAO()).getAdminByNo(username);
                if(adm != null && adm.getpassword().equals(password))
                {
                    Parent mainPart = (Parent)FXMLLoader.load(getClass().getResource("/AMS/views/AdminFrame.fxml"));
                    Stage mainStage = new Stage();
                    mainStage.setTitle("\u7BA1\u7406\u5458[\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF]");
                    mainStage.setScene(new Scene(mainPart));
                    mainStage.show();
                    Stage loginStage = (Stage)login.getScene().getWindow();
                    loginStage.close();
                } else
                {
                    loginError();
                }
            }
            catch(Exception e)
            {
                loginError();
            }
        else
        if(loginType == "\u7528\u6237")
        {
            try
            {
                UserDTO user = (new UserDAO()).getUserByNo(username);
                user.setuserid(username);
                if(user.getpassword().equals(password))
                {
                    UserDTO.currentuser = username;
                    Parent mainPart = (Parent)FXMLLoader.load(getClass().getResource("/AMS/views/UserFrame.fxml"));
                    Stage mainStage = new Stage();
                    mainStage.setTitle("\u7528\u6237[\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF]");
                    mainStage.setScene(new Scene(mainPart));
                    mainStage.show();
                    Stage loginStage = (Stage)login.getScene().getWindow();
                    loginStage.close();
                } else
                {
                    loginError();
                }
            }
            catch(Exception e)
            {
                loginError();
            }
        } else
        {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("\u8BF7\u9009\u62E9\u7528\u6237\u7C7B\u578B");
            alert.showAndWait();
        }
    }

    public void AddUser(ActionEvent event)
        throws IOException
    {
        Parent addFrame = (Parent)FXMLLoader.load(getClass().getResource("/AMS/views/AdminAddUserFrame.fxml"));
        Stage stage = new Stage();
        stage.setTitle("\u6CE8\u518C\u7528\u6237");
        stage.setScene(new Scene(addFrame));
        stage.show();
        stage.setResizable(false);
    }

    public void loginError()
    {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("\u8D26\u53F7\u6216\u5BC6\u7801\u9519\u8BEF");
        alert.showAndWait();
    }

    private ComboBox comboBox;
    private TextField userName;
    private PasswordField userPassword;
    private Button login;
}
