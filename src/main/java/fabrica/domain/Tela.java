package fabrica.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tela implements Serializable{
    private static final long serialVersionUID =  1447199063826949783L;
    private Integer idTela;
    private String tipoTela;
    private String nombreTela;
    private String colorTela;
    private Integer metros;
    private Integer costo;

    public Tela() {
    }

    public Tela(Integer idTela, String tipoTela, String nombreTela, String colorTela, Integer metros, Integer costo) {
        this.idTela = idTela;
        this.tipoTela = tipoTela;
        this.nombreTela = nombreTela;
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
        return nombreTela;
    }

    public void setNombreTela(String nombreTela) {
        this.nombreTela = nombreTela;
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
        return "Tela{" + "idTela=" + idTela + ", tipoTela=" + tipoTela + ", nombreTela=" + nombreTela + ", colorTela=" + colorTela + ", metros=" + metros + ", costo=" + costo + '}';
    }
    
    
}
