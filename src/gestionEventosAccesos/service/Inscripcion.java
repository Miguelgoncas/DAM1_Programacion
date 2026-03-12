package gestionEventosAccesos.service;

public class Inscripcion {
    private String codigoEvento;
    private String dniAsistente;

    public Inscripcion(String codigoEvento, String dniAsistente) {
        this.codigoEvento = codigoEvento;
        this.dniAsistente = dniAsistente;
    }

    public String getCodigoEvento(){
        return this.codigoEvento;
    }

    public String getDniAsistente(){
        return this.dniAsistente;
    }
}
