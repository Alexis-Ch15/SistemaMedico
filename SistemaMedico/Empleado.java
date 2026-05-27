public abstract class Empleado {
    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;

    public Empleado(String cedula, String nombre, int edad, String telefono, String correo) {
        if (cedula == null || cedula.trim().isEmpty()){
            throw new IllegalArgumentException("La cedula no puede estar vacia.");
        }
        if (nombre == null ||nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        setEdad(edad);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public void setEdad(int edad) {
        if (edad <= 0 || edad >150){
            throw new IllegalArgumentException("La edad esta fuera del rango");
        }
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        for (int i = 0; i < telefono.length(); i++) {
            char c = telefono.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("El teléfono solo debe contener números.");
            }
        }
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        if(!correo.contains("@") || !correo.contains(".")){
            throw new IllegalArgumentException("Su correo debe contener un @ y .");
        }
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String toString() {
        return "Nombre: " + nombre +
                " | Cedula: " + cedula +
                " | Edad: " + edad +
                " | Telefono: " + telefono+
                " | Correo: " + correo + "";
    }
    abstract double calcularPago();
}