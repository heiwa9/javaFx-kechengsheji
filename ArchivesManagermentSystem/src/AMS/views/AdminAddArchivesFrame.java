package AMS.views;

import AMS.dao.ArchivesDAO;
import AMS.dto.ArchivesDTO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminAddArchivesFrame
    implements Initializable
{

    public AdminAddArchivesFrame()
    {
        flag = false;
        archivesfn = null;
    }

    public void archivesAddBtnOnAction()
        throws Exception
    {
        ArchivesDTO archivesDTO = new ArchivesDTO(new SimpleStringProperty(fnField.getText()), new SimpleStringProperty(wnField.getText()), new SimpleStringProperty(responsibleField.getText()), new SimpleStringProperty(titleField.getText()), new SimpleStringProperty(classificationField.getText()), new SimpleStringProperty(typeField.getText()), new SimpleStringProperty(((LocalDate)receivedtime.getValue()).toString()), new SimpleStringProperty(validityField.getText()));
        if(flag)
        {
            if((new ArchivesDAO()).updateArchives(archivesfn, archivesDTO))
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setContentText("\u4FEE\u6539\u6210\u529F");
                alert.showAndWait();
                Stage stage = (Stage)archivesAddBtn.getScene().getWindow();
                stage.close();
            } else
            {
                Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("\u4FEE\u6539\u5931\u8D25");
                alert.showAndWait();
            }
        } else
        if(archivesDTO.getfn().length() == 0 || archivesDTO.gettitle().length() == 0)
        {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("\u8BF7\u586B\u5199\u5FC5\u586B\u4FE1\u606F(\u6863\u6848\u53F7\u3001\u9898\u540D)");
            alert.showAndWait();
        } else
        if((new ArchivesDAO()).insertArchives(archivesDTO))
        {
            fnField.setText(null);
            wnField.setText(null);
            responsibleField.setText(null);
            titleField.setText(null);
            classificationField.setText(null);
            typeField.setText(null);
            receivedtime.setValue(null);
            validityField.setText(null);
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
        receivedtime.setValue(LocalDate.now());
        validityField.setText("\u957F\u671F");
    }

    public void initData(String archivesfn)
        throws Exception
    {
        flag = true;
        this.archivesfn = archivesfn;
        ArchivesDTO arc = (new ArchivesDAO()).getArchivesByNo(archivesfn);
        fnField.setText(arc.getfn());
        wnField.setText(arc.getwn());
        responsibleField.setText(arc.getresponsible());
        titleField.setText(arc.gettitle());
        classificationField.setText(arc.getclassification());
        typeField.setText(arc.gettype());
        receivedtime.setValue(LocalDate.parse(arc.getreceivedtime()));
        validityField.setText(arc.getvalidity());
    }

    private boolean flag;
    private String archivesfn;
    public TextField fnField;
    public TextField wnField;
    public TextField responsibleField;
    public TextField titleField;
    public TextField classificationField;
    public TextField typeField;
    public TextField validityField;
    public DatePicker receivedtime;
    public Button archivesAddBtn;
}
