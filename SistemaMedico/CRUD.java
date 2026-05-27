import java.util.*;
public class CRUD {
    private ArrayList<Empleado>empleados;
    private ArrayList<Medico>medicos;
    private ArrayList<Administrativo>administrativos;
    private Scanner sc;

    public CRUD() {
        empleados = new ArrayList<>();
        medicos = new ArrayList<>();
        administrativos = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public String duplicados() {
        while (true) {
            String cedula = sc.nextLine();
            boolean encontrada = false;
            for (Empleado e : empleados) {
                if (cedula.equals(e.getCedula())) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                return cedula;
            }
            System.out.print("La cédula ya existe, intente nuevamente: ");
        }
    }
    public int cambio(){
        while(true) {
            try {
                String valor_cambiar = sc.nextLine();
                return Integer.parseInt(valor_cambiar);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Ingrese un numero valido");
            }
        }
    }
    public void agregarMedico(){
        try {
            System.out.print("Cedula:");
            String cedula = duplicados();
            System.out.print("Nombre:");
            String nombre = sc.nextLine();
            System.out.print("Edad:");
            int edad = cambio();
            System.out.print("Telefono: ");
            String telfono = sc.nextLine();
            System.out.print("COrreo: ");
            String correo = sc.nextLine();
            System.out.print("Especialidad: ");
            String especi = sc.nextLine();
            Medico m = new Medico(cedula,nombre,edad,telfono,correo,especi);
            empleados.add(m);
            medicos.add(m);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void agregarAdmistrador(){
        try {
            System.out.print("Cedula:");
            String cedula = duplicados();
            System.out.print("Nombre:");
            String nombre = sc.nextLine();
            System.out.print("Edad:");
            int edad = cambio();
            System.out.print("Telefono: ");
            String telfono = sc.nextLine();
            System.out.print("COrreo: ");
            String correo = sc.nextLine();
            System.out.print("Departamento:");
            String dep = sc.nextLine();
            Administrativo a = new Administrativo(cedula,nombre,edad,telfono,correo,dep);
            empleados.add(a);
            administrativos.add(a);
        }catch (IllegalArgumentException e){
            System.out.println("Error en el ingreso de los datos");
        }
    }
    public void mostrarEmpleados(){
        for(Empleado e : empleados){
            System.out.println(e.toString());
        }
    }
    public Empleado buscadorCedula(String cedula){
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }
    public void mostrarEmpleado(String cedula){
        Empleado e = buscadorCedula(cedula);
        System.out.println(e.toString());
    }

    public void reemplazarInfo() {
        System.out.print("Ingrese la cédula del empleado a modificar: ");
        String ced = sc.nextLine();
        Empleado e = buscadorCedula(ced);
        if (e == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        if (e instanceof Medico) {
            Medico m = (Medico) e;
            System.out.println("Modificando al Médico: " + m.getNombre());
            System.out.print("Ingrese nuevos pacientes atendidos: ");
            m.setNumeroPacienteAtendidos(cambio());
            System.out.print("Ingrese nuevo valor de consulta: ");
            m.setValorConsulta(Double.parseDouble(sc.nextLine()));
            System.out.println("Información actualizada correctamente.");

        } else if (e instanceof Administrativo) {
            Administrativo a = (Administrativo) e;
            System.out.println("Modificando al Administrativo: " + a.getNombre());
            System.out.print("Ingrese nuevo departamento: ");
            a.setDepartamento(sc.nextLine());
            System.out.print("Ingrese nuevas horas trabajadas: ");
            a.setHorasTrabajadas(cambio());
            System.out.println("Información actualizada correctamente.");
        }
    }
    public void eliminarRegistro(){
        System.out.print("Ingrese cédula a eliminar: ");
        String ced = sc.nextLine();
        Empleado e = buscadorCedula(ced);
        if (e != null) {
            empleados.remove(e);
            medicos.remove(e);
            administrativos.remove(e);
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("No encontrado.");
        }
    }
    public void calcularPago(){
        System.out.print("Ingrese cédula: ");
        Empleado e = buscadorCedula(sc.nextLine());
        if (e != null){
            System.out.println("Pago total: " + e.calcularPago());
        }
        else {
            System.out.println("Empleado no encontrado.");
        }
    }
    public void mostrarListas(String nombre,ArrayList<? extends Empleado>personas){
        int contador = 0;
        double totalLista = 0;
        System.out.println("Estadisticas de " + nombre);
        for(Empleado e: personas){
            System.out.println(e.toString());
            contador += 1;
        }
        System.out.println("Total de "+ nombre + ": " + contador);
        for(Empleado e: personas){
            totalLista += e.calcularPago();
        }
        System.out.println("Pago Total de "+ nombre + ": "+ totalLista);
    }
    public void MayorPago(){
        double mayorM = 0;
        double mayorA = 0;
        double mayorfinal = 0;
        for(Empleado m : medicos){
            if (mayorM == 0 || mayorM < m.calcularPago()){
                mayorM = m.calcularPago();
                System.out.println("Pago mas alto en medicos: " + mayorM);
            }
        }
        for (Empleado a : administrativos){
            if (mayorA == 0 || mayorA < a.calcularPago()){
                mayorA = a.calcularPago();
                System.out.println("Pago mas alto en adimistrativos: "+ mayorA);
            }
        }
        if (mayorM > mayorA) {
            System.out.println();
            mayorfinal =mayorM;
        } else if (mayorA > mayorM) {
            mayorfinal = mayorA;
        }

        System.out.println("Pago mas alto: " + mayorfinal);
    }
    public void mostrarEstadisticas(){
        mostrarListas("Empleados",empleados);
        mostrarListas("Medicos",medicos);
        mostrarListas("Admistrativo",administrativos);
        MayorPago();
    }
}