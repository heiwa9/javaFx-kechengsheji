// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Main.java

package AMS;

import AMS.dao.ArchivesDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    public Main()
    {
    }

    public void start(Stage primaryStage)
    {
        try
        {
            Parent root = (Parent)FXMLLoader.load(getClass().getResource("/AMS/views/LoginFrame.fxml"));
            primaryStage.setTitle("\u767B\u5F55[\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF]");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
        throws Exception
    {
        java.util.List list = (new ArchivesDAO()).getArchives("null", "null", "null");
        launch(args);
    }
}
