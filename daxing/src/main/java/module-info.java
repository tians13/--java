module com.it.daxing {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires transitive java.datatransfer;
    requires transitive java.logging;
    requires transitive java.sql;
    requires java.desktop;

    opens com.it.daxing to javafx.fxml;
    exports com.it.daxing;
}
