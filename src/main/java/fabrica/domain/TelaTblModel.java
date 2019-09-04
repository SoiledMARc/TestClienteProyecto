package fabrica.domain;

import javafx.beans.property.*;


public class TelaTblModel {
final private IntegerProperty idTela;
final private StringProperty tipoTela;
final private StringProperty nombreTela;
final private StringProperty colorTela;
final private IntegerProperty metros;
final private IntegerProperty costo;
@SuppressWarnings("unsed")

    public TelaTblModel( ) {
        this.idTela = new SimpleIntegerProperty();
        this.tipoTela = new SimpleStringProperty();
        this.nombreTela = new SimpleStringProperty();
        this.colorTela = new SimpleStringProperty();
        this.metros = new SimpleIntegerProperty();
        this.costo = new SimpleIntegerProperty();
    }

    public TelaTblModel(Integer idTela, String tipoTela, String nombreTela, String colorTela, Integer metros, Integer costo) {
        this.idTela = new SimpleIntegerProperty(idTela);
        this.tipoTela = new SimpleStringProperty(tipoTela);
        this.nombreTela = new SimpleStringProperty(nombreTela);
        this.colorTela = new SimpleStringProperty(colorTela);
        this.metros = new SimpleIntegerProperty(metros);
        this.costo = new SimpleIntegerProperty(costo);
    }

    public IntegerProperty getIdTelaPropety() {
        return idTela;
    }
    
    public Integer getIdTela(){
        return idTela.get();
    }
    
    public void setId(Integer id){
        this.idTela.set(id);
    }
    
    public String getTipoTela(){
        return tipoTela.get();
    }

    public StringProperty getTipoTelaProperty() {
        return tipoTela;
    }
    
    public void setTipoTela(String tipoTela){
        this.tipoTela.set(tipoTela);
    }

    public StringProperty getNombreTelaProperty() {
        return nombreTela;
    }
    
    public String getNombreTela(){
        return nombreTela.get();
    }
    
    public void setNombreTela(String nombreTela){
        this.nombreTela.set(nombreTela);
    }

    public StringProperty getColorTelaProperty() {
        return colorTela;
    }
    
    public String getColorTela(){
        return colorTela.get();
    }
    
    public void setColorTela(String color){
        this.colorTela.set(color);
    }

    public IntegerProperty getMetrosProperty() {
        return metros;
    }
    
    public Integer getMetros(){
        return metros.get();
    }
    
    public void setMetros(Integer metros){
        this.metros.set(metros);
    }

    public IntegerProperty getCostoProperty() {
        return costo;
    }
    
    public Integer getCosto(){
        return costo.get();
    }
    
    public void setCosto(Integer costo){
        this.costo.set(costo);
    }
}
