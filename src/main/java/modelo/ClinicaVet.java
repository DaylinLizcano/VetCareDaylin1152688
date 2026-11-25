/*
// Sin arreglos 

public class ClinicaVet {
    
    private Espacio e1, e2, e3, e4;
    private Ingreso i1, i2, i3;
    private int consecutivo;

    public ClinicaVet() {
        this.consecutivo = 1;
    }
    
    public String crearEspaciosHospitalizacion() {
        e1 = new Espacio("E1", "PERRO", 30);
        e2 = new Espacio("E2", "PERRO", 20);
        e3 = new Espacio("E3", "GATO", 10);
        e4 = new Espacio("E4", "GATO", 12);
        
        return "ESPACIOS CREADOS\n"
                + e1 + "\n"
                + e2 + "\n"
                + e3 + "\n"
                + e4;
    }
    
    private Espacio buscarEspacio(String codigo) {
        if (e1 != null && e1.getCodigo().equalsIgnoreCase(codigo)) return e1;
        if (e2 != null && e2.getCodigo().equalsIgnoreCase(codigo)) return e2;
        if (e3 != null && e3.getCodigo().equalsIgnoreCase(codigo)) return e3;
        if (e4 != null && e4.getCodigo().equalsIgnoreCase(codigo)) return e4;
        return null; 
    }
    
    private boolean registrarMascota(String codigo) {
        if (i1 != null && i1.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        if (i2 != null && i2.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        if (i3 != null && i3.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        return false;      
    }

    public String registrarIngreso(String codigo, String nombre, String tipo, int peso, String codEspacio) {
        if (e1 == null) {
            return "Error: primero hay que crear los espacios";
        }
        if (i1 != null && i2 != null && i3 != null) {
            return "Error: ya hay tres ingresos";
        }
        if (registrarMascota(codigo)) {
            return "Error: el codigo " + codigo + " ya existe";
        }
        
        Espacio espacio = buscarEspacio(codEspacio);
        if (espacio == null) {
            return "Error: el espacio " + codEspacio + " no existe";
        }
        if (!espacio.getEstado().equalsIgnoreCase("DISPONIBLE")) {
            return "Error: el espacio no esta disponible";
        }
        
        Mascota mascota = new Mascota(codigo, nombre, tipo, peso);
        if (!espacio.admite(mascota)) {
            return "Error: el espacio no admite esta mascota por tipo o peso";
        }
        
        int numeroIngreso = consecutivo;
        consecutivo++;
        
        Ingreso ingreso = new Ingreso(numeroIngreso, mascota, espacio);
        
        if (i1 == null) {
            i1 = ingreso;
        } else if (i2 == null) {
            i2 = ingreso;
        } else {
            i3 = ingreso;
        }
        
        espacio.setEstado("OCUPADO");
        ingreso.setEstado("ACTIVO");
    
        return "Ingreso " + ingreso.getConsecutivo() + " ACTIVO; " + espacio.getCodigo() + " OCUPADO";
    }
    
    public String reubicarMascota(String codEspacio) {
        if (e1 == null) {
            return "Error: primero hay que crear los espacios";
        } 
        
        Espacio espacioAfectado = buscarEspacio(codEspacio);
        if (espacioAfectado == null) {
            return "Error: el espacio no existe";
        }
        if (!espacioAfectado.getEstado().equalsIgnoreCase("OCUPADO")) {
            return "Error: " + codEspacio + " no esta OCUPADO";
        }

        Ingreso ingreso = null;
        if (i1 != null && (i1.getEstado().equals("ACTIVO") || i1.getEstado().equals("REUBICADO")) && i1.getEspacio() == espacioAfectado) {
            ingreso = i1;
        } else if (i2 != null && (i2.getEstado().equals("ACTIVO") || i2.getEstado().equals("REUBICADO")) && i2.getEspacio() == espacioAfectado) {
            ingreso = i2;
        } else if (i3 != null && (i3.getEstado().equals("ACTIVO") || i3.getEstado().equals("REUBICADO")) && i3.getEspacio() == espacioAfectado) {
            ingreso = i3;
        }

        if (ingreso == null) {
            return "Error: no hay ingreso activo o reubicado en este espacio";
        }

        espacioAfectado.setEstado("MANTENIMIENTO");

        Mascota m = ingreso.getMascota();
        Espacio nuevoEspacio = null;
        
        if (e1 != null && e1.getEstado().equalsIgnoreCase("DISPONIBLE") && e1.admite(m)) nuevoEspacio = e1;
        else if (e2 != null && e2.getEstado().equalsIgnoreCase("DISPONIBLE") && e2.admite(m)) nuevoEspacio = e2;
        else if (e3 != null && e3.getEstado().equalsIgnoreCase("DISPONIBLE") && e3.admite(m)) nuevoEspacio = e3;
        else if (e4 != null && e4.getEstado().equalsIgnoreCase("DISPONIBLE") && e4.admite(m)) nuevoEspacio = e4;

        if (nuevoEspacio != null) {
            ingreso.setEspacio(nuevoEspacio);
            ingreso.setEstado("REUBICADO");
            nuevoEspacio.setEstado("OCUPADO");
            return espacioAfectado.getCodigo() + " en MANTENIMIENTO; " + m.getNombre() + " pasa a " + nuevoEspacio.getCodigo() + "; ingreso " + ingreso.getConsecutivo() + " REUBICADO";
        } else {
            ingreso.setEspacio(null);
            ingreso.setEstado("PENDIENTE DE TRASLADO");
            return espacioAfectado.getCodigo() + " en MANTENIMIENTO; no hay otro espacio para " + m.getNombre() + "; ingreso " + ingreso.getConsecutivo() + " PENDIENTE DE TRASLADO";
        }
    }
}
*/

package modelo;

public class ClinicaVet {
    
    private Espacio[] espacios;
    private Ingreso i1, i2, i3;
    private int consecutivo;

    public ClinicaVet() {
        this.consecutivo = 1;
    }
    
    public String crearEspaciosHospitalizacion() {
        espacios = new Espacio[4];
        espacios[0] = new Espacio("E1", "PERRO", 30);
        espacios[1] = new Espacio("E2", "PERRO", 20);
        espacios[2] = new Espacio("E3", "GATO", 10);
        espacios[3] = new Espacio("E4", "GATO", 12);
        
        String mensaje = "ESPACIOS CREADOS\n";
        for (int i = 0; i < espacios.length; i++) {
            mensaje += espacios[i].toString() + "\n";
        }
        return mensaje;
    }
    
    private Espacio buscarEspacio(String codigo) {
        if (espacios == null) return null;
        
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i].getCodigo().equalsIgnoreCase(codigo)) {
                return espacios[i];
            }
        }
        return null; 
    }
    
    private boolean registrarMascota(String codigo) {
        if (i1 != null && i1.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        if (i2 != null && i2.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        if (i3 != null && i3.getMascota().getCodigo().equalsIgnoreCase(codigo)) return true;
        return false;      
    }

    public String registrarIngreso(String codigo, String nombre, String tipo, int peso, String codEspacio) {
        if (espacios == null) {
            return "Error: primero hay que crear los espacios";
        }
        if (i1 != null && i2 != null && i3 != null) {
            return "Error: ya hay tres ingresos";
        }
        if (registrarMascota(codigo)) {
            return "Error: el codigo " + codigo + " ya existe";
        }
        
        Espacio espacio = buscarEspacio(codEspacio);
        if (espacio == null) {
            return "Error: el espacio " + codEspacio + " no existe";
        }
        if (!espacio.getEstado().equalsIgnoreCase("DISPONIBLE")) {
            return "Error: el espacio no esta disponible";
        }
        
        Mascota mascota = new Mascota(codigo, nombre, tipo, peso);
        if (!espacio.admite(mascota)) {
            return "Error: el espacio no admite esta mascota por tipo o peso";
        }
        
        int numeroIngreso = consecutivo;
        consecutivo++;
        
        Ingreso ingreso = new Ingreso(numeroIngreso, mascota, espacio);
        
        if (i1 == null) {
            i1 = ingreso;
        } else if (i2 == null) {
            i2 = ingreso;
        } else {
            i3 = ingreso;
        }
        
        espacio.setEstado("OCUPADO");
        ingreso.setEstado("ACTIVO");
    
        return "Ingreso " + ingreso.getConsecutivo() + " ACTIVO; " + espacio.getCodigo() + " OCUPADO";
    }
    
    public String reubicarMascota(String codEspacio) {
        if (espacios == null) {
            return "Error: primero hay que crear los espacios";
        } 
        
        Espacio espacioAfectado = buscarEspacio(codEspacio);
        if (espacioAfectado == null) {
            return "Error: el espacio no existe";
        }
        if (!espacioAfectado.getEstado().equalsIgnoreCase("OCUPADO")) {
            return "Error: " + codEspacio + " no esta OCUPADO";
        }

        Ingreso ingreso = null;
        if (i1 != null && (i1.getEstado().equals("ACTIVO") || i1.getEstado().equals("REUBICADO")) && i1.getEspacio() == espacioAfectado) {
            ingreso = i1;
        } else if (i2 != null && (i2.getEstado().equals("ACTIVO") || i2.getEstado().equals("REUBICADO")) && i2.getEspacio() == espacioAfectado) {
            ingreso = i2;
        } else if (i3 != null && (i3.getEstado().equals("ACTIVO") || i3.getEstado().equals("REUBICADO")) && i3.getEspacio() == espacioAfectado) {
            ingreso = i3;
        }

        if (ingreso == null) {
            return "Error: no hay ingreso activo o reubicado en este espacio";
        }

        espacioAfectado.setEstado("MANTENIMIENTO");

        Mascota m = ingreso.getMascota();
        Espacio nuevoEspacio = null;
        
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i].getEstado().equalsIgnoreCase("DISPONIBLE") && espacios[i].admite(m)) {
                nuevoEspacio = espacios[i];
                break;
            }
        }

        if (nuevoEspacio != null) {
            ingreso.setEspacio(nuevoEspacio);
            ingreso.setEstado("REUBICADO");
            nuevoEspacio.setEstado("OCUPADO");
            return espacioAfectado.getCodigo() + " en MANTENIMIENTO; " + m.getNombre() + " pasa a " + nuevoEspacio.getCodigo() + "; ingreso " + ingreso.getConsecutivo() + " REUBICADO";
        } else {
            ingreso.setEspacio(null);
            ingreso.setEstado("PENDIENTE DE TRASLADO");
            return espacioAfectado.getCodigo() + " en MANTENIMIENTO; no hay otro espacio para " + m.getNombre() + "; ingreso " + ingreso.getConsecutivo() + " PENDIENTE DE TRASLADO";
        }
    }
}