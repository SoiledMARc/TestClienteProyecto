package fabrica.model.util;

import fabrica.domain.Tela;
import fabrica.domain.TelaTblModel;


public class Convert {
    
    public static TelaTblModel toTelaTblModel(Tela tela){
        TelaTblModel telaModel = new TelaTblModel();
        telaModel.setId(tela.getIdTela());
        telaModel.setTipoTela(tela.getTipoTela());
        telaModel.setNombreTela(tela.getNombreTela());
        telaModel.setColorTela(tela.getColorTela());
        telaModel.setMetros(tela.getMetros());
        telaModel.setCosto(tela.getCosto());
        return telaModel;
    }
}
