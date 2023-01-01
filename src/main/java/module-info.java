module com.example.emailcontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emailcontrol to javafx.fxml;
    exports com.example.emailcontrol;
}