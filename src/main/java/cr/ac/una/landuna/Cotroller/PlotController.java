
package cr.ac.una.landuna.Cotroller;

import cr.ac.una.landuna.DAO.PlotDAO;
import cr.ac.una.landuna.Model.Plot;
import cr.ac.una.landuna.Model.SoilState;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlotController {

    @FXML
    private TextField nameText;
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
    @FXML
    private Button deletePlotsButton;
    @FXML
    private Button addPlotsButton;
    @FXML
    private Button updatePlotsButton;
    @FXML
    private Button showPlotsButton;
    @FXML
    private Button searchPlotsButton;
    @FXML
    private Button exitPlotsButton;
    
    public void initialize(){
        soilStateBox.getItems().setAll(SoilState.values());
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("plotCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("plotName"));
        ubicationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("plotArea"));
        soilTypeColumn.setCellValueFactory(new PropertyValueFactory<>("soilType"));
        soilStateColumn.setCellValueFactory(new PropertyValueFactory<>("soilState"));
    }
    
    private void clearFields(){
        codeText.clear();
        nameText.clear();
        locationText.clear();
        areaText.clear();
        soilTypeText.clear();
    }
    
    public void fillColumns(){
        PlotDAO plotDao = new PlotDAO();
        List<Plot> plots = plotDao.displayPlots();
        listOfPlots.getItems().setAll(plots);
    }
    
    @FXML
    private void deletePlots(ActionEvent event) {
        Plot plot = listOfPlots.getSelectionModel().getSelectedItem();
        if(plot == null){
            showAlert("Error","Campos incompletos","Por favor llene todos los campos.");
            return;
        }
        PlotDAO plotDao = new PlotDAO();
        boolean selected = plotDao.deletePlot(plot);
        if(selected == true){
            listOfPlots.getItems().remove(plot);
            showConfirmation("Éxito","Parcela eliminada","La parcela se eliminó correctamente.");
        }
    }

    @FXML
    private void addPlots(ActionEvent event) {
        String newCode = codeText.getText().trim();
        String newName = nameText.getText().trim();
        String newLocation = locationText.getText().trim();
        String newArea = areaText.getText().trim();
        String newSoilType = soilTypeText.getText().trim();
        SoilState newSoilState = soilStateBox.getSelectionModel().getSelectedItem();
        if(newCode.isEmpty() || newName.isEmpty() || newLocation.isEmpty() || newArea.isEmpty() || newSoilType.isEmpty() || newSoilState == null){
            showAlert("Error","Campos incompletos","Por favor llene todos los campos.");
            return;
        }
        try {
            BigDecimal area = new BigDecimal(newArea.replace('.', ','));
            Plot plot = new Plot(newCode, newName, newLocation, area, newSoilType, newSoilState);
            PlotDAO plotDao = new PlotDAO();
            if(plotDao.insertPlot(plot)){
                showConfirmation("Éxito","Parcela agregada","La parcela se agregó correctamente.");
                clearFields();
                fillColumns();
            }
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @FXML
    private void updatePlots(ActionEvent event) {
        String newCode = codeText.getText().trim();
        String newName = nameText.getText().trim();
        String newLocation = locationText.getText().trim();
        String newArea = areaText.getText().trim();
        String newSoilType = soilTypeText.getText().trim();
        SoilState newSoilState = soilStateBox.getSelectionModel().getSelectedItem();
        if(newCode.isEmpty() || newName.isEmpty() || newLocation.isEmpty() || newArea.isEmpty() || newSoilType.isEmpty() || newSoilState == null){
            showAlert("Error","Campos incompletos","Por favor llene todos los campos.");
            return;
        }
        try {
            BigDecimal area = new BigDecimal(newArea.replace('.', ','));
            Plot plot = new Plot(newCode, newName, newLocation, area, newSoilType, newSoilState);
            PlotDAO plotDao = new PlotDAO();
            if(plotDao.updatePlot(plot)){
                showConfirmation("Éxito","Parcela actualizada","La parcela se actualizó correctamente.");
                clearFields();
                fillColumns();
            }
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @FXML
    private void displayAllPlots(ActionEvent event) {
        fillColumns();
    }

    @FXML
    private void searchPlotByCode(ActionEvent event) {
        String newCode = codeText.getText().trim();
        if(newCode.isEmpty()){
            showAlert("Error","Campos incompletos","Por favor ingrese un código para realizar la búsqueda.");
            return;
        }
        PlotDAO plotDao = new PlotDAO();
        Plot plot = plotDao.findPlot(newCode);
        listOfPlots.getItems().clear();
        if(plot != null){
            listOfPlots.getItems().add(plot);
        } else{
            showAlert("Error","Código inexistente","No existe una parcela con ese código.");
        }
    }

    @FXML
    private void exitPlots(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/cr/ac/una/landuna/View/agriculturalManager.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        Stage screen = (Stage) source.getScene().getWindow();
        screen.setScene(scene);
        screen.show();
    }
    
    private void showAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void showConfirmation(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    } 
}
