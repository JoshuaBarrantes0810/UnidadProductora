
package cr.ac.una.landuna.Cotroller;

import cr.ac.una.landuna.DAO.ProducerDAO;
import cr.ac.una.landuna.Model.Producer;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProducerController {

    @FXML
    private Button findProducerButton;
    @FXML
    private Button deleteProducerButton;
    @FXML
    private Button addProducerButton;
    @FXML
    private Button showProducerButton;
    @FXML
    private Button updateProducerButton;
    @FXML
    private Button exitButton;
    @FXML
    private TableView<Producer> listOfProducers;
    @FXML
    private TableColumn<Producer, String> codeProducerColumn;
    @FXML
    private TableColumn<Producer, String> nameProducerColmn;
    @FXML
    private TextField codeText;
    @FXML
    private TextField nameText;
    
    public void initialize(){
        codeProducerColumn.setCellValueFactory(new PropertyValueFactory<>("producerId"));
        nameProducerColmn.setCellValueFactory(new PropertyValueFactory<>("producerLandName"));
    }
    
    public void fillColumns(){
        ProducerDAO producerDao = new ProducerDAO();
        List<Producer> producers = producerDao.displayProducer();
        listOfProducers.getItems().setAll(producers);
    }
    
    public void clearFields(){
        codeText.clear();
        nameText.clear();
    }

    @FXML
    private void findProducer(ActionEvent event) {
        String newCode = codeText.getText().trim();
        if(newCode.isEmpty()){
            showAlert("Error","Campos incompletos","Por favor ingrese un código para realizar la búsqueda.");
            return;
        }
        ProducerDAO producerDao = new ProducerDAO();
        Producer producer = producerDao.findProducer(newCode);
        listOfProducers.getItems().clear();
        if(producer != null){
            listOfProducers.getItems().setAll(producer);
        } else{
            showAlert("Error","Código inexistente","No existe un productor con ese código.");
        }  
    }

    @FXML
    private void deleteProducer(ActionEvent event) {
        Producer producer = listOfProducers.getSelectionModel().getSelectedItem();
        if(producer == null){
            showAlert("Error","Fila no seleccionada","Por favor selecciones una fila para eliminar.");
            return;
        }
        ProducerDAO producerDao = new ProducerDAO();
        Boolean selected = producerDao.deteleProducer(producer);
        if(selected == true){
            listOfProducers.getItems().remove(producer);
            showConfirmation("Éxito","Registro eliminado","El productor se eliminó correctamente.");
        }
    }

    @FXML
    private void addProducer(ActionEvent event) {
        String newCode = codeText.getText().trim();
        String newName = nameText.getText().trim();
        if(newCode.isEmpty() || newName.isEmpty()){
           showAlert("Error","Campos incompletos","Por favor llene todos los espacios.");
           return;
        }
        try { 
            ProducerDAO producerDao = new ProducerDAO();
            Producer producer = new Producer(newCode,newName);
            if(producerDao.insertProducer(producer)){
            showConfirmation("Éxito","Productor agregado","El productor se agregó existosamente.");
            listOfProducers.getItems().add(producer);
            }
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @FXML
    private void ShowProducer(ActionEvent event) {
        fillColumns();
    }

    @FXML
    private void updateProducer(ActionEvent event) {
        String newCode = codeText.getText().trim();
        String newName = nameText.getText().trim();
        if(newCode.isEmpty() || newName.isEmpty()){
           showAlert("Error","Campos incompletos","Por favor llene todos los espacios.");
           return;
        }
        try { 
            ProducerDAO producerDao = new ProducerDAO();
            Producer producer = new Producer(newCode,newName);
            if(producerDao.updateProducer(producer)){
            showConfirmation("Éxito","Proceso existoso","El productor se actualizó existosamente.");
            listOfProducers.getItems().add(producer);
            }
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @FXML
    private void exitProducer(ActionEvent event) throws IOException {
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
