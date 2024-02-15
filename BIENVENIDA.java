package verificador1;
import java.awt.Container;
 import java.awt.BorderLayout;
 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;//accion
 import java.awt.event.ActionListener;//detecta7
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JButton;
 import javax.swing.JLabel;
 import javax.swing.JTextField;
 import javax.swing.JPasswordField;
 import java.awt.Color;
 import java.awt.Font;
 import javax.swing.JOptionPane;
 import javax.swing.SwingConstants;
 import javax.swing.JComboBox;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 
 //PAQUTES

public class BIENVENIDA extends JFrame implements validar {
    //atributos
   private JTextField entradaperido,entradaSemestre,entradaMateria;
   private JLabel perido,semestre,materia,titulo;
   private JButton aceptar,cancelar,siguiente;
   private JPanel norte,central,sur;
   private JComboBox pestanas,pestanasmate;
   //FIN ATRIBUTOS
   //constructor
   public BIENVENIDA(){
       Eventos manejador=new Eventos();
       Container contenedor=getContentPane();
       contenedor.setLayout(new BorderLayout());
     
        
       //norte
       norte=new JPanel(new GridLayout(1,1));
       norte.setBackground(Color.DARK_GRAY);
       titulo= new JLabel("Bienvenid@",SwingConstants.CENTER);
       //central
       central=new JPanel(new GridLayout(3,2));
       entradaperido=new JTextField(10);
       perido=new JLabel("Periodo"); 
       semestre=new JLabel("Semestre");
       String[]elemeN1={"1 SEMESTRE","2 SEMESTRE","3 SEMESTRE","4 SEMESTRE","5 SEMESTRE","6 SEMESTRE","7 SEMESTRE","8 SEMESTRE"};
       pestanas=new JComboBox<>(elemeN1);
       pestanas.setVisible(false);
       materia=new JLabel("Materia");
       String[] elemeN2 ={""};
       pestanasmate=new JComboBox<>(elemeN2);
       pestanasmate.setVisible(false);
       
       
       
       //sur
       sur=new JPanel(new GridLayout(1,1));
       siguiente=new JButton("Desplegar");
       siguiente.addActionListener(manejador);
       aceptar=new JButton("Aceptar");
       aceptar.addActionListener(manejador);
       cancelar=new JButton("Cancelar");
       cancelar.addActionListener(manejador);
       
       norte.add(titulo);
       central.add(perido);
       central.add(entradaperido);
       central.add(semestre);
       central.add(pestanas);
       central.add(materia);
       central.add(pestanasmate);
       sur.add(siguiente);
       sur.add(aceptar);
       sur.add(cancelar);
       
       
       contenedor.add(central,BorderLayout.CENTER);
       contenedor.add(norte,BorderLayout.NORTH);
       contenedor.add(sur,BorderLayout.SOUTH);
       setSize(400,300);
       setVisible(true);
       titulo.setForeground(Color.ORANGE);
       titulo.setFont(new Font("GARAMOND",Font.PLAIN,24));
      
       {   pestanas.addActionListener(ACE  -> {
           String opcionSeleccionada = (String) pestanas.getSelectedItem();
        if (opcionSeleccionada.equals("1 SEMESTRE")) {
            String[] subopciones1 = {"Fundamentos de programacion","Matematicas Discretas"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones1) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("2 SEMESTRE")) {
            String[] subopciones2 = {"Programacion Orientada a Objetos","Probabilidad y Estadistica"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("3 SEMESTRE")) {
            String[] subopciones2 = {"Estructura de Datos","Sistemas operativos"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("4 SEMESTRE")) {
            String[] subopciones2 = {"Fundamentos de base de datos","Arquitectura de computadoras"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("5 SEMESTRE")) {
            String[] subopciones2 = {"Fundamentos de Ingenieria de Sofware","Redes de Computadoras"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("6 SEMESTRE")) {
            String[] subopciones2 = {"Programacion web","Ingenieria de Sofware"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else if (opcionSeleccionada.equals("7 SEMESTRE")) {
            String[] subopciones2 = {"Programacion Logica Funcional","Internet de las cosas"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones2) {
                pestanasmate.addItem(subopcion);
            }
        } else {
            String[] subopciones3 = {"Inteligencia artificial","Ciberseguridad"};
            pestanasmate.removeAllItems();
            for (String subopcion : subopciones3) {
                pestanasmate.addItem(subopcion);
            }
        }
        pestanasmate.addActionListener(o -> {
          String seme= (String) pestanas.getSelectedItem();
          String archivoRutaa = "C:\\Users\\jg170\\OneDrive\\Documentos\\NetBeansProjects\\verificador1\\src\\verificador1/baseDatos.txt";  
          String mate= (String) pestanasmate.getSelectedItem();
          String archivoRuta = "C:\\Users\\jg170\\OneDrive\\Documentos\\NetBeansProjects\\verificador1\\src\\verificador1/baseDatos.txt";
          try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoRuta, true))) {
              File archivo = new File(archivoRuta);
               if (!archivo.exists()) {
                 archivo.createNewFile();
                 archivo.createNewFile();
                }
                  escritor.write(seme + "\t");
                  escritor.write(mate + "\t"  );  // Escribir los campos separados por tabulaciones
        
                    System.out.println("Datos guardados exitosamente en el archivo.");
            } catch (IOException l) {
                     System.out.println("Ocurrió un error al guardar los datos en el archivo.");
                        
                }
       });
    });
}



       
       
       
   }//termina constructor
   
   //inicio metodos
   
   public void borrar(){
       entradaperido.setText("");
       
       
   }
   public void siguiente(){
      if(entradaperido.getText().isEmpty()){
          JOptionPane.showMessageDialog(null,"NO ingresaste periodo escolar,No puedes introducir tus calificaciones");
      }else{
      capturarCalificaciones terceraVentana=new capturarCalificaciones();
      terceraVentana.setVisible(true);
      this.setVisible(false);
      }
   }
   @Override
   public void probar(){
       try{
       if(entradaperido.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Ingresa perido escolar");
           throw new NullPointerException("Falta ingresar periodo");
       }else{
         siguiente.setVisible(false);
         pestanas.setVisible(true);
         pestanasmate.setVisible(true);
        } 
       }catch(NullPointerException q){
         JOptionPane.showMessageDialog(null,"Este campo no puede ser vacio");    
       } 
   }
   @Override
   public void check (){
    
   }
   
  
    
   public static void main(String args[]){
       BIENVENIDA ventana=new BIENVENIDA();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//CIERRA METODO
   
   class Eventos implements ActionListener{
       @Override//
       public void actionPerformed(ActionEvent ev){
           if(ev.getSource()==siguiente){
            probar();   
           }
           
               
           if(ev.getSource()==aceptar){
               
               siguiente();
           }
           if(ev.getSource()==cancelar){
               borrar();//metodo borrar
           }
           
           //if pestanas.setVisible(true);
           
           
       }
       
   }
           
           
    
}
