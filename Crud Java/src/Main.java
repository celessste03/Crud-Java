//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Participante> participante = new ArrayList<>();
    private static int ID;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("====🍀🍀BINGO BINGO🍀🍀===");
            System.out.println("1. Agregar Participante");
            System.out.println("2. Mostrar Participantes");
            System.out.println("3. Actualizar Participantes");
            System.out.println("4. Eliminar Participantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    crearParticipante(scanner);
                    Enter(scanner);
                    break;
                case 2:
                    MostrarParticipante();
                    Enter(scanner);
                    break;
                case 3:
                    actualizarParticipante(scanner);
                    Enter(scanner);
                    break;
                case 4:
                    eliminarParticipante(scanner);
                    Enter(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
    private static void Enter(Scanner scanner){
        System.out.println("Presiona enter para continuar✅✅ ");
        scanner.nextLine();
    }

    private static void crearParticipante(Scanner scanner) {

        int ID=0;
        while (true) {
            System.out.print("Ingrese número de cartón: ");

            try {
                ID= Validador.validarID(scanner.nextInt());
                scanner.nextLine();

                break;
            } catch (ValiException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error no controlado: " + e.getMessage());

            }
        }

        String nombre = null;

        while (nombre == null) {
            System.out.print("Ingrese su nombre: ");
            try {
                nombre = Validador.validarLetras(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        float referencia_pago;
        while (true) {
            System.out.print("Ingrese referencia de pago: ");
            String input = scanner.nextLine();
            try {
                referencia_pago = Validador.validarFloat(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        participante.add(new Participante(ID++, nombre, referencia_pago));
        System.out.println("Participante Agregado🥰🥰.");
    }

    private static void MostrarParticipante() {
        if (participante.isEmpty()) {
            System.out.println("No hay participantes para mostrar😔.");
            return;
        }
        System.out.println("Lista de Participantes:");
        for (Participante participante : participante) {
            System.out.println(participante);
        }
    }

    private static void actualizarParticipante(Scanner scanner) {
        System.out.print("Ingrese el numero de carton a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Participante participante : participante) {
            if (participante.getId() == id) {

                String nuevoNombre = null;
                while (nuevoNombre == null) {
                    System.out.print("Nuevo nombre: ");

                    try {
                        nuevoNombre = Validador.validarLetras(scanner.nextLine());
                        // Ya no necesitas 'break', ya que si la validación tiene éxito, saldrá del bucle.
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // Mensaje específico para la excepción de validación
                    }catch (Exception e) {
                        System.out.println("Error no controlado");
                        System.out.println(e.getMessage());
                    }
                }
                float nuevareferencia_pago;
                while (true) {
                    System.out.print("Nueva referencia de pago: ");
                    String input = scanner.nextLine();
                    try {
                        nuevareferencia_pago = Validador.validarFloat(input);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                /*System.out.print("Nuevo referencia de pago: ");
                double nuevareferencia_pago = scanner.nextDouble();*/
                participante.setNombre(nuevoNombre);
                participante.setReferencia_pago(nuevareferencia_pago);
                System.out.println("Producto actualizado.👌");
                return;
            }
        }
        System.out.println("Producto no encontrado😑😑.");
    }

    private static void eliminarParticipante(Scanner scanner) {
        System.out.print("Ingrese el numero de carton a eliminar: ");
        int id = scanner.nextInt();

        for (int i = 0; i < participante.size(); i++) {
            if (participante.get(i).getId() == id) {
                participante.remove(i);
                System.out.println("Participante eliminado😊.");
                return;
            }
        }
        System.out.println("Participante no encontrado😓😔.");
    }
}
