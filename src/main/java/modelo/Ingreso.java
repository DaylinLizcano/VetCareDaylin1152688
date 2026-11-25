
package modelo;

public class Ingreso {
    
    private int consecutivo;
    private Mascota mascota;
    private Espacio espacio;
    private String estado;

    public Ingreso(int consecutivo, Mascota mascota, Espacio espacio) {
        this.consecutivo = consecutivo;
        this.mascota = mascota;
        this.espacio = espacio;
        this.estado = "ACTIVO";
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public String getEstado() {
        return estado;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ingreso|" + "consecutivo=" + consecutivo + ", mascota=" + mascota + ", espacio=" + espacio + ", estado=" + estado + '|';
    }
    
}
