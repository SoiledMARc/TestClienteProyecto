package fabrica.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tela implements Serializable{
    private static final long serialVersionUID =  1447199063826949783L;
    private Integer idTela;
    private String tipoTela;
    private String nombre;
    private String colorTela;
    private Integer metros;
    private Integer costo;

    public Tela() {
    }

    public Tela(Integer idTela, String tipoTela, String nombreTela, String colorTela, Integer metros, Integer costo) {
        this.idTela = idTela;
        this.tipoTela = tipoTela;
        this.nombre = nombreTela;
        this.colorTela = colorTela;
        this.metros = metros;
        this.costo = costo;
    }

    public Integer getIdTela() {
        return idTela;
    }

    public void setIdTela(Integer idTela) {
        this.idTela = idTela;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getNombreTela() {
        return nombre;
    }

    public void setNombreTela(String nombreTela) {
        this.nombre = nombreTela;
    }

    public String getColorTela() {
        return colorTela;
    }

    public void setColorTela(String colorTela) {
        this.colorTela = colorTela;
    }

    public Integer getMetros() {
        return metros;
    }

    public void setMetros(Integer metros) {
        this.metros = metros;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Tela: " + "ID: " + idTela + "\n Tipo: " + tipoTela + "\n Nombre: " + nombre + "\n Color: " + colorTela + "\n Metros: " + metros + "\n Costo: " + costo;
    }
    
    
}
