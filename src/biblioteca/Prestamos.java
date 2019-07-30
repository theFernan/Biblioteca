package biblioteca;

import java.io.Serializable;

public class Prestamos implements Serializable{
    
    private String codigoLibro;
    private String carnet;
    private String fecha;

    
    
    public Prestamos(){
    }
    
    public Prestamos(String codigoLibro, String carnet, String fecha){
        this.codigoLibro=codigoLibro;
        this.fecha=fecha;
        this.carnet=carnet;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
