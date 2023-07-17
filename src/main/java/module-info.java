module com.example.mortgageanalyzergui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.junit.jupiter.api;

    opens com.example.mortgageanalyzergui to javafx.fxml;
    exports com.example.mortgageanalyzergui;
}