package cr.ac.una.landuna.Cotroller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AgriculturalManager {

    @FXML
    private Button workButton;
    @FXML
    private Button plotButton;
    @FXML
    private Button responsibleButton;
    @FXML
    private Button cropButton;
    @FXML
    private Button cropPButton1;

    @FXML
    private void goTAgriculturalWorkController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/agriculturalWork.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.getScene().setRoot(root);
    }

    @FXML
    private void goToPlotController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/plot.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.getScene().setRoot(root);
    }

    @FXML
    private void goToResponsibleController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/responsible.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.getScene().setRoot(root);
    }

    @FXML
    private void goToCropController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/annualCrop.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.getScene().setRoot(root);
    }

    @FXML
    private void goToCropPController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/perennialCrop.fxml"));
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.getScene().setRoot(root);
    }
    
}
