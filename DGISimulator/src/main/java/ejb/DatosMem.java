package ejb;


import com.antel.dti.lib.logger.SatelitalesLogger;
import datatypes.ACKCFECaratula;
import datatypes.ACKCFEDet;
import exception.DGIException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import uy.gub.dgi.cfe.ACKCFEDocument;
import uy.gub.dgi.cfe.ACKCFEdefType;
import uy.gub.dgi.cfe.EstadoACKCFEType;
import uy.gub.dgi.cfe.impl.ACKCFEDocumentImpl;
import uy.gub.dgi.cfe.impl.ACKCFEdefTypeImpl;
import uy.gub.dgiConsulta.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Singleton
public class DatosMem {
    /*Juego de datos de prueba para retornos de los ws*/
    private SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    private SatelitalesLogger log;

    @EJB
    private Util util;

    @PostConstruct
    private void init() {
        try {
            /*Nunca pongas un for en este metodo porque explota, y no deja deployar*/
            fechaFin = formato.parse("00-00-0000");
            listaFechaInicio = new Date[]{formato.parse("02-12-2019"), formato.parse("25-01-2006"), formato.parse("01-05-2008"), formato.parse("17-03-2016"), formato.parse("04-06-2018"), formato.parse("04-11-2010"), formato.parse("29-12-2019"), formato.parse("02-12-2011"), formato.parse("10-04-2009"), formato.parse("10-02-2021"), formato.parse("04-09-2008"), formato.parse("05-02-2019"), formato.parse("19-04-2016"), formato.parse("11-08-2010"), formato.parse("26-02-2000"), formato.parse("15-01-2016"), formato.parse("15-02-2017"), formato.parse("27-06-2012"), formato.parse("07-06-2022"), formato.parse("30-07-2003"), formato.parse("06-01-2013"), formato.parse("18-01-2015"), formato.parse("18-11-2004"), formato.parse("30-11-2015"), formato.parse("01-09-2022"), formato.parse("02-12-2007"), formato.parse("05-07-2004"), formato.parse("18-09-2012"), formato.parse("27-06-2005"), formato.parse("11-05-2002"), formato.parse("06-05-2015"), formato.parse("21-11-2009"), formato.parse("07-11-2011"), formato.parse("05-05-2020"), formato.parse("07-02-2011"), formato.parse("23-09-2000"), formato.parse("11-01-2007"), formato.parse("23-08-2007"), formato.parse("29-10-2006"), formato.parse("13-04-2001"), formato.parse("22-07-2013"), formato.parse("04-11-2022"), formato.parse("28-04-2007"), formato.parse("10-03-2021"), formato.parse("05-04-2007"), formato.parse("26-08-2002"), formato.parse("02-02-2018"), formato.parse("31-07-2014"), formato.parse("22-04-2020"), formato.parse("22-06-2008")};
            listaFechaHoraRecepcion = new DateTime[]{formatter.parseDateTime("2018-03-16 23:12:06"), formatter.parseDateTime("2021-09-13 13:54:23"), formatter.parseDateTime("2017-10-31 07:32:17"), formatter.parseDateTime("2012-12-16 08:49:09"), formatter.parseDateTime("2012-06-09 01:57:10"), formatter.parseDateTime("2010-02-10 22:35:27"), formatter.parseDateTime("2018-03-10 02:48:49"), formatter.parseDateTime("2022-02-06 03:17:11"), formatter.parseDateTime("2015-05-27 15:25:59"), formatter.parseDateTime("2015-08-03 18:17:40"), formatter.parseDateTime("2012-09-12 21:32:16"), formatter.parseDateTime("2019-12-14 03:04:48"), formatter.parseDateTime("2022-10-10 03:37:32"), formatter.parseDateTime("2021-12-14 04:30:42"), formatter.parseDateTime("2017-05-07 00:27:50"), formatter.parseDateTime("2017-09-08 22:22:51"), formatter.parseDateTime("2014-09-16 14:53:12"), formatter.parseDateTime("2020-06-03 23:04:18"), formatter.parseDateTime("2019-05-03 18:52:44"), formatter.parseDateTime("2011-04-21 20:52:59"), formatter.parseDateTime("2018-01-01 08:42:41"), formatter.parseDateTime("2016-11-22 16:15:46"), formatter.parseDateTime("2018-12-19 20:35:05"), formatter.parseDateTime("2017-01-27 20:57:25"), formatter.parseDateTime("2011-09-04 19:54:14")};

            listaFechaRecepcion = new Date[]{formato2.parse("2018-03-16"), formato2.parse("2021-09-13"), formato2.parse("2017-10-31"), formato2.parse("2012-12-16"), formato2.parse("2012-06-09"), formato2.parse("2010-02-10"), formato2.parse("2018-03-10"), formato2.parse("2022-02-06"), formato2.parse("2015-05-27"), formato2.parse("2015-08-03"), formato2.parse("2012-09-12"), formato2.parse("2019-12-14"), formato2.parse("2022-10-10"), formato2.parse("2021-12-14"), formato2.parse("2017-05-07"), formato2.parse("2017-09-08"), formato2.parse("2014-09-16"), formato2.parse("2020-06-03"), formato2.parse("2019-05-03"), formato2.parse("2011-04-21"), formato2.parse("2018-01-01"), formato2.parse("2016-11-22"), formato2.parse("2018-12-19"), formato2.parse("2017-01-27"), formato2.parse("2011-09-04")};
            listaFechaRecepcionSobre = new Date[]{formato2.parse("2010-02-10"), formato2.parse("2016-11-22"), formato2.parse("2022-10-10"), formato2.parse("2012-09-12"), formato2.parse("2011-09-04"), formato2.parse("2017-10-31"), formato2.parse("2017-09-08"), formato2.parse("2018-03-16"), formato2.parse("2011-04-21"), formato2.parse("2020-06-03"), formato2.parse("2019-05-03"), formato2.parse("2018-01-01"), formato2.parse("2021-09-13"), formato2.parse("2015-05-27"), formato2.parse("2018-03-16"), formato2.parse("2018-12-19"), formato2.parse("2021-12-14"), formato2.parse("2015-08-03"), formato2.parse("2017-10-31"), formato2.parse("2018-03-10"), formato2.parse("2017-01-27"), formato2.parse("2014-09-16"), formato2.parse("2012-06-09"), formato2.parse("2022-02-06"), formato2.parse("2012-06-09"), formato2.parse("2012-12-16"), formato2.parse("2012-12-16"), formato2.parse("2017-05-07"), formato2.parse("2019-12-14"), formato2.parse("2021-09-13")};
            GregorianCalendar gCal = new GregorianCalendar();
            gCal.setTime(fechaFin);
            XMLGfechaFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCal);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (DatatypeConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<RucEmisoresMailRucEmisoresMailItem> getRucEmisoresMail(Date fchInicioFiltro) throws DGIException {
        ArrayList<RucEmisoresMailRucEmisoresMailItem> retorno = new ArrayList();
        try {
            for (int i = 0; i < 50; i++) {
                if (listaFechaInicio[i].after(fchInicioFiltro)) {
                    var item = new RucEmisoresMailRucEmisoresMailItem();
                    item.setDENOMINACION(listaDenominacion[i]);
                    item.setMAIL(listaMail[i]);
                    item.setFECHAFIN(XMLGfechaFin);
                    item.setRUC(listaRUC[i]);
                    item.setFECHAINICIO(util.DateToXMLGregorianCalendar(listaFechaInicio[i]));
                    retorno.add(item);
                }
            }
        } catch (Exception ex) {
            log.error("Error en la ejecución del método de la clase Datos, getRucEmisoresMail(): " + ex.getMessage());
        }
        log.info("final de getRucEmisoresMail OK");
        return retorno;
    }

    public ArrayList<DatosReporte> getDatosEnvioReporte(ConsultaEnviosReporte query) throws DGIException {
        var datosReporte = new ArrayList();
        /*Filtros*/
        var fechaResumen = query.getFechaResumen();
        var idEmisor = query.getIdEmisor();
        byte secuencia = query.getSecuencia();
        /*Voy a dejar en desuso la variable secuencia*/
        /*Filtros*/
        for (int i = 0; i < 25; i++) {
            try {
                String fechaFiltro = util.dateToString(util.XMLGregorianCalendarToDate(fechaResumen), "dd-MM-yyyy");
                String fechaListado = util.dateToString(listaFechaRecepcion[i], "dd-MM-yyyy");
                //log.info("COMPARAMOS " + fechaFiltro + " CON " + fechaListado);
                if (fechaFiltro.equals(fechaListado)) {
                    //log.info("COMPARAMOS " + idEmisor + " CON " + Long.parseLong(listaRUCEmisor[i]));
                    if (idEmisor != 0 && idEmisor == Long.parseLong(listaRUCEmisor[i])) {
                        var dr = new DatosReporte();
                        dr.setIdEmisor(Long.parseLong(listaRUCEmisor[i]));
                        dr.setIdReceptor(Long.parseLong(listaRUCReceptor[i]));
                        dr.setEstado(listaEstados[i]);
                        dr.setFechaHoraRecepcion(util.DateToXMLGregorianCalendar(listaFechaRecepcion[i]));
                        datosReporte.add(dr);
                    }
                }
            } catch (Exception e) {
                log.error("getACKEnviosReporte: Error en la iteración de getDatosEnvioReporte");
            }
        }
        return datosReporte;
    }

    public ACKConsultaEstadoCFE getEstadoCFE(CFEId filtro) throws DGIException {
        ACKConsultaEstadoCFE ack = null;
        /*Los tres campos del CFEId son obligatorios*/
        for (int i = 0; i < 15; i++) {
            if (filtro.getNro() == listadoNroCFE[i]) {
                if (filtro.getSerie().equals(listadoSerie[i])) {
                    if (filtro.getTipoCFE() == listadoTipoCFE[i]) {
                        ack = new ACKConsultaEstadoCFE();
                        ack.setIdEmisor(Long.parseLong(listaRUCEmisor[i]));
                        ack.setIdReceptor(Long.parseLong(listaRUCReceptor[i]));
                        ack.setEstadoCFE(listaEstados[i]);
                        var paramConsulta = new EFacParamConsulta();
                        paramConsulta.setToken(UUID.randomUUID().toString());
                        paramConsulta.setFechahora(util.DateToXMLGregorianCalendar(listaFechaRecepcion[i]));
                        ack.setParamConsulta(paramConsulta);
                        return ack;
                    }
                }
            }
        }
        return ack;
    }

    public ACKConsultaEnviosCFE getEnvioCFE(CFEId entrada) throws DGIException {
        ACKConsultaEnviosCFE ack = new ACKConsultaEnviosCFE();
        var array = new ArrayOfDatosSobre();
        ArrayList<DatosSobre> datosSobre = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (entrada.getNro() == listadoNroCFE[i]) {
                if (entrada.getTipoCFE() == listadoTipoCFE[i]) {
                    if (entrada.getSerie().equals(listadoSerie[i])) {
                        ack = new ACKConsultaEnviosCFE();
                        for (int j = 0; j < 30; j++) {
                            if (listadoNroCFE[i] == listaNroCFESobre[j]) {
                                DatosSobre item = new DatosSobre();
                                item.setEstadoSobre(listaEstadosSobre[j]);
                                item.setIdEmisor(Long.parseLong(listaRUCEmisor[i]));
                                item.setIdReceptor(Long.parseLong(listaRUCReceptor[i]));
                                item.setFechaHoraSobre(util.DateToXMLGregorianCalendar(listaFechaRecepcionSobre[j]));
                                EFacParamConsulta epc = new EFacParamConsulta();
                                epc.setToken(UUID.randomUUID().toString());
                                epc.setFechahora(util.DateToXMLGregorianCalendar(listaFechaRecepcionSobre[j]));
                                item.setParamConsulta(epc);
                                datosSobre.add(item);
                            }
                        }
                    }
                }
            }
        }
        array.setDatosSobre(datosSobre);
        ack.setColeccionDatosSobres(array);
        return ack;
    }

    public String getConsultarRespuestaReporte(ConsultaRespuestaReporte entrada) throws DGIException {
        String retorno = "No se encontró respuesta del reporte.";
        switch (entrada.getIdReceptor() + "") {
            case "140038540016":
                retorno = diferenciadorAckRepDiario[0] + ackBase;
                break;
            case "140069450019":
                retorno = diferenciadorAckRepDiario[1] + ackBase;
                break;
            case "140084370012":
                retorno = diferenciadorAckRepDiario[2] + ackBase;
                break;
            default:
                retorno = "No se encontró respuesta del reporte.";
                break;
        }
        return retorno;
    }

    public ACKConsultaEnviosSobre getConsultaEnviosSobre(ConsultaEnviosSobre entrada) throws DGIException {
        var retorno = new ACKConsultaEnviosSobre();
        ArrayList<DatosSobre> listaRetorno = new ArrayList();
        Long idEmisor = entrada.getIdEmisor();
        Long idReceptor = entrada.getIdReceptor();
        XMLGregorianCalendar XMLGfechaDesde = entrada.getFechaDesde();
        XMLGregorianCalendar XMLGfechaHasta = entrada.getFechaHasta();
        Date fechaDesde = XMLGfechaDesde.toGregorianCalendar().getTime();
        Date fechaHasta = XMLGfechaHasta.toGregorianCalendar().getTime();
        if (util.validarFiltros(XMLGfechaDesde, XMLGfechaHasta)) { /*La mayoria de filtros están en ese metodo*/
            /*Curso basico*/
            for (int i = 0; i < 30; i++) {
                String idEmisorStr = idEmisor + "";
                String idReceptorStr = idReceptor + "";
                boolean paso = true;
                //log.info(idEmisorStr + " // " + idReceptorStr);
           /*String str1 = "EMISOR COMPARAMOS : " + idEmisorStr + "/" + listaRUCEmisor[i];
            String str2 = "RECEPTOR COMPRARMOS : " + idReceptorStr + "/" + listaRUCReceptor[i];
            if(idEmisorStr.equals(listaRUCEmisor[i])){
                str1+= " TRUE";
            }
            if(idReceptorStr.equals(listaRUCReceptor[i])){
                str2+= " TRUE";
            }
            log.info(str1);
            log.info(str2);*/
                if (!idEmisorStr.equals("0") && !idEmisorStr.equals(listaRUCEmisor[i])) {
                    paso = false;
                }
                if (!idReceptorStr.equals("0") && !idReceptorStr.equals(listaRUCReceptor[i])) {
                    paso = false;
                }
                if (paso == true) {
                    //log.info("COMPARAMOS " + fechaDesde +" CON " + listaFechaRecepcionSobre[i].toString() + "" + fechaDesde.before(listaFechaRecepcionSobre[i]));
                    //log.info("COMPARAMOS " + fechaHasta +" CON " + listaFechaRecepcionSobre[i].toString() + "" + fechaHasta.after(listaFechaRecepcionSobre[i]));
                    if (fechaDesde.before(listaFechaRecepcionSobre[i])) { /*Validamos que la fecha del sobre esté dentro del rango*/
                        if (fechaHasta.after(listaFechaRecepcionSobre[i])) {
                            DatosSobre item = new DatosSobre();
                            item.setIdEmisor(Long.parseLong(listaRUCEmisor[i]));
                            item.setIdReceptor(Long.parseLong(listaRUCReceptor[i]));
                            item.setEstadoSobre(listaEstadosSobre[i]);
                            item.setFechaHoraSobre(util.DateToXMLGregorianCalendar(listaFechaRecepcionSobre[i]));
                            EFacParamConsulta efac = new EFacParamConsulta();
                            efac.setToken(UUID.randomUUID().toString());
                            efac.setFechahora(util.DateToXMLGregorianCalendar(listaFechaRecepcionSobre[i]));
                            item.setParamConsulta(efac);
                            listaRetorno.add(item);
                        }
                    }
                }
            }
            /*Curso basico*/
        } else {
            throw new DGIException("ERROR: Excepcion en validacion de filtros en metodo validarFiltros()");
        }
        ArrayOfDatosSobre array = new ArrayOfDatosSobre();
        array.setDatosSobre(listaRetorno);
        retorno.setColeccionDatosSobre(array);
        return retorno;
    }

    public List<DatosCFE> getConsultaCFERecibidos(ConsultaCFERecibidos entrada) throws DGIException {
        ArrayList<DatosCFE> listaRetorno = new ArrayList();
        /*Loguear todos los datos para compararlos con la doc*/
        /*log.info("LISTADO COMPLETO DE CFE\n");
        log.info("RUCEmisor // RUCReceptor // NroCFE // Serie // TipoCFE // FechaEmision // Estado // Moneda // TotalNeto // TotalIVA // MontoTotal // TotalRetenido\n");
        for(int i =0; i<15; i++){
            log.info(listaRUCEmisor[i] + " // " + listaRUCReceptor[i] + " // " + listadoNroCFE[i] +" // "+ listadoSerie[i] +" // " + listadoTipoCFE[i] +" // "+ listaFechaRecepcion[i] +" // "+ listaEstadosSobre[i] +" // "+ listaMoneda[i] +" // "+ listaTotalNeto[i] +" // "+ listaTotalIva[i] +" // "+ listaMontoTotal[i] +" // " + 0);
        }*/

        /*VALIDACIONES*/
        /*TipoCFE, Serie y NroCFE son filtros opcionales*/
        Long idEmisor = Long.parseLong(entrada.getRUCEmisor());
        String idEmisorStr = idEmisor + "";
        String tipoCFEStr = entrada.getTipoCFE() + "";
        XMLGregorianCalendar XMLGfechaDesde = entrada.getFechaDesde();
        XMLGregorianCalendar XMLGfechaHasta = entrada.getFechaHasta();
        Date fechaDesde = XMLGfechaDesde.toGregorianCalendar().getTime();
        Date fechaHasta = XMLGfechaHasta.toGregorianCalendar().getTime();
        if (util.validarFiltros(XMLGfechaDesde, XMLGfechaHasta)) {
            /*Curso Basico*/
            for (int i = 0; i < 15; i++) {
                boolean pasoTipoCFE = true;
                boolean pasoSerie = true;
                boolean pasoNroCFE = true;
                /*Averiguamos si estos filtros opcionales son usados o no*/
                if (entrada.getTipoCFE() != 0) {
                    pasoTipoCFE = false;
                }
                if (entrada.getSerie() != null) {
                    pasoSerie = false;
                }
                if (!(entrada.getNro() == 0)) {
                    pasoNroCFE = false;
                }
                //log.info("CONDICIONAL: " +  idEmisorStr.equals(listaRUCEmisor[i]) + " // " + (pasoTipoCFE || tipoCFEStr.equals(listadoTipoCFE[i] + "")) + " // " + (pasoSerie || entrada.getSerie().equals(listadoSerie[i])) +" // "+ (pasoNroCFE || entrada.getNro() == listadoNroCFE[i]) +" // " + fechaDesde.before(listaFechaRecepcion[i]) +" // "+ fechaHasta.after(listaFechaRecepcion[i]));
                if (idEmisorStr.equals(listaRUCEmisor[i]) && (pasoTipoCFE || tipoCFEStr.equals(listadoTipoCFE[i] + "")) && (pasoSerie || entrada.getSerie().equals(listadoSerie[i])) && (pasoNroCFE || entrada.getNro() == listadoNroCFE[i]) && fechaDesde.before(listaFechaRecepcion[i]) && fechaHasta.after(listaFechaRecepcion[i])) { /*Filtros obligatorios*/
                    //log.info("RUCEmisor // RUCReceptor // NroCFE // Serie // TipoCFE // FechaEmision // Estado // Moneda // TotalNeto // TotalIVA // MontoTotal // TotalRetenido\n");
                    //log.info(listaRUCEmisor[i] + " // " + listaRUCReceptor[i] + " // " + listadoNroCFE[i] + " // " + listadoSerie[i] + " // " + listadoTipoCFE[i] + " // " + listaFechaRecepcion[i] + " // " + listaEstadosSobre[i] + " // " + listaMoneda[i] + " // " + listaTotalNeto[i] + " // " + listaTotalIva[i] + " // " + listaMontoTotal[i] + " // " + 0 + "\n");
                    DatosCFE item = new DatosCFE();
                    item.setNro(listadoNroCFE[i]);
                    item.setEstado(listaEstadosSobre[i]);
                    item.setFechaHora(util.DateToXMLGregorianCalendar(listaFechaRecepcion[i]));
                    item.setTipoCFE(listadoTipoCFE[i]);
                    item.setSerie(listadoSerie[i]);
                    item.setMoneda(listaMoneda[i]);
                    item.setTotalNeto(listaTotalNeto[i]);
                    item.setTotalIva(listaTotalIva[i]);
                    item.setMontoTotal(listaMontoTotal[i]);
                    item.setTotalRetenido(0); /*Siempre es igual este valor en los juegos de prueba*/
                    listaRetorno.add(item);
                }
            }
        } else {
            throw new DGIException("ERROR: Excepcion en validacion de filtros en validarFiltros()");
        }
        /*Curso basico*/
        return listaRetorno;
    }

    public datatypes.ACKCFEDocument getACKCfe(String xmlData) throws DGIException {
        /*No encuentro el objeto de dgi-beans, saco los datos a mano del string*/
        String token = util.getValorFromTag(xmlData, "<Token>", "</Token>");
        String idReceptor = util.getValorFromTag(xmlData, "<IdReceptor>", "</IdReceptor>");
        datatypes.ACKCFEDocument ack = null;
        for (int i = 0; i < 5; i++) {
            /*Armamos la caratula*/
            if (token.equals(listaTokens[i]) && idReceptor.equals(String.valueOf(listaIdReceptores[i]))) {
                ack = new datatypes.ACKCFEDocument();
                ACKCFECaratula caratula = new ACKCFECaratula();
                caratula.setRUCReceptor(listaRUCReceptorCaratulas[i]);
                caratula.setRUCEmisor(listaRUCEmisorCaratulas[i]);
                caratula.setIDRespuesta(listaIdRespuestaCaratulas[i]);
                caratula.setNomArch(listaNomArchCaratulas[i]);
                caratula.setFecHRecibido(util.DateToXMLGregorianCalendar(listaFechaRecepcion[i]).toGregorianCalendar());
                caratula.setIdEmisor(0);
                caratula.setIdReceptor(listaIdReceptores[i]);
                caratula.setCantenSobre(2);
                caratula.setCantResponden(0);
                caratula.setCantCFEAceptados(2);
                caratula.setCantCFERechazados(0);
                caratula.setCantCFCAceptados(0);
                caratula.setCantCFCObservados(0);
                caratula.setCantOtrosRechazados(0);
                caratula.setTmst(util.DateToXMLGregorianCalendar(listaFechaRecepcion[i]).toGregorianCalendar());
                ack.setCaratula(caratula);
                ArrayList<ACKCFEDet> lista = new ArrayList<>();
                /*Generamos los ACKCFRE_Det para cada token*/
                for (int l = 0; l < 10; l++) {
                    if (token.equals(listaTokensACKCFEDet[l]) && idReceptor.equals(String.valueOf(listaIdReceptoresACKCFEDet[l]))) {
                        //log.info("ENTRE EN EL IF NRO: " + l + " // " + token + " // " + listaTokensACKCFEDet[l] + " // " + idReceptor + " // " + listaIdReceptoresACKCFEDet[l]);
                        ACKCFEDet ackdetimpl = new ACKCFEDet();
                        ackdetimpl.setNroOrdinal(BigInteger.valueOf(listaNroOrdinal[l]));
                        ackdetimpl.setTipoCFE(BigInteger.valueOf(listaTipoCFE_ACKCFE_Det[l]));
                        ackdetimpl.setSerie(listaSerie_ACKCFE_Det[l]);
                        ackdetimpl.setNroCFE(listadoNroCFE[l]);
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.setTime(listaFechaRecepcion[l]);
                        ackdetimpl.setFechaCFE(gregorianCalendar);
                        ackdetimpl.setTmstCFE(gregorianCalendar);
                        ackdetimpl.setEstado(listaEstado_ACKCFE_Det[l]);
                        lista.add(ackdetimpl);
                    }
                }
                ack.setListaDet(lista);
            }
        }
        return ack;
    }


    /*DATOS*//*-----------------------------------------------------------------------------*//*DATOS*/

    /*DGI: WS_eFactura_Consultas / EFACCONSULTARRUCEMISORES /// Antel: GetEClientesDGI*/
    /*50 items de prueba*/
    public final String[] listaRUC = {"213981060018", "219000090011", "211001234567", "010009960012", "100004430014", "213094310011", "213427900012", "213596650013", "213603060018", "214005130010", "214445550018", "214540000011", "215059480018", "215294280015", "217311140014", "210000480010", "210000660019", "210003040011", "210104020016", "210250030012", "211614400013", "213419100010", "216175440017", "210276180011", "110050930013", "140038540016", "140069450019", "140084370012", "150010470010", "150012460012", "150033500013", "150049610018", "150069780016", "150083370016", "150094280013", "160053240014", "160176550011", "160200170015", "210001650017", "210002170019", "210078220017", "210232930015", "210424500019", "210465050018", "210716690012", "211151330016", "211180410014", "211343050011", "211425790019", "211542300018"};
    public final String[] listaDenominacion = {"EL DORADO ", "FONTPARK S A ", "DIRECCION NACIONAL DE IMPRESIONES Y PUBLICACIONES ", "COMPANIA URUGUAYA DE MEDIOS DE PROCESAMIENTO S.A. ", "GOÃ¿I HERMANOS S R L ", "ECOLANDIA S.A. ", "NUMMI SOCIEDAD ANONIMA ", "C.A.S URUGUAY S.A ", "DESIGNWARE LTDA. ", "NUMINA SOCIEDAD ANONIMA ", "ENLINEA LIMITADA ", "NESTLE DEL URUGUAY S A ", "ENGRAW EXPORT & IMPORT CO S A ", "BAYER S A ", "AGA S A ", "VAN DAM S A ", "CHIADEL S A ", "INGREDION URUGUAY SOCIEDAD ANONIMA ", "VISUAR URUGUAY S.A. ", "CONAPROLE DESA ", "LA TENTACION S R L ", "CASA BLANCA IMPEX ", "MATTIO MIJALOFSKI MANUELA ", "CRUZ GAU CARLOS VICTOR ", "AGUIAR OLMA ESMERALDA ", "SILVEIRA LIMA MARTINS JESUS ERLAINE ", "PEREZ ACOSTA BLANCA NELA ", "JORGE SILVA Y CIA ", "PEREIRA SONIA MABEL ", "LESTRO S R L ", "FERNANDEZ BIAZUL MARIA ", "INDUSTRIA LACTEA SALTE&A S A INLACSA S A ", "FRONTERA COMERCIAL S R L ", "GRUPO IDEAS DISTRIBUCION SRL ", "CH M RAJCHMAN Y HNO S A ", "BARRACA DE HIERROS MONTEVIDEO S A ", "IBM DEL URUGUAY S A ", "ALTAMA S A ", "COOPERATIVA DE LA PREVISION SOCIAL ", "BANCO DE SEGUROS DEL ESTADO ", "LA CABAÃ¿A S R L ", "SANARY S A ", "BONDEL S A ", "LAMECO S.R.L.(LATIN AMERICAN MIDDLE EAST COMPANY) ", "NAVESOL S A ", "FIRST DATA URUGUAY SOCIEDAD ANONIMA ", "LAJA S.A. ", "VARELA IRAZUSTA HEBERT ANGEL ", "BALUMA S A ", "MARYSTAY S A ", "ERSINAL SOCIEDAD ANONIMA"};
    public final String[] listaMail = {"fefontpark@gmail.com", "impo-cfe@impo.com.uy", "cfe@visanet.com.uy", "efactura@scanntech.com", "CONTADURIA@UPOSTAL.COM.UY", "cfenummi@redpagos.com.uy", "intercambios@cfe.rondanet.com", "fe@designware.com.uy", "efactura@numina.net.uy", "efactura.comunica@alinea.uy", "proveedores.uy@nestle.com", "efactura@engraw.com.uy", "clientes-bayer@bayer.com", "facturacionelectronica.lg.uy@linde.com", "efacturauy@arcor.com", "factura.electronica@frigorificolasmoras.com.uy", "ingredion@uol.com.br", "prov_elec@visuar.com.uy", "fgonzalezcomotto@antel.com.uy", "latentacionfacturacion@gmail.com", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "cfe@taface.com.uy", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "cfe@taface.com.uy", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "efactura.indulacsa@gmail.com", "fronteracomercial@facturaexpress.com.uy", "grupoideas@facturaexpress.com.uy", "e-factura@rajchman.com", "bhmimport@adinet.com.uy", "pagar@cuentasapagar.com.uy", "cfe@altama.com.uy", "jodus@nel.com.uy", "recepcionCFE@bse.com.uy", "intercambios@cfe.rondanet.com", "recepcioncfe@toto.com.uy", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "lamecoentre@adinet.com.uy", "navesol2014@gmail.com", "CFE@firstdata.com.uy", "efactura@laja.com.uy", "TAFACE_SOPORTE@NEW-AGE-DATA.COM", "recep_distri_uruguay@signature.cl", "marystaysa@gmail.com", "proveedores@solismeat.com.uy", "efactura@kaunas.com.uy"};
    public Date[] listaFechaInicio = {};
    public Date fechaFin = null; // Este parametro de retorno siempre va a ser igual, en los 50 items de prueba.
    public XMLGregorianCalendar XMLGfechaFin = null;
    /*50 items de prueba*/

    /*25 items de prueba*/
    /*30*/ public final String[] listaRUCEmisor = {"213981060018", "219000090011", "211001234567", "110009960012", "100004430014", "213094310011", "213427900012", "213596650013", "213603060018", "214005130010", "214445550018", "214540000011", "215059480018", "215294280015", "217311140014", "210000480010", "210000660019", "210003040011", "210104020016", "210250030012", "211614400013", "213419100010", "216175440017", "210276180011", "110050930013", "211639090018", "211829490017", "212303260013", "212511650015", "212531360012"};
    /*30*/ public final String[] listaRUCReceptor = {"140038540016", "140069450019", "140084370012", "150010470010", "150012460012", "150033500013", "150049610018", "150069780016", "150083370016", "150094280013", "160053240014", "160176550011", "160200170015", "210001650017", "210002170019", "210078220017", "210232930015", "210424500019", "210465050018", "210716690012", "211151330016", "211180410014", "211343050011", "211425790019", "211542300018", "212687370015", "213076550014", "210274130017", "210274130999", "210274130824"};
    public final String[] listaEstados = {"BR", "ER", "FR", "FR", "AR", "DR", "FR", "BR", "BR", "ER", "ER", "BR", "BR", "AR", "FR", "DR", "AR", "ER", "FR", "DR", "AR", "ER", "AR", "DR", "DR"};
    public DateTime[] listaFechaHoraRecepcion = {};/*Inicializo en el PostConstruct*/
    public Date[] listaFechaRecepcion = {};/*Inicializo en el PostConstruct*/
    public Date[] listaFechaRecepcionSobre = {};/*Inicializo en el PostConstruct*/

    /*25 items de prueba*/

    /*DGI: WS_eFactura_Consultas / EFACCONSULTARESTADOCFE /// Antel: ???*/
    /*15 items de prueba*/
    public final int[] listadoNroCFE = {140251, 140278, 140294, 140210, 140227, 140315, 140324, 140365, 140375, 140390, 140416, 140420, 140433, 140445, 140448};
    public final String[] listadoSerie = {"FX", "FX", "FX", "GN", "A", "GW", "GW", "GN", "GW", "HN", "A", "A", "HN", "HN", "GN"};
    public final short[] listadoTipoCFE = {113, 113, 112, 111, 112, 112, 111, 113, 113, 112, 113, 111, 111, 111, 112};
    /*Notas*/
    /*Usamos listaRUCEmisor, listaRUCReceptor, listaFechaHoraRecepcion y listaEstados en sus primeros 15 indices*/
    /*Token siempre se genera randomicamente*/

    /*DGI: WS_eFactura_Consultas / EFACCONSULTARENVIOCFE /// Antel: ???*/
    /*30 items de prueba*/
    /*Se reutilizan los 15 items de las listas de EFACCONSULTARESTADOCFE*/
    /*Se generan datos simulando 30 sobres para esos 15 CFE*/
    /*Se reutilizan primeros 30 items de listaRUCEmisor, listaRUCReceptor*/
    /*Lista de fechas listaFechaRecepcionSobre*/
    /*TOKEN es aleatorio*/
    public final String[] listaEstadosSobre = {"BS", "AS", "CE", "XW", "AE", "BE", "AE", "AR", "AR", "XW", "AS", "BE", "AR", "BS", "XW", "AS", "BS", "AE", "BE", "AS", "BE", "BR", "XW", "CE", "BS", "BR", "AE", "CE", "CE", "BR"};
    public final int[] listaNroCFESobre = {140420, 140433, 140365, 140445, 140445, 140227, 140315, 140251, 140390, 140324, 140375, 140390, 140375, 140315, 140294, 140278, 140294, 140210, 140210, 140433, 140416, 140365, 140420, 140416, 140227, 140448, 140251, 140278, 140324, 140448};
    /*30 items de prueba*/
    /*DGI: WS_eFactura_Consultas / EFACCONSULTARRESPUESTAREPORTE /// Antel: ???*/
    /*3 items de prueba, 3 ack de respuesta distintos*/
    public final String ackBase = "<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<ACKRepDiario xmlns=\"http://cfe.dgi.gub.uy\" version=\"1.0\"><Caratula><RUCReceptor>…</RUCReceptor><RUCEmisor>…</RUCEmisor><NomArch>Re\n" +
            "p_..._20130101_01</NomArch><FecHRecibido>2013-01-02T00:00:00-\n" +
            "03:00</FecHRecibido><IDEmisor>0</IDEmisor><IDReceptor>…</IDReceptor><Tmst>2013-01-\n" +
            "02T01:00:00-03:00</Tmst></Caratula><Detalle><Estado>AR</Estado></Detalle><Signature\n" +
            "xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
            "<SignedInfo>\n" +
            " <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n" +
            " <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
            " <Reference URI=\"\">\n" +
            " <Transforms>\n" +
            " <Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
            " <Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n" +
            " </Transforms>\n" +
            " <DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
            " <DigestValue>…DigestValue>\n" +
            " </Reference>\n" +
            "</SignedInfo>\n" +
            "\n" +
            "<SignatureValue>…</SignatureValue><KeyInfo><X509Data><X509Certificate>…</X509Certificat\n" +
            "e><X509IssuerSerial><X509IssuerName>CN=Correo Uruguayo - CA, OU=SERVICIOS ELECTRONICOS,\n" +
            "O=ADMINISTRACION NACIONAL DE CORREOS,\n" +
            "C=UY</X509IssuerName><X509SerialNumber>…</X509SerialNumber></X509IssuerSerial></X509Dat\n" +
            "a></KeyInfo></Signature></ACKRepDiario>]]>";
    public final String[] diferenciadorAckRepDiario = {"ACKRepDiario RETORNO NRO1", "ACKRepDiario RETORNO NRO3", "ACKRepDiario RETORNO NRO3"};
    /*DGI: WS_eFactura_Consultas / EFACCONSULTARCFERECIBIDOS /// Antel: ???*/
    /*15 CFEs de prueba*/
    /*RUCEmisor, primeros 15 items de listaRUCEmisor
      RUCReceptor, primeros 15 items de listaRUCReceptor
      NroCFE = listadoNroCFE
      Serie = listadoSerie
      TipoCFE = listadoTipoCFE
      FechaEmision = primeros 15 item de ListaFechaRecepcion
      Estado = primeros 15 item de listaEstadosSobre
      */
    public final String[] listaMoneda = {"UYU", "USD", "USD", "UYU", "UYU", "UYU", "UYU", "UYU", "USD", "USD", "UYU", "USD", "USD", "USD", "UYU"};
    public final int[] listaTotalNeto = {1323, 16757, 10285, 10211, 12324, 5060, 14137, 171, 16957, 13419, 8654, 1844, 14592, 13691, 13600};
    public final int[] listaTotalIva = {292, 3687, 2263, 2246, 2711, 1113, 3110, 38, 3731, 2952, 1904, 406, 3210, 3012, 2992};
    public final int[] listaMontoTotal = {1615, 20444, 12548, 12457, 15035, 6173, 17247, 209, 20688, 16371, 10558, 2250, 17802, 16703, 16592};
    public final int TotalRetenido = 0; /*Es igual en los 15 CFE*/
    /*15 CFEs de prueba*/

    /*DGI: WS_eFactura_Recepcion / EFACCONSULTARESTADOENVIO /// Antel: ???*/
    public final String[] listaTokens = {"bdb4b882-e274-45be-8d60-39bfc8b6be32", "56f047fb-6804-4b94-9b97-581188efad8c", "23c600ae-1db9-42c4-b661-09cb180546c3", "e99be99c-1de3-4a70-9fed-a96aaf0ebb6d", "ec5d8024-3387-4447-bde9-f4fe115d621f"
    };
    public final int[] listaIdReceptores = {1516, 1516, 1517, 1517, 1517};

    /*Listado Caratulas*/
    public final String[] listaRUCReceptorCaratulas = {"213981060018", "219000090011", "211001234567", "110009960012", "100004430014"};
    public final String[] listaRUCEmisorCaratulas = {"140038540016", "140069450019", "140084370012", "150010470010", "150012460012"};
    public final Long[] listaIdRespuestaCaratulas = {2058927314L, 1084365457L, 3026112104L, 5015919933L, 9077695693L};
    public final String[] listaNomArchCaratulas = {"arch1.xml", "arch2.xml", "arch3.xml", "arch4.xml", "arch5.xml"};
    /*FecHRecibido y Tmst corresponden a listaFechaRecepcion*/
    public final int idEmisorCaratula = 0;
    /*IDReceptor corresponde a listaIdReceptores*/
    public final int cantEnSobre = 2;
    public final int cantResponden = 0;
    public final int cantCFEAceptados = 2;
    public final int cantCFERechazados = 0;
    public final int cantCFCAceptados = 0;
    public final int cantCFCObservados = 0;
    public final int cantOtrosRechazados = 0;
    /*Listado Caratulas*/

    /*Listado ACKCFE_Det*/
    public final String[] listaTokensACKCFEDet = {"bdb4b882-e274-45be-8d60-39bfc8b6be32", "bdb4b882-e274-45be-8d60-39bfc8b6be32", "56f047fb-6804-4b94-9b97-581188efad8c", "56f047fb-6804-4b94-9b97-581188efad8c", "23c600ae-1db9-42c4-b661-09cb180546c3","23c600ae-1db9-42c4-b661-09cb180546c3","e99be99c-1de3-4a70-9fed-a96aaf0ebb6d","e99be99c-1de3-4a70-9fed-a96aaf0ebb6d","ec5d8024-3387-4447-bde9-f4fe115d621f","ec5d8024-3387-4447-bde9-f4fe115d621f"};
    public final int[]listaIdReceptoresACKCFEDet={1516,1516,1516,1516,1517,1517,1517,1517,1517,1517};
    public final short[]listaNroOrdinal={1,2,1,2,1,2,1,2,1,2};
    public final short[]listaTipoCFE_ACKCFE_Det={113,113,112,111,112,112,111,113,113,112};
    public final String[]listaSerie_ACKCFE_Det={"FX","FX","FX","GN","A","GW","GW","GN","GW","HN"};
    /*FechaCFE y TmstCFE corresponde a listaFechaRecepcion*/
    public final short[]listaEstado_ACKCFE_Det={1,2,3,4,1,2,3,4,1,2};
        /*Listado ACKCFE_Det*/
        /*DATOS*//*-----------------------------------------------------------------------------*//*DATOS*/
        }

