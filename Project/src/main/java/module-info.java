module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.naming;
                            
    opens com.example.project to javafx.fxml;
    exports com.example.project;
    exports com.example.project.Controllers;
    opens com.example.project.Controllers to javafx.fxml;
    exports com.example.project.Useless;
    opens com.example.project.Useless to javafx.fxml;
}