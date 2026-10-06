import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<ObjInteresado> cola = new LinkedList<>();
        Stack<ObjInteresado> pila = new Stack<>();
        MetodosInmobiliaria m = new MetodosInmobiliaria();
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========================================");
            System.out.println("   INMOBILIARIA — VISITAS A PROPIEDADES  ");
            System.out.println("=========================================");
            System.out.println("1) Registrar interesado a lista de espera");
            System.out.println("2) Mostrar toda la lista");
            System.out.println("3) Mostrar interesados en espera");
            System.out.println("4) Mostrar visitas realizadas");
            System.out.println("5) Atender / Realizar siguiente visita");
            System.out.println("6) Cambiar horario de visita");
            System.out.println("7) Reemplazar interesado por persona autorizada");
            System.out.println("8) Cancelar visita");
            System.out.println("9) Apilar visitas pendientes");
            System.out.println("10) Salir");
            System.out.print("Seleccione una opcion: ");

            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    cola = m.LlenarCola(cola, m, sc);
                    break;
                case 2:
                    System.out.println("\n" + m.MostrarLista(cola, 1));
                    break;
                case 3:
                    System.out.println("\n" + m.MostrarLista(cola, 2));
                    break;
                case 4:
                    System.out.println("\n" + m.MostrarLista(cola, 3));
                    break;
                case 5:
                    cola = m.RealizarVisita(cola);
                    break;
                case 6:
                    cola = m.CambiarHorario(cola, m, sc);
                    break;
                case 7:
                    cola = m.ReemplazarPersona(cola, sc);
                    break;
                case 8:
                    cola = m.CancelarVisita(cola, sc);
                    break;
                case 9:
                    pila = m.ApilarPendientes(cola, pila);
                    System.out.println(m.MostrarPila(pila));
                    break;
                case 10:
                    System.out.println("Saliendo del sistema inmobiliario. Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Esta opcion no existe.");
                    break;
            }
        }
    }
}