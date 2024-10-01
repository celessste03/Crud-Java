public class Participante {
    private int id;
    private String nombre;
    private double referencia_pago;

    public Participante(int id, String nombre, double referencia_pago) {
        this.id = id;
        this.nombre = nombre;
        this.referencia_pago = referencia_pago;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getReferencia_pago() {
        return referencia_pago;
    }

    public void setReferencia_pago(double referencia_pago) {
        this.referencia_pago = referencia_pago;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", referencia_pago=" + referencia_pago +
                '}';
    }
}