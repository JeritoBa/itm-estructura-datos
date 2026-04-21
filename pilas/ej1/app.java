import java.util.Stack;
import java.util.Scanner;

class app {
    private static Stack<PaginaWeb> historial = new Stack<>();
    private static Scanner teclado = new Scanner(System.in);

    private static Sistema Sistema = new Sistema();

    public static void main(String[] args) {
    boolean execution = true;

        // Mostrando menu infinitamente
        while(execution) {
            Sistema.mostrarMenu();

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

                    Sistema.visitarPagina(historial, url, title);

                    break;
            
                case 2:
                    // Clonning original historial to one temporal. 
                    Stack<PaginaWeb> historialTemp = (Stack<PaginaWeb>) historial.clone(); // (Stack<PaginaWeb>) means Casting, for convert from object to stack
                    boolean flag = true; // Conditions the execution of the method

                    do {
                        Sistema.retroceder(historialTemp);
                        flag = Sistema.preguntarRetroceder(historialTemp);
                    } while (flag);

                    break;
                case 3:
                    Sistema.verHistorial(historial);

                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    execution = false;
                    
                    break;
                default:
                    System.out.println("Esa opción no existe, por favor intentelo de nuevo.");

                    break;
            }
        }
    }
} 