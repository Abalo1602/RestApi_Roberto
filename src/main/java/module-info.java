module com.example.restapi_roberto {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsr250.api;
    requires com.google.gson;
    requires retrofit2;
    requires javafx.media;
    requires retrofit2.converter.gson;


    opens com.example.restapi_roberto to javafx.fxml, com.google.gson;
    exports com.example.restapi_roberto;
}