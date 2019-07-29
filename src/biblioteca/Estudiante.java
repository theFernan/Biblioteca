
package biblioteca;

public class Estudiante {
    private String carnet;
    private String nombre;
    private String carrera;

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
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
    
    
    
    public Estudiante(){
    }
    
    public Estudiante(String carnet, String nombre, String carrera){
        this.carnet=carnet;
        this.nombre=nombre;
        this.carrera=carrera;
    }
}
