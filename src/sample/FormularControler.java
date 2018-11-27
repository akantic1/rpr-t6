package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FormularControler {

    public TextField imePrezimeField;
    private boolean imePrezimeValidno;

    private boolean validnoImePrezime(String n) {
        return !n.trim().isEmpty();
    }

    public boolean formularValidan() {
        return imePrezimeValidno;
    }

    @FXML
    public void initialize() {
        imePrezimeValidno = false;
        imePrezimeField.getStyleClass().add("poljeNijeIspravno");

        imePrezimeField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    imePrezimeField.getStyleClass().removeAll("poljeNijeIspravno");
                    imePrezimeField.getStyleClass().add("poljeIspravno");
                    imePrezimeValidno = true;
                } else {
                    imePrezimeField.getStyleClass().removeAll("poljeIspravno");
                    imePrezimeField.getStyleClass().add("poljeNijeIspravno");
                    imePrezimeValidno = false;
                }
            }
        });
    }
}
