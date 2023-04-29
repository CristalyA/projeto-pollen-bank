module com.example.pollentechbank {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.pollentechbank to javafx.fxml;
    exports com.example.pollentechbank;
}