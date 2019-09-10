/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica.controller;

import fabrica.domain.Tela;
import fabrica.domain.TelaTblModel;
import fabrica.model.util.DialogUtil;
import fabrica.model.util.rest.RestClientTela;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.ws.rs.core.Response;

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
    @FXML
    private TextField txt_tipo;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_color;
    @FXML
    private TextField txt_metros;
    @FXML
    private TextField txt_costo;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_agregar;
    @FXML
    private TextField txt_id;
    @FXML
    private Button Modificar;
    @FXML
    private Button Eliminar;

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
        recuperarTelas();
    }

    private void recuperarTelas() {
        try {
            telaList = FXCollections.observableArrayList(RestClientTela.findAllTelas());
            table_Tela.setItems(telaList);
        } catch (RuntimeException e) {
            e.printStackTrace();

        }
    }

    private void recupararTelaPorTipo(String tipo) {
        try {
            telaList = FXCollections.observableArrayList(RestClientTela.findAllByTipo(tipo));
            table_Tela.setItems(telaList);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private void inicializarTabla() {
        Colum_ID.setCellValueFactory(cellData -> cellData.getValue().getIdTelaPropety());
        colum_Tipo.setCellValueFactory(cellData -> cellData.getValue().getTipoTelaProperty());
        colum_nombre.setCellValueFactory(cellData -> cellData.getValue().getNombreTelaProperty());
        colum_color.setCellValueFactory(cellData -> cellData.getValue().getColorTelaProperty());
        colum_metros.setCellValueFactory(cellData -> cellData.getValue().getMetrosProperty());
        colum_costo.setCellValueFactory(cellData -> cellData.getValue().getCostoProperty());
    }

    @FXML
    private void Buscar(ActionEvent event) {
        if (txt_id.getText().isEmpty()) {
            DialogUtil.buildSimpleDialog("Atencion", "Cuidado campo vacio", "Revisa que no haya campos vacios", Alert.AlertType.WARNING).showAndWait();
        } else {
            Tela telaBuscada = RestClientTela.findTelaById(txt_id.getText());
            if (telaBuscada != null) {
                DialogUtil.buildSimpleDialog("Tela", "Tela Buscada", telaBuscada.toString(), Alert.AlertType.INFORMATION).showAndWait();
                txt_id.setText("");
            }
        }
    }

    @FXML
    private void Agregar(ActionEvent event) {
        if (txt_color.getText().isEmpty() & txt_costo.getText().isEmpty() & txt_metros.getText().isEmpty() & txt_nombre.getText().isEmpty() & txt_tipo.getText().isEmpty()) {
            DialogUtil.buildSimpleDialog("Atencion", "Cuidado campo vacio", "Revisa que no haya campos vacios", Alert.AlertType.WARNING).showAndWait();
        } else {
            Tela tela = new Tela();
            tela.setColorTela(txt_color.getText());
            tela.setCosto(Integer.parseInt(txt_costo.getText()));
            tela.setMetros(Integer.parseInt(txt_metros.getText()));
            tela.setNombreTela(txt_nombre.getText());
            tela.setTipoTela(txt_tipo.getText());
            Response response = RestClientTela.CrearTela(tela);
            System.out.println("Repuesta: " + response.getStatus());
        }
    }

    @FXML
    private void Modificar(ActionEvent event) {
        Tela telaBuscada = null;
        Tela telaModificada = new Tela();
        if (Modificar.getText().equals("Modificar")) {
            if (txt_id.getText().isEmpty()) {
                DialogUtil.buildSimpleDialog("Atencion", "Cuidado campo vacio", "Revisa que no haya campos vacios", Alert.AlertType.WARNING).showAndWait();
            } else {
                telaBuscada = RestClientTela.findTelaById(txt_id.getText());
                if (telaBuscada != null) {
                    txt_color.setText(telaBuscada.getColorTela());
                    txt_costo.setText(telaBuscada.getCosto() + "");
                    txt_id.setText(telaBuscada.getIdTela() + "");
                    txt_metros.setText(telaBuscada.getMetros() + "");
                    txt_nombre.setText(telaBuscada.getNombreTela());
                    txt_tipo.setText(telaBuscada.getTipoTela());                    
                    Modificar.setText("Guardar");
                }
            }
        } else if (Modificar.getText().equals("Guardar")) {
            telaBuscada = RestClientTela.findTelaById(txt_id.getText());
            telaModificada = telaBuscada;
            telaModificada.setNombreTela(txt_nombre.getText());
            telaModificada.setTipoTela(txt_tipo.getText());
            telaModificada.setMetros(Integer.parseInt(txt_metros.getText()));
            telaModificada.setCosto(Integer.parseInt(txt_costo.getText()));
            telaModificada.setColorTela(txt_color.getText());
            Response res = RestClientTela.ModificarTela(telaModificada, telaModificada.getIdTela());
            System.out.println(res.getStatus());
            if (res.getStatus() == 200) {
                DialogUtil.buildSimpleDialog("Modificando", "Modificando:", "ID a modificar: " + txt_id.getText(), Alert.AlertType.INFORMATION).showAndWait();
                Modificar.setText("Modificar");
            } else {
                DialogUtil.buildSimpleDialog("Error", "No Modificado", "Hubo un error", Alert.AlertType.ERROR).showAndWait();
            }

        }
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        Optional<String> id = DialogUtil.buildInputDialog("Eliminar", "Eliminar por ID", "Ingrese el ID para eliminar").showAndWait();
        Response res = RestClientTela.eliminarTelaPorId(id.get());
                System.out.println(res.getStatus());
    }
}
