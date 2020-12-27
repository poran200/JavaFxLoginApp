module com.mycompany.mydbgui 
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    requires java.sql;
    requires java.base;

    opens com.mycompany.mydbgui to javafx.fxml;
    exports com.mycompany.mydbgui;
    exports com.mycompany.mydbgui.controller;
}
