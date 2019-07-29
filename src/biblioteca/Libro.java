package biblioteca;

import java.io.Serializable;


public class Libro implements Serializable{
    
    private String titulo;
    private String autor;
    private String codigo;
    private String cantidad;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public Libro(){
        
    }
    
    public Libro(String titulo, String autor, String codigo, String cantidad){
        this.titulo=titulo;
        this.autor=autor;
        this.codigo=codigo;
        this.cantidad=cantidad;
    }
    
}
