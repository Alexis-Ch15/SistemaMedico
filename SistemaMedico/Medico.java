public class Medico extends Empleado{
    private String especialidad;
    private int numeroPacienteAtendidos;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo,String especialidad){
        super(cedula, nombre, edad, telefono, correo);
        setEspecialidad(especialidad);
        setNumeroPacienteAtendidos(0);
        setValorConsulta(15);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getNumeroPacienteAtendidos() {
        return numeroPacienteAtendidos;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isEmpty()) {
            throw new IllegalArgumentException("No se puede dejar vacio este campo");
        }
        this.especialidad = especialidad;
    }

    public void setNumeroPacienteAtendidos(int numeroPacienteAtendidos) {
        if (numeroPacienteAtendidos < 0) {
            throw new IllegalArgumentException("Los pacientes atendidos deben ser mayor o igual a cero.");
        }
        this.numeroPacienteAtendidos = numeroPacienteAtendidos;
    }

    public void setValorConsulta(double valorConsulta) {
        if (valorConsulta <= 0) {
            throw new IllegalArgumentException("El valor de la consulta debe ser mayor a cero.");
        }
        this.valorConsulta = valorConsulta;
    }

    @Override
    double calcularPago() {
        return numeroPacienteAtendidos * valorConsulta;
    }

    @Override
    public String toString() {
        return "Rol: Medico | " + super.toString()+
                " | Especialidad: " + especialidad +
                " | Numero de pacientes atendidos: " + numeroPacienteAtendidos +
                " | Valor Consulta: " + valorConsulta;
    }
}