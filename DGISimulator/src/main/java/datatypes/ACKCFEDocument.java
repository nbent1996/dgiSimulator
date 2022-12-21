package datatypes;

import java.util.ArrayList;
import java.util.List;

public class ACKCFEDocument {
    private ACKCFECaratula caratula;
    private List<ACKCFEDet> listaDet;

    public ACKCFEDocument(ACKCFECaratula caratula, List<ACKCFEDet> listaDet) {
        this.caratula = caratula;
        this.listaDet = listaDet;
    }
    public ACKCFEDocument(){
        this.caratula = new ACKCFECaratula();
        this.listaDet = new ArrayList<>();
    }

    public ACKCFECaratula getCaratula() {
        return caratula;
    }

    public void setCaratula(ACKCFECaratula caratula) {
        this.caratula = caratula;
    }

    public List<ACKCFEDet> getListaDet() {
        return listaDet;
    }

    public void setListaDet(List<ACKCFEDet> listaDet) {
        this.listaDet = listaDet;
    }
}
