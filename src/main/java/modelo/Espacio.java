
package modelo;

public class Espacio {
    
    private String codigo;
    private String tipo;
    private int peso;
    private String estado;

    public Espacio(String codigo, String tipo, int peso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.peso = peso;
        this.estado = "DISPONIBLE";
    }

    // Este es el método que necesita ClinicaVet para saber si la mascota cumple las reglas
    public boolean admite(Mascota m) {
        if (this.tipo.equalsIgnoreCase(m.getTipo()) && m.getPeso() <= this.peso) {
            return true;
        }
        return false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Espacio|" + "codigo=" + codigo + ", tipo=" + tipo + ", peso=" + peso + ", estado=" + estado + '|';
    }  
}