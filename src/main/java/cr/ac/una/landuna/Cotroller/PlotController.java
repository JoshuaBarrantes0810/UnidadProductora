
package cr.ac.una.landuna.Cotroller;

import cr.ac.una.landuna.Model.Plot;
import cr.ac.una.landuna.Model.SoilState;
import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PlotController {

    @FXML
    private AnchorPane nameText;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button showButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField codeText;
    @FXML
    private TextField locationText;
    @FXML
    private TextField areaText;
    @FXML
    private TextField soilTypeText;
    @FXML
    private ComboBox<SoilState> soilStateBox;
    @FXML
    private TableView<Plot> listOfPlots;
    @FXML
    private TableColumn<Plot, String> codeColumn;
    @FXML
    private TableColumn<Plot, String> nameColumn;
    @FXML
    private TableColumn<Plot, String> ubicationColumn;
    @FXML
    private TableColumn<Plot, BigDecimal> areaColumn;
    @FXML
    private TableColumn<Plot, String> soilTypeColumn;
    @FXML
    private TableColumn<Plot, SoilState> soilStateColumn;
    
    public void initialLize(){
        soilStateBox.getItems().setAll(SoilState.values());
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("plotCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("plotName"));
        ubicationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("plotArea"));
        soilTypeColumn.setCellValueFactory(new PropertyValueFactory<>("soilType"));
        soilStateColumn.setCellValueFactory(new PropertyValueFactory<>("soilState"));
    }
    
    @FXML
    private void deletePlots(ActionEvent event) {
    }

    @FXML
    private void addPlots(ActionEvent event) {
        
    }

    @FXML
    private void updatePlots(ActionEvent event) {
    }

    @FXML
    private void displayAllPlots(ActionEvent event) {
    }

    @FXML
    private void searchPlotByCode(ActionEvent event) {
    }
    
}
