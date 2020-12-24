package com.mycompany.mydbgui;

import com.mycompany.mydbgui.config.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application 
{
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException 
    {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        DbConnection.getConnection().close();
        System.out.println("application stop!");
        super.stop();
    }

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) 
    {
        launch();
    }
}