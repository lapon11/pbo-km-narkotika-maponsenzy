module org.example.tugasbesar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tugasbesar to javafx.fxml;
    exports org.example.tugasbesar;
}