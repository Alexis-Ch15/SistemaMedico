import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CRUD funciones = new CRUD();

        int op = 0;
        do {
            System.out.println("SISTEMA CLINICO");
            System.out.println("1.  Registrar Medico");
            System.out.println("2.  Registrar Admistrativo");
            System.out.println("3.  Mostrar Empleados");
            System.out.println("4.  Buscar por Cedula");
            System.out.println("5.  Reemplazar informacion");
            System.out.println("6.  Eliminar Registro");
            System.out.println("7.  Calcular Pago");
            System.out.println("8.  Mostrar Estadisticas");
            System.out.println("0.  Salir");
            try{
                op = Integer.parseInt(sc.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Numero ingresado invalido");
                op =-1;
                continue;
            }
            switch (op) {
                case 1 -> funciones.agregarMedico();
                case 2 -> funciones.agregarAdmistrador();
                case 3 -> funciones.mostrarEmpleados();
                case 4 -> {
                    System.out.print("Ingrese su cedula: ");
                    funciones.mostrarEmpleado(sc.nextLine());
                }
                case 5 -> funciones.reemplazarInfo();
                case 6 -> funciones.eliminarRegistro();
                case 7 -> funciones.calcularPago();
                case 8 -> funciones.mostrarEstadisticas();
            }
        } while (op != 0);
        System.out.println("Gracias por su preferencia");
        sc.close();
    }
}