package datatypes;
import java.util.Calendar;

public class ACKCFECaratula {
    private String RUCReceptor;
    private String RUCEmisor;
    private long IDRespuesta;
    private String nomArch;
    private Calendar FecHRecibido;
    private long idEmisor;
    private long idReceptor;
    private int CantenSobre;
    private int CantResponden;
    private int CantCFEAceptados;
    private int CantCFERechazados;
    private int CantCFCAceptados;
    private int CantCFCObservados;
    private int CantOtrosRechazados;
    private Calendar Tmst;

    public ACKCFECaratula(){

    }

    public String getRUCReceptor() {
        return RUCReceptor;
    }

    public void setRUCReceptor(String RUCReceptor) {
        this.RUCReceptor = RUCReceptor;
    }

    public String getRUCEmisor() {
        return RUCEmisor;
    }

    public void setRUCEmisor(String RUCEmisor) {
        this.RUCEmisor = RUCEmisor;
    }

    public long getIDRespuesta() {
        return IDRespuesta;
    }

    public void setIDRespuesta(long IDRespuesta) {
        this.IDRespuesta = IDRespuesta;
    }

    public String getNomArch() {
        return nomArch;
    }

    public void setNomArch(String nomArch) {
        this.nomArch = nomArch;
    }

    public Calendar getFecHRecibido() {
        return FecHRecibido;
    }

    public void setFecHRecibido(Calendar fecHRecibido) {
        FecHRecibido = fecHRecibido;
    }

    public long getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(long idEmisor) {
        this.idEmisor = idEmisor;
    }

    public long getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(long idReceptor) {
        this.idReceptor = idReceptor;
    }

    public int getCantenSobre() {
        return CantenSobre;
    }

    public void setCantenSobre(int cantenSobre) {
        CantenSobre = cantenSobre;
    }

    public int getCantResponden() {
        return CantResponden;
    }

    public void setCantResponden(int cantResponden) {
        CantResponden = cantResponden;
    }

    public int getCantCFEAceptados() {
        return CantCFEAceptados;
    }

    public void setCantCFEAceptados(int cantCFEAceptados) {
        CantCFEAceptados = cantCFEAceptados;
    }

    public int getCantCFERechazados() {
        return CantCFERechazados;
    }

    public void setCantCFERechazados(int cantCFERechazados) {
        CantCFERechazados = cantCFERechazados;
    }

    public int getCantCFCAceptados() {
        return CantCFCAceptados;
    }

    public void setCantCFCAceptados(int cantCFCAceptados) {
        CantCFCAceptados = cantCFCAceptados;
    }

    public int getCantCFCObservados() {
        return CantCFCObservados;
    }

    public void setCantCFCObservados(int cantCFCObservados) {
        CantCFCObservados = cantCFCObservados;
    }

    public int getCantOtrosRechazados() {
        return CantOtrosRechazados;
    }

    public void setCantOtrosRechazados(int cantOtrosRechazados) {
        CantOtrosRechazados = cantOtrosRechazados;
    }

    public Calendar getTmst() {
        return Tmst;
    }

    public void setTmst(Calendar tmst) {
        Tmst = tmst;
    }
}
