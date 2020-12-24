module com.mycompany.mydbgui 
{
    requires javafx.controls;
    requires javafx.fxml;
    
    requires java.sql;
    requires java.base;

    opens com.mycompany.mydbgui to javafx.fxml;
    exports com.mycompany.mydbgui;
}
