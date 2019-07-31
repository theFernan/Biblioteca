
package biblioteca;

import backend.PaginaPrincipal;
import backend.PaginaPrincipal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Analisador extends Thread{
    private String texto;
    
    public void setTexto(String texto){
        this.texto=texto;
    }
    
    @Override
    
    public void run(){
        try{
            PaginaPrincipal analisis = new PaginaPrincipal();
            String lineas[] = texto.split("\n");

            for(int j=0; j <= lineas.length-1; j++){ 
                esperarXsegundos();
                analisis.setTexto(lineas[j]);
                try {
                    analisis(lineas[j], j, lineas);
                } catch (IOException ex) {
                    Logger.getLogger(Analisador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Introduzca antes el texto de entrada para leer");
        }
    }
    
    private int analisis(String linea, int i, String [] lineas) throws IOException{
        int j=i;
        PaginaPrincipal pp = new PaginaPrincipal();
        switch(linea){
            case "LIBRO":
                j=pasarLinea(j);
                String[] titulo=lineas[j].split(":");
                if(titulo[0].equals("TITULO")){
                    j=pasarLinea(j);
                    String autor[]=lineas[j].split(":");
                    if(autor[0].equals("AUTOR")){
                        j=pasarLinea(j);
                        String codigo[]=lineas[j].split(":");
                        if(codigo[0].equals("CODIGO")){
                            j=pasarLinea(j);
                            String cantidad[]=lineas[j].split(":");
                            if(cantidad[0].equals("CANTIDAD")){
                                j=pasarLinea(j);
                                Libro libro = new Libro(titulo[1], autor[1], codigo[1], cantidad[1]);
                                File file = new File("src/registros/libros/"+codigo[1]+".bin");
                                guardarArchivos(file, libro);
                                pp.setError("Registro Libro Almacenado");
                            }else{
                                pp.setError("Registro Libro: Error en formato");
                            }
                        }else{
                            pp.setError("Registro Libro: Error en formato");
                        }
                    }else{
                        pp.setError("Registro Libro: Error en formato");
                    }
                }else{
                    pp.setError("Registro Libro: Error en formato");
                }
                pp.setError("***************************************");
            break;
            case "ESTUDIANTE":
                String error="Registro Estudiante: Error en formato";
                j=pasarLinea(j);
                String carnet[]=lineas[j].split(":");
                if(carnet[0].equals("CARNET")){
                    j=pasarLinea(j);
                    String nombre []=lineas[j].split(":");
                    if(nombre[0].equals("NOMBRE")){
                        j=pasarLinea(j);
                        String carrera[]=lineas[j].split(":");
                        if(carrera[0].equals("CARRERA")){
                            j=pasarLinea(j);
                            Estudiante estudiante = new Estudiante(carnet[1], nombre[1], carrera[1]);
                            File file = new File("src/registros/estudiantes/"+carnet[1]+".bin");
                            if(file.exists()){
                                pp.setError("Error: Estudiante Ya Almacenado");
                            }else{
                                guardarArchivos(file, estudiante);
                                pp.setError("Registro Estudiante: Almacenado");
                            }
                        }else{
                            pp.setError(error);
                        }
                    }else{
                        pp.setError(error);
                    }
                }else{
                    pp.setError(error);
                }
                pp.setError("***************************************");
                break;
            case "PRESTAMO":
                String errorPrestamo="Registro Prestamo: Error en formato";
                j=pasarLinea(j);
                String codigo[]=lineas[j].split(":");
                if(codigo[0].equals("CODIGOLIBRO")){
                    j=pasarLinea(j);
                    String carne []=lineas[j].split(":");
                    if(carne[0].equals("CARNET")){
                        j=pasarLinea(j);
                        String fecha[]=lineas[j].split(":");
                        if(fecha[0].equals("FECHA")){
                            j=pasarLinea(j);
                            Prestamos prestamos = new Prestamos(codigo[1], carne[1], fecha[1], "Inactivo");
                            File file = new File("src/registros/prestamos/"+codigo[1]+"_"+carne[1]+"_"+fecha[1]+".bin");
                            if(file.exists()){
                                pp.setError("Registro Prestamo: Error No se puede prestar el \n mismo libro a "
                                        + "la misma persona en el mismo dia");
                            }else{
                                guardarArchivos(file, prestamos);
                                pp.setError("Registro Prestamo: Almacenado");
                            }                            
                        }else{
                            pp.setError(errorPrestamo);
                        }
                    }else{
                        pp.setError(errorPrestamo);
                    }
                }else{
                    pp.setError(errorPrestamo);
                }
                pp.setError("***************************************");
                break;
                
            case "":
                break;                
        }      
        
        return j;
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
    
    private int pasarLinea(int j){
        int k=j;
        k=k+1;
        return k;
    }
    
    private void esperarXsegundos() {
	try {
            Thread.sleep(1000);
	} catch (InterruptedException ex) {
            System.out.println("s");
	}
    }
    
}