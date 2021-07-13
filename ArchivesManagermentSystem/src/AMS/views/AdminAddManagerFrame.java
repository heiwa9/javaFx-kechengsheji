package AMS.views;

import AMS.dao.AdminDAO;
import AMS.dto.AdminDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddManagerFrame
    implements Initializable
{

    public AdminAddManagerFrame()
    {
        flag = false;
        managerID = null;
    }

    public void managerAddBtnOnAction()
        throws Exception
    {
        AdminDTO adminDTO = new AdminDTO(new SimpleStringProperty(manageridField.getText()), new SimpleStringProperty(managernameField.getText()), new SimpleStringProperty(genderField.getText()), new SimpleStringProperty(unitField.getText()), new SimpleStringProperty(departmentField.getText()), new SimpleStringProperty(telField.getText()), new SimpleStringProperty(passwordField.getText()));
        if(flag)
        {
            if((new AdminDAO()).updateAdmin(managerID, adminDTO))
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setContentText("\u4FEE\u6539\u6210\u529F");
                alert.showAndWait();
                Stage stage = (Stage)managerAddBtn.getScene().getWindow();
                stage.close();
            } else
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("\u4FEE\u6539\u5931\u8D25");
                alert.showAndWait();
            }
        } else
        if(adminDTO.getadminid().length() == 0 || adminDTO.getadminname().length() == 0 || adminDTO.getpassword().length() < 6)
        {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("\u8BF7\u586B\u5199\u5FC5\u586B\u4FE1\u606F(\u7BA1\u7406\u5458ID,\u59D3\u540D,\u5BC6\u7801)\u4E14\u5BC6\u7801\u957F\u5EA6\u5927\u4E8E6\u4F4D");
            alert.showAndWait();
        } else
        if((new AdminDAO()).insertAdmin(adminDTO))
        {
            manageridField.setText(null);
            managernameField.setText(null);
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

    public void initialize(URL url, ResourceBundle resourcebundle)
    {
    }

    public void initData(String managerID)
        throws Exception
    {
        flag = true;
        this.managerID = managerID;
        AdminDTO manager = (new AdminDAO()).getAdminByNo(managerID);
        manageridField.setText(manager.getadminid());
        managernameField.setText(manager.getadminname());
        genderField.setText(manager.getgender());
        unitField.setText(manager.getunit());
        departmentField.setText(manager.getdepartment());
        telField.setText(manager.gettel());
        passwordField.setText(manager.getpassword());
    }

    public TextField manageridField;
    public TextField managernameField;
    public TextField genderField;
    public TextField unitField;
    public TextField departmentField;
    public TextField telField;
    public TextField passwordField;
    public Button managerAddBtn;
    private boolean flag;
    private String managerID;
}
