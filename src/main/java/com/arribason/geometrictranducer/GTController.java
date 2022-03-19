package com.arribason.geometrictranducer;

import com.arribason.geometrictranducer.Dialogs.AboutDialog;
import com.arribason.geometrictranducer.Geometry.Scene2D;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GTController {

    @FXML
    private AnchorPane lab1_scene2dRoot1;
    @FXML
    private AnchorPane lab1_scene2dRoot2;

    public void createLab1Scene() {
        Scene2D scene2D = new Scene2D(lab1_scene2dRoot1, lab1_scene2dRoot2);
    }

    @FXML
    private void close(){
        Platform.exit();
    }

    @FXML
    private void about() throws IOException {
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.show();
    }
}
