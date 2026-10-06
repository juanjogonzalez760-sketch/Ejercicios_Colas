public class ObjTramite {
    private int Turno;
    private int TipoDocumento; // 1: Cedula, 2: Pasaporte, 3: Certificado de Residencia, 4: Libreta Militar
    private int Estado;        // 1: Pendiente/Espera, 2: En Atencion, 3: Finalizado, 4: Cancelado
    private String DescripcionHistorico; // Registra lo ocurrido para el historial

    public ObjTramite() {
    }

    public int getTurno() {
        return Turno;
    }

    public int setTurno(int turno) {
        this.Turno = turno;
        return this.Turno;
    }

    public int getTipoDocumento() {
        return TipoDocumento;
    }

    public int setTipoDocumento(int tipoDocumento) {
        this.TipoDocumento = tipoDocumento;
        return this.TipoDocumento;
    }

    public int getEstado() {
        return Estado;
    }

    public int setEstado(int estado) {
        this.Estado = estado;
        return this.Estado;
    }

    public String getDescripcionHistorico() {
        return DescripcionHistorico;
    }

    public String setDescripcionHistorico(String descripcionHistorico) {
        this.DescripcionHistorico = descripcionHistorico;
        return this.DescripcionHistorico;
    }
}