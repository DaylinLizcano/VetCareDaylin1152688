
package modelo;


public class Mascota {
    
    private String codigo;
    private String nombre;
    private String tipo;
    private int peso;

    public Mascota(String codigo, String nombre, String tipo, int peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    @Override
    public String toString() {
        return "Mascota|" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", peso=" + peso + '|';
    }
    
    
}
