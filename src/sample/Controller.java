package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller {
    private FormularControler formularControler;

    public void dugmeKliknuto(ActionEvent actionEvent) {
        Parent root = null;
        try {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/formular.fxml"));
            loader.load();
            formularControler = loader.getController();

            myStage.setTitle("Formular");
            myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.show();

            myStage.setOnCloseRequest(event -> {
                if (!formularControler.formularValidan()) {
                    event.consume();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Nije validno");
                    alert.setHeaderText("Popunjeni formular nije validan");
                    alert.setContentText("Ime i prezime je prazno");
                    alert.show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

