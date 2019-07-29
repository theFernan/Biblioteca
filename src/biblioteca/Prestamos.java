package biblioteca;

import java.io.Serializable;

public class Prestamos implements Serializable{
    
    private String codigoLibro;
    private String nombre;
    private String carrera;

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public Prestamos(){
    }
    
    public Prestamos(String codigoLibro, String nombre, String carrera){
        this.codigoLibro=codigoLibro;
        this.nombre=nombre;
        this.carrera=carrera;
    }
}
