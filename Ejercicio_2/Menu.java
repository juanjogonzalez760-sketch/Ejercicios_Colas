import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<ObjTramite> cola = new LinkedList<>();
        Stack<ObjTramite> historial = new Stack<>();
        MetodosTramite m = new MetodosTramite();
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========================================");
            System.out.println("      OFICINA DE TRAMITES Y DOCUMENTOS   ");
            System.out.println("=========================================");
            System.out.println("1) Radicar solicitud (Ingresar a cola)");
            System.out.println("2) Mostrar todas las solicitudes");
            System.out.println("3) Mostrar solicitudes en espera");
            System.out.println("4) Mostrar tramites finalizados");
            System.out.println("5) Llamar ciudadano a ventanilla");
            System.out.println("6) Modificar informacion de la solicitud");
            System.out.println("7) Cancelar solicitud");
            System.out.println("8) Finalizar tramite en curso");
            System.out.println("9) Consultar historial de lo ocurrido");
            System.out.println("10) Salir");
            System.out.print("Seleccione una opcion: ");

            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    cola = m.LlenarCola(cola, historial, m, sc);
                    break;
                case 2:
                    System.out.println("\n" + m.MostrarTodosTurnos(cola, 1));
                    break;
                case 3:
                    System.out.println("\n" + m.MostrarTodosTurnos(cola, 2));
                    break;
                case 4:
                    System.out.println("\n" + m.MostrarTodosTurnos(cola, 3));
                    break;
                case 5:
                    cola = m.SerLlamado(cola, historial);
                    break;
                case 6:
                    cola = m.ModificarInformacion(cola, historial, m, sc);
                    break;
                case 7:
                    cola = m.CancelarSolicitud(cola, historial, sc);
                    break;
                case 8:
                    cola = m.FinalizarTramite(cola, historial);
                    break;
                case 9:
                    System.out.println("\n" + m.MostrarHistorial(historial));
                    break;
                case 10:
                    System.out.println("Cerrando sistema de la oficina. Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Esta opcion no existe.");
                    break;
            }
        }
    }
}