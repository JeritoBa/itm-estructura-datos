import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Stack;

class Sistema {
    private static Scanner teclado = new Scanner(System.in);

    // Printing console methods
    public boolean mostrarMenu() {
        System.out.println("--------------------------------");
        System.out.println("Bienvenido a Chrome");
        System.out.println("--------------------------------");
        System.out.println("Escoja la accion que desea hacer: ");
        System.out.println("1. Visitar pagina nueva");
        System.out.println("2. Retroceder");
        System.out.println("3. Ver historial actual");
        System.out.println("4. Salir");

        return true;
    }

    public boolean preguntarRetroceder(Stack<PaginaWeb> historial) {
        if(!historial.isEmpty() && historial.size() > 1) {
            System.out.println("¿Quieres continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int option = teclado.nextInt();

            switch (option) {
                case 1:
                    // Continue
                    return true;
                case 2:
                    return false; // Breaks the while execution
                default:
                    System.out.println("Esa opcion no existe. Saliendo...");
                    return false;
            }
        } else {
            System.out.println("No hay página anterior por visitar");
            return false;
        }
    }

    // System methods
    public Stack<PaginaWeb> visitarPagina(Stack<PaginaWeb> historial, String url, String title) {
        String now = LocalDateTime.now().toString();

        PaginaWeb nuevaPagina = new PaginaWeb(url, title, now);

        // Adding page to history
        historial.push(nuevaPagina);

        // Showing page
        System.out.println("Ahora estás en la pagina " + title);

        // Returning
        return historial;
    }

    public boolean retroceder(Stack<PaginaWeb> historial) {
        // Verificando que no esté vacia y que tenga un anterior
        if(!historial.isEmpty() && historial.size() > 1) {
            // Eliminando la pagina actual
            historial.pop();

            // Mostrando la pagina anterior
            PaginaWeb paginaActual = historial.peek();

            // Imprimiendo en consola
            System.out.println("Ahora estás en la página " + paginaActual.getTitle());
            System.out.println(paginaActual.toString());

            // Returning
            return true;
        } else {
            // Si está vacia
            System.out.println("No existe pagina anterior");
            return false;
        }
    }

    public boolean verHistorial(Stack<PaginaWeb> historial) {
        // Verificando que no esté vacia
        if(!historial.isEmpty()) {
            for(PaginaWeb paginaActual : historial) {
                System.out.println(paginaActual.toString());
            }

            // Returning
            return true;
        } else {
            // Si está vacia
            System.out.println("No hay historial aún"); 

            return false;
        }
    }
}