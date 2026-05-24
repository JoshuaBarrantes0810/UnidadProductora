
package cr.ac.una.landuna.Cotroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AgriculturalWorkController {

    @FXML
    private TextField idDescription;
    @FXML
    private TextField idCost;
    @FXML
    private TextField idLabor;
    @FXML
    private TextField idDate;
    @FXML
    private TextField idResponsable;
    @FXML
    private TextField idCrop;
    @FXML
    private TextField idPlot;
    @FXML
    private TextField idText;
    @FXML
    private Button addWorkButton;
    @FXML
    private Button deleteWorkButton;
    @FXML
    private Button updateWorkButton;
    @FXML
    private Button showWorkButton;
    @FXML
    private Button findWorkButton;
    @FXML
    private Button exitWorkButton;
    @FXML
    private TableColumn<?, ?> codeColumn;
    @FXML
    private TableColumn<?, ?> codePlotcolumn;
    @FXML
    private TableColumn<?, ?> cropColumn;
    @FXML
    private TableColumn<?, ?> responsibleColumn;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> workTypeColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private void addWork(ActionEvent event) {
    }

    @FXML
    private void deleteWork(ActionEvent event) {
    }

    @FXML
    private void updateWork(ActionEvent event) {
    }

    @FXML
    private void findWork(ActionEvent event) {
    }

    @FXML
    private void exitWork(ActionEvent event) {
    }
    
}
