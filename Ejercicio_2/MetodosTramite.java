import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MetodosTramite {

    public Queue<ObjTramite> LlenarCola(Queue<ObjTramite> cola, Stack<ObjTramite> historial, MetodosTramite m, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            ObjTramite t = new ObjTramite();
            t.setTurno(m.ValidarTurno(cola));
            t.setTipoDocumento(m.MenuDocumentos(sc));
            t.setEstado(1); // 1 = Pendiente
            t.setDescripcionHistorico("Turno " + t.getTurno() + " registrado solicitando: " + m.NombreDocumento(t.getTipoDocumento()));

            cola.offer(t);
            historial.push(t); // Se registra en el historial de eventos

            System.out.println("Desea agregar otra solicitud? 1) Si, 2) No: ");
            int opt = sc.nextInt();
            if (opt == 2) {
                continuar = false;
            }
        }
        return cola;
    }

    public int ValidarTurno(Queue<ObjTramite> cola) {
        if (cola.isEmpty()) {
            return 1;
        }
        return cola.size() + 1;
    }

    public int MenuDocumentos(Scanner sc) {
        System.out.println("Seleccione el documento a tramitar:");
        System.out.println("1) Cedula de Ciudadania");
        System.out.println("2) Pasaporte");
        System.out.println("3) Certificado de Residencia");
        System.out.println("4) Libreta Militar");
        return sc.nextInt();
    }

    public String NombreDocumento(int opt) {
        switch (opt) {
            case 1: return "Cedula de Ciudadania";
            case 2: return "Pasaporte";
            case 3: return "Certificado de Residencia";
            default: return "Libreta Militar";
        }
    }

    public String NombreEstado(int estado) {
        switch (estado) {
            case 1: return "Pendiente en espera";
            case 2: return "Llamado / En atencion";
            case 3: return "Tramite Finalizado";
            case 4: return "Tramite Cancelado";
            default: return "Desconocido";
        }
    }

    public String MostrarTodosTurnos(Queue<ObjTramite> cola, int optFiltro) {
        for (ObjTramite t : cola) {
            boolean mostrar = false;
            if (optFiltro == 1) { // Todos
                mostrar = true;
            } else if (optFiltro == 2 && t.getEstado() == 1) { // Pendientes
                mostrar = true;
            } else if (optFiltro == 3 && t.getEstado() == 3) { // Finalizados
                mostrar = true;
            }

            if (mostrar) {
                System.out.println("Turno: " + t.getTurno());
                System.out.println("Documento: " + NombreDocumento(t.getTipoDocumento()));
                System.out.println("Estado: " + NombreEstado(t.getEstado()));
                System.out.println("----------------------------------------- \n");
            }
        }
        return "Solicitudes consultadas con exito";
    }

    // Llamar al ciudadano
    public Queue<ObjTramite> SerLlamado(Queue<ObjTramite> cola, Stack<ObjTramite> historial) {
        for (ObjTramite t : cola) {
            if (t.getEstado() == 1) {
                t.setEstado(2); // En atencion
                t.setDescripcionHistorico("Turno " + t.getTurno() + " ha sido llamado a ventanilla.");
                historial.push(t);
                System.out.println("Llamando al Turno " + t.getTurno() + " para ventanilla.");
                return cola;
            }
        }
        System.out.println("No hay solicitudes pendientes en espera.");
        return cola;
    }

    // Finalizar el trámite
    public Queue<ObjTramite> FinalizarTramite(Queue<ObjTramite> cola, Stack<ObjTramite> historial) {
        for (ObjTramite t : cola) {
            if (t.getEstado() == 2) {
                t.setEstado(3); // Finalizado
                t.setDescripcionHistorico("Turno " + t.getTurno() + " finalizo con exito su documento: " + NombreDocumento(t.getTipoDocumento()));
                historial.push(t);
                System.out.println("Tramite finalizado con exito para el Turno " + t.getTurno());
                return cola;
            }
        }
        System.out.println("No hay ningun turno en estado de atencion para finalizar.");
        return cola;
    }

    // Modificar tipo de documento
    public Queue<ObjTramite> ModificarInformacion(Queue<ObjTramite> cola, Stack<ObjTramite> historial, MetodosTramite m, Scanner sc) {
        System.out.println("Ingrese el turno de la solicitud a modificar: ");
        int turno = sc.nextInt();
        for (ObjTramite t : cola) {
            if (t.getTurno() == turno && (t.getEstado() == 1 || t.getEstado() == 2)) {
                int nuevoDoc = m.MenuDocumentos(sc);
                t.setTipoDocumento(nuevoDoc);
                t.setDescripcionHistorico("Turno " + t.getTurno() + " modifico su tramite a: " + m.NombreDocumento(nuevoDoc));
                historial.push(t);
                System.out.println("Informacion modificada exitosamente.");
                return cola;
            }
        }
        System.out.println("No se encontro el turno o ya fue finalizado/cancelado.");
        return cola;
    }

    // Cancelar la solicitud
    public Queue<ObjTramite> CancelarSolicitud(Queue<ObjTramite> cola, Stack<ObjTramite> historial, Scanner sc) {
        System.out.println("Ingrese el turno a cancelar: ");
        int turno = sc.nextInt();
        for (ObjTramite t : cola) {
            if (t.getTurno() == turno && (t.getEstado() == 1 || t.getEstado() == 2)) {
                t.setEstado(4); // Cancelado
                t.setDescripcionHistorico("Turno " + t.getTurno() + " cancelo la solicitud.");
                historial.push(t);
                System.out.println("Solicitud del turno " + turno + " cancelada.");
                return cola;
            }
        }
        System.out.println("Turno no disponible para cancelacion.");
        return cola;
    }

    // Mostrar el historial acumulado en la Pila
    public String MostrarHistorial(Stack<ObjTramite> historial) {
        if (historial.isEmpty()) {
            return "El historial esta vacio.";
        }
        System.out.println("----- HISTORIAL DE ACCIONES (PILA) -----");
        for (ObjTramite t : historial) {
            System.out.println("Registro: " + t.getDescripcionHistorico());
            System.out.println("Estado actual: " + NombreEstado(t.getEstado()));
            System.out.println("----------------------------------------");
        }
        return "Historial listado correctamente";
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un numero valido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}