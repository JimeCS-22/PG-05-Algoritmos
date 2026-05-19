module ucr.algoritmos.pg05algoritmos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;


    opens ucr.algoritmos.pg05algoritmos to javafx.fxml;
    opens ucr.algoritmos.pg05algoritmos.model to javafx.base;
    exports ucr.algoritmos.pg05algoritmos;
    exports ucr.algoritmos.pg05algoritmos.controller;
    opens ucr.algoritmos.pg05algoritmos.controller to javafx.fxml;
    exports util;
    opens util to javafx.fxml;
    opens ucr.algoritmos.pg05algoritmos.model.linkedList to javafx.base;
    opens ucr.algoritmos.pg05algoritmos.model.stack to javafx.base;
    opens ucr.algoritmos.pg05algoritmos.model.Queue to javafx.base;
    opens ucr.algoritmos.pg05algoritmos.model.Tree to javafx.base;
}