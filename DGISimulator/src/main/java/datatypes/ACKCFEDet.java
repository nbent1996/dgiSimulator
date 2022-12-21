package datatypes;

import java.math.BigInteger;
import java.util.Calendar;

public class ACKCFEDet {
    private BigInteger NroOrdinal;
    private BigInteger TipoCFE;
    private String Serie;
    private int NroCFE;
    private Calendar FechaCFE;
    private Calendar TmstCFE;
    private short Estado;

    public ACKCFEDet(){

    }

    public BigInteger getNroOrdinal() {
        return NroOrdinal;
    }

    public void setNroOrdinal(BigInteger nroOrdinal) {
        NroOrdinal = nroOrdinal;
    }

    public BigInteger getTipoCFE() {
        return TipoCFE;
    }

    public void setTipoCFE(BigInteger tipoCFE) {
        TipoCFE = tipoCFE;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public int getNroCFE() {
        return NroCFE;
    }

    public void setNroCFE(int nroCFE) {
        NroCFE = nroCFE;
    }

    public Calendar getFechaCFE() {
        return FechaCFE;
    }

    public void setFechaCFE(Calendar fechaCFE) {
        FechaCFE = fechaCFE;
    }

    public Calendar getTmstCFE() {
        return TmstCFE;
    }

    public void setTmstCFE(Calendar tmstCFE) {
        TmstCFE = tmstCFE;
    }

    public short getEstado() {
        return Estado;
    }

    public void setEstado(short estado) {
        Estado = estado;
    }
}
