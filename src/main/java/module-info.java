module gb.ru {
    requires javafx.controls;
    requires javafx.fxml;

    opens gb.ru to javafx.fxml;
    exports gb.ru;
}
