/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica.controller;

import fabrica.domain.TelaTblModel;
import fabrica.model.util.rest.RestClientTela;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author noe_7
 */
public class PruebaTableController implements Initializable {

    @FXML
    private TableView<TelaTblModel> table_Tela;
    @FXML
    private TableColumn<TelaTblModel, Number> Colum_ID;
    @FXML
    private TableColumn<TelaTblModel, String> colum_Tipo;
    @FXML
    private TableColumn<TelaTblModel, String> colum_nombre;
    @FXML
    private TableColumn<TelaTblModel, String> colum_color;
    @FXML
    private TableColumn<TelaTblModel, Number> colum_metros;
    @FXML
    private TableColumn<TelaTblModel, Number> colum_costo;
    @FXML
    private Button btn_Listar;
    
    private ObservableList<TelaTblModel> telaList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTabla();
        recuperarTelas();
    }    

    @FXML
    private void Listar(ActionEvent event) {
    }
    
    private void recuperarTelas(){
        try{
            telaList = FXCollections.observableArrayList(RestClientTela.findAllTelas());
            table_Tela.setItems(telaList);
        }catch(RuntimeException e){
            e.printStackTrace();
            
        }
    }
    
    private void inicializarTabla(){
        Colum_ID.setCellValueFactory(cellData -> cellData.getValue().getIdTelaPropety());
        colum_Tipo.setCellValueFactory(cellData -> cellData.getValue().getTipoTelaProperty());
        colum_nombre.setCellValueFactory(cellData -> cellData.getValue().getNombreTelaProperty());
        colum_color.setCellValueFactory(cellData -> cellData.getValue().getColorTelaProperty());
        colum_metros.setCellValueFactory(cellData -> cellData.getValue().getMetrosProperty());
        colum_costo.setCellValueFactory(cellData -> cellData.getValue().getCostoProperty());
    }
}
