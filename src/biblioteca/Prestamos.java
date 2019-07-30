package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prestamos implements Serializable{
    
    private String codigoLibro;
    private String carnet;
    private String fecha;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    public Prestamos(){
    }
    
    public Prestamos(String codigoLibro, String carnet, String fecha, String estado){
        this.codigoLibro=codigoLibro;
        this.fecha=fecha;
        this.carnet=carnet;
        this.estado=estado;
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
    
    public void prestar(String carnet, String codigo, String fecha) throws IOException, ClassNotFoundException{
        int cantidadDePrestamos=0;
        boolean activo=false;
        String path="src/registros/prestamos/";
        File dir = new File(path);
        String[] ficheros=dir.list();
        if(ficheros==null){
        
        }else{
            for (int i=0; i<=ficheros.length-1; i++){
                if(ficheros[i].contains(carnet)){
                    File file = new File(path+ficheros[i]);
                    Prestamos prestamo=(Prestamos) leerArchivo(file);
                    if(prestamo.getEstado().equals("Activo")){
                        cantidadDePrestamos=cantidadDePrestamos+1;
                    }
                }
            } 
            for (int i=0; i<=ficheros.length-1; i++){
                String codigoCarnet=codigo+"_"+carnet;
                if(ficheros[i].contains(codigoCarnet)){
                    File file = new File(path+ficheros[i]);
                    Prestamos prestamo=(Prestamos) leerArchivo(file);
                    if(prestamo.getEstado().equals("Activo")){
                        activo=true;
                    }
                }
            }
        }
        String directorio="src/registros/libros/"+codigo+".bin";
        File file=new File(directorio);
        if(file.exists()){
            Libro libro=(Libro) leerArchivo(file);
            int cantidad=Integer.parseInt(libro.getCantidad());
            if(cantidad>0){
                if(cantidadDePrestamos<3){
                    if(activo==false){
                        String nuevoPrestamo="src/registros/prestamos/"+codigo+"_"+carnet+"_"+fecha+".bin";
                        File file2=new File(nuevoPrestamo);
                        Prestamos newPrestamo=new Prestamos(codigo, carnet, fecha, "Activo");
                        guardarArchivos(file2, newPrestamo);
                        cantidad=cantidad-1;
                        libro.setCantidad(String.valueOf(cantidad));
                        file.delete();
                        guardarArchivos(file, libro);
                    }else{
                        System.out.println("Prestamo Invalido, el libro ya fue prestado a este estudiante");
                    }
                }else{
                    System.out.println("Prestamo Invalido");
                }
            }else{
                System.out.println("Erro: El Libro no tiene unidades Disponibles");
            }           
        }else{
            System.out.println("Error: el libro no existe o no esta disponible");
        }        
    }
    
    private void guardarArchivos(File fichero, Object obj) throws IOException{
        if(fichero.exists()){
            fichero.delete();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(obj);
        }else{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(obj);            
        }
    }
    
    public Object leerArchivo(File fichero) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        Object aux = ois.readObject();
        return aux;        
    }
    
    public void devolucion(){
        
    }
}
