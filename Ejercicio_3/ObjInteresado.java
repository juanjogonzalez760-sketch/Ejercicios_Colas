public class ObjInteresado {
    private int Turno;
    private int IdPersona;      // Documento o código de la persona
    private int Propiedad;      // 1: Apto Poblado, 2: Casa Laureles, 3: Oficina Envigado
    private int Horario;        // 1: 09:00 AM, 2: 11:00 AM, 3: 02:00 PM, 4: 04:00 PM
    private int Estate;         // 1: En lista de espera, 2: Visita realizada, 3: Cancelada, 4: Reemplazado

    public ObjInteresado() {
    }

    public int getTurno() {
        return Turno;
    }

    public int setTurno(int turno) {
        this.Turno = turno;
        return this.Turno;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public int setIdPersona(int idPersona) {
        this.IdPersona = idPersona;
        return this.IdPersona;
    }

    public int getPropiedad() {
        return Propiedad;
    }

    public int setPropiedad(int propiedad) {
        this.Propiedad = propiedad;
        return this.Propiedad;
    }

    public int getHorario() {
        return Horario;
    }

    public int setHorario(int horario) {
        this.Horario = horario;
        return this.Horario;
    }

    public int getEstate() {
        return Estate;
    }

    public int setEstate(int estate) {
        this.Estate = estate;
        return this.Estate;
    }
}