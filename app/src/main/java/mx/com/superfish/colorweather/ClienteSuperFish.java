package mx.com.superfish.colorweather;

public class ClienteSuperFish {

    private String nombre;
    private String correo;
    private String fecha;
    private String horario;

    public ClienteSuperFish(String nombre, String correo, String fecha, String horario) {
        this.nombre = nombre;
        this.correo = correo;
        this.fecha = fecha;
        this.horario = horario;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHorario() {return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
