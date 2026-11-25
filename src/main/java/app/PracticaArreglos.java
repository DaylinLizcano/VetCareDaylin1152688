package app;

public class PracticaArreglos {

    public static void main(String[] args) {
        
        double[] pesos = {18, 11, 4, 25.5, 7, 12};
        
        for (int i = 0; i < pesos.length; i++) {
            System.out.println("Posicion " + i + ": " + pesos[i] + " kg");
        }
        
        double suma = 0;
        
        for (int i = 0; i < pesos.length; i++) {
            suma = suma + pesos[i];
        }
        double promedio = suma / pesos.length;
        System.out.println("El promedio es: " + promedio);
        
        double mayor = pesos[0];
        
        for (int i = 1; i < pesos.length; i++) {
            if (pesos[i] > mayor) {
                mayor = pesos[i];
            }
        }
        System.out.println("El peso mayor es: " + mayor);
        
        int contador = 0;
        
        for (int i = 0; i < pesos.length; i++) {
            if (pesos[i] <= 12) {
                contador++;
            }
        }
        System.out.println("Mascotas que pesan 12 kg o menos: " + contador);
    }
}
