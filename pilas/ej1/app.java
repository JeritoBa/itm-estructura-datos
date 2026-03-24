import java.util.Stack;
import java.time.LocalDateTime;
import java.util.Scanner;

class app {
    private static Stack<PaginaWeb> historial = new Stack<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Mostrando menu infinitamente
        while(true) {
            mostrarMenu();

            int opcion;

            System.out.print("Ingrese la opcion que desea: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    teclado.nextLine(); // Buffer reset

                    String url;
                    String title;

                    System.out.print("Ingrese la url que desea visitar: ");
                    url = teclado.nextLine();

                    System.out.print("Ingrese el titulo de la pagina: ");
                    title = teclado.nextLine();

                    visitarPagina(url, title);

                    break;
            
                case 2:
                    retroceder();

                    break;
                case 3:
                    verHistorial();

                    break;
                default:
                    System.out.println("Esa opción no existe, por favor intentelo de nuevo.");

                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("--------------------------------");
        System.out.println("Bienvenido a Chrome");
        System.out.println("--------------------------------");
        System.out.println("Escoja la accion que desea hacer: ");
        System.out.println("1. Visitar pagina nueva");
        System.out.println("2. Retroceder");
        System.out.println("3. Ver historial actual");
    }

    public static void visitarPagina(String url, String title) {
        String now = LocalDateTime.now().toString();

        PaginaWeb nuevaPagina = new PaginaWeb(url, title, now);

        // Adding page to history
        historial.push(nuevaPagina);

        // Showing page
        System.out.println("Ahora estás en la pagina " + title);
    }

    public static void retroceder() {
        // Verificando que no esté vacia y que tenga un anterior
        if(!historial.isEmpty() && historial.size() > 1) {
            // Eliminando la pagina actual
            historial.pop();

            // Mostrando la pagina anterior
            PaginaWeb paginaActual = historial.peek();

            // Imprimiendo en consola
            System.out.println("Ahora estás en la página " + paginaActual.getTitle());
        } else {
            // Si está vacia
            System.out.println("No existe pagina anterior");
        }
    }

    public static void verHistorial() {
        // Verificando que no esté vacia
        if(!historial.isEmpty()) {
            for(PaginaWeb paginaActual : historial) {
                System.out.println(paginaActual.toString());
            }
        } else {
            // Si está vacia
            System.out.println("No hay historial aún"); 
        }
    }
} 