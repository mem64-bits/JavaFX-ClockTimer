module com.git.mem64bits.clocktimer.clocktimer {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.desktop;


    opens com.git.mem64bits.clocktimer.clocktimer to javafx.fxml;
    exports com.git.mem64bits.clocktimer.clocktimer;
}