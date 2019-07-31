package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

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
                        String pathAlumno="src/registros/estudiantes/"+carnet+".bin";
                        File estudiantes= new File (pathAlumno);
                        if(estudiantes.exists()){
                            String nuevoPrestamo="src/registros/prestamos/"+codigo+"_"+carnet+"_"+fecha+".bin";
                            File file2=new File(nuevoPrestamo);
                            Prestamos newPrestamo=new Prestamos(codigo, carnet, fecha, "Activo");
                            guardarArchivos(file2, newPrestamo);
                            cantidad=cantidad-1;
                            libro.setCantidad(String.valueOf(cantidad));
                            file.delete();
                            guardarArchivos(file, libro);
                        }else{
                            JOptionPane.showMessageDialog(null,"Error: El Estudiante No Esta Registrado");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Prestamo Invalido, el libro ya fue prestado a este estudiante");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Error: El Estudiante Puede Prestar 3 Libros Como Maximo");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Erro: El Libro no tiene unidades Disponibles");
            }           
        }else{
            JOptionPane.showMessageDialog(null,"Error: el libro no existe o no esta disponible");
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
    
    public int [] calculoDeTotal(String carnet, String codigo, String fechaInicio, String fechaFinal) throws ParseException{
        int precioPorDia=5;
        int precioPorMora=10;
        int diasConMora=0;
        int diasSinMora=3;
        int dias=0;
        int totales[]=new int [3];      
        String path="src/registros/prestamos/"+codigo+"_"+carnet+"_"+fechaInicio+".bin";
        File file = new File(path);
        if(file.exists()){
            dias=calcularFecha(fechaInicio, fechaFinal);
            if(dias>diasSinMora){
                diasConMora=dias-diasSinMora;
                totales[0]=diasSinMora*precioPorDia;
                totales[1]=diasConMora*precioPorMora;
                totales[2]=(diasSinMora*precioPorDia)+(diasConMora*precioPorMora);
            }else{
                totales[0]=dias*precioPorDia;
                totales[1]=0;
                totales[2]=totales[0];
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: El Registro De Ese Prestamo no Existe");
            totales[0]=0;
            totales[1]=0;
            totales[2]=0;
        }
        return totales;
    }
    
    public void devolucion(String carnet, String codigo, String fecha) throws IOException, ClassNotFoundException{
        String pathPrestamo="src/registros/prestamos/"+codigo+"_"+carnet+"_"+fecha+".bin";
        File file1= new File(pathPrestamo);
        Prestamos prestamo = new Prestamos();
        prestamo=(Prestamos) leerArchivo(file1);
        prestamo.setEstado("Inactivo");
        guardarArchivos(file1, prestamo);
        String pathLibro="src/registros/libros/"+codigo+".bin";
        File file2=new File(pathLibro);
        Libro libro = new Libro();
        libro=(Libro) leerArchivo(file2);
        int cantidad=Integer.valueOf(libro.getCantidad()+1);
        libro.setCantidad(String.valueOf(cantidad)); 
        guardarArchivos(file2, libro);
    }
    
    private int calcularFecha(String fechaInicio, String fechaFinal) throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 
	Date fechaInicial=dateFormat.parse(fechaInicio);
	Date fecha_Final=dateFormat.parse(fechaFinal);
        
	int diasEntre=(int) ((fecha_Final.getTime()-fechaInicial.getTime())/86400000);
        if(diasEntre<0){
            JOptionPane.showMessageDialog(null, "Error Las Fechas No Estan Bien");
            diasEntre=0;
        }
        return diasEntre;
    }
}
