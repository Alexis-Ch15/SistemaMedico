public class Administrativo extends Empleado{
    private String departamento;
    private int horasTrabajadas;
    private  int valorHora;
    public Administrativo(String cedula, String nombre, int edad, String telefono, String correo,String departamento){
        super(cedula, nombre, edad, telefono, correo);
        setDepartamento(departamento);
        setHorasTrabajadas(0);
        setValorHora(20);
    }

    public void setDepartamento(String departamento) {
        if(departamento == null || departamento.trim().isEmpty()){
            throw new IllegalArgumentException("Ingrese un departamento porfa.");
        }
        this.departamento = departamento;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if(horasTrabajadas <= 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas.");
        }
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setValorHora(int valorHora) {
        if(valorHora <= 0) {
            throw new IllegalArgumentException("El valor no pueden ser negativas.");
        }
        this.valorHora = valorHora;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getValorHora() {
        return valorHora;
    }
    @Override
    double calcularPago() {
        return horasTrabajadas * valorHora;
    }
}
