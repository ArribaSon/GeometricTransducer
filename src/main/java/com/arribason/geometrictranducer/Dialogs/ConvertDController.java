package com.arribason.geometrictranducer.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ConvertDController {
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private TextField angle;
    @FXML
    private TextField turnA11;
    @FXML
    private TextField turnA12;
    @FXML
    private TextField turnA21;
    @FXML
    private TextField turnA22;
    @FXML
    private TextField originX;
    @FXML
    private TextField originY;
    @FXML
    private CheckBox reflectionX;
    @FXML
    private CheckBox reflectionY;
    @FXML
    private TextField refA11;
    @FXML
    private TextField refA22;
    @FXML
    private TextField moveX;
    @FXML
    private TextField moveY;
    @FXML
    private TextField scaleX;
    @FXML
    private TextField scaleY;
    @FXML
    private TextField originX1;
    @FXML
    private TextField originY1;


    public Button getOk() {
        return ok;
    }

    public Button getCancel() {
        return cancel;
    }

    public TextField getAngle() {
        return angle;
    }

    public TextField getTurnA11() {
        return turnA11;
    }

    public TextField getTurnA12() {
        return turnA12;
    }

    public TextField getTurnA21() {
        return turnA21;
    }

    public TextField getTurnA22() {
        return turnA22;
    }

    public TextField getOriginX() {
        return originX;
    }

    public TextField getOriginY() {
        return originY;
    }

    public CheckBox getReflectionX() {
        return reflectionX;
    }

    public CheckBox getReflectionY() {
        return reflectionY;
    }

    public TextField getRefA11() {
        return refA11;
    }

    public TextField getRefA22() {
        return refA22;
    }

    public TextField getMoveX() {
        return moveX;
    }

    public TextField getMoveY() {
        return moveY;
    }

    public TextField getScaleX() {
        return scaleX;
    }

    public TextField getScaleY() {
        return scaleY;
    }

    public TextField getOriginX1() {
        return originX1;
    }

    public TextField getOriginY1() {
        return originY1;
    }
}
