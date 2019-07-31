
package biblioteca;

import biblioteca.Estudiante;
import biblioteca.Prestamos;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reportero {
    public void reporte1(JTable tabla1) throws IOException, ClassNotFoundException{
        ArrayList<Prestamos>  reporte = new ArrayList<Prestamos>();//arreglo para almacenar todos los datos de los ficheros .bin como objetos
        Date fecha = new Date();
        String fechaDePrestamo=(parcearFecha(sumarRestarDiasFecha(fecha, -3)));//le restamos 3 dias a la fecha del sistema para saber los libros que se prestaron hace 3 dias y se deben entregar hoy
        String path="src/registros/prestamos/";
        File dir = new File(path);
        String[] ficheros=dir.list();//nombre de todos los ficheros .bin en la carpeta
        if(ficheros==null){
        
        }else{
            for (int i=0; i<=ficheros.length-1; i++){//recorremos todos los ficheros del path
                if(ficheros[i].contains(fechaDePrestamo)){//si el fichero tiene la fecha en el nombre lo abrimos
                    File file = new File(path+ficheros[i]);////creamos un file
                    Prestamos prestamo=new Prestamos();
                    prestamo=(Prestamos) prestamo.leerArchivo(file);//leemos el archivo y lo agregamos a un objeto
                    if(prestamo.getEstado().equals("Activo")){//si el prestamo esta activo lo agregamos
                        reporte.add(prestamo);
                    }
                }
            }
            DefaultTableModel modelotabla=modelotabla = (DefaultTableModel) tabla1.getModel();//creamos un modelo de tabla y tomamos el modelo de la tabla del parametro como referencia
            Prestamos prestamo=new Prestamos();
            Estudiante estudiante = new Estudiante();
            for(int i=0;i<reporte.size();i++){//recorrer el arreglo de objetos guardados
                String pathEstudiante="src/registros/estudiantes/"+reporte.get(i).getCarnet()+".bin";
                File file = new File(pathEstudiante);//sacar el objeto del estudiante para saber el codigo de su carrera
                estudiante=(Estudiante) prestamo.leerArchivo(file);
                modelotabla.addRow(new Object[] {reporte.get(i).getCodigoLibro(), reporte.get(i).getCarnet(),
                    reporte.get(i).getFecha(), carrera(estudiante.getCarrera()), "15"});//agregar fila al modelo de la tabla
            }
            tabla1.setModel(modelotabla);//enviar el modelo a la tabla
            
        }
    }
    
    private String carrera(String numeroCarrera){//pasar de codigo de carrera a nombre de carrera
        String carrera="";
        if(numeroCarrera.equals("1")){
            carrera="Ingenieria";
        }else if(numeroCarrera.equals("2")){
            carrera="Medicina";
        }else if(numeroCarrera.equals("3")){
            carrera="Derecho";
        }else if(numeroCarrera.equals("4")){
            carrera="Arquitectura";
        }else if(numeroCarrera.equals("5")){
            carrera="Administracion";
        }
        return carrera;
    }
            
    
    private String parcearFecha(Date fecha){//parcear la fecha de sistema al formato deseado
        String fechaArray[]=fecha.toString().split(" ");
        if(fechaArray[1].equals("Jan")){
            fechaArray[1]="01";
        }
        if(fechaArray[1].equals("Feb")){
            fechaArray[1]="02";
        }
        if(fechaArray[1].equals("Mar")){
            fechaArray[1]="03";
        }
        if(fechaArray[1].equals("Apr")){
            fechaArray[1]="04";
        }
        if(fechaArray[1].equals("May")){
            fechaArray[1]="05";
        }
        if(fechaArray[1].equals("Jun")){
            fechaArray[1]="06";
        }
        if(fechaArray[1].equals("Jul")){
            fechaArray[1]="07";
        }
        if(fechaArray[1].equals("Aug")){
            fechaArray[1]="08";
        }
        if(fechaArray[1].equals("Sep")){
            fechaArray[1]="09";
        }
        if(fechaArray[1].equals("Oct")){
            fechaArray[1]="10";
        }
        if(fechaArray[1].equals("Nov")){
            fechaArray[1]="11";
        }
        if(fechaArray[1].equals("Dec")){
            fechaArray[1]="12";
        }
        if(fechaArray[2].equals("Jan")){
            fechaArray[2]="01";
        }
        String fechaParceada=fechaArray[5]+"-"+fechaArray[1]+"-"+fechaArray[2];
        return fechaParceada;
    }
    
    public Date sumarRestarDiasFecha(Date fecha, int dias){//sumar o restar dias a fechas
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); // Configuramos la fecha que se recibe	
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }
}
