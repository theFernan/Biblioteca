
package biblioteca;

import backend.PaginaPrincipal;
import backend.PaginaPrincipal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class Analisador extends Thread{
    private String texto;
    
    public void setTexto(String texto){
        this.texto=texto;
    }
    
    @Override
    
    public void run(){
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
                                File file = new File("src/registros/"+i+".bin");
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
            break;
            case "":
                break;
                
        }
        
        
        return j;
    }
    
    private void guardarArchivos(File fichero, Object obj) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        oos.writeObject(obj);
    }
    
    private int pasarLinea(int j){
        int k=j;
        k=k+1;
        return k;
    }
    
    private void esperarXsegundos() {
	try {
            Thread.sleep(100);
	} catch (InterruptedException ex) {
            System.out.println("s");
	}
    }
    
}
