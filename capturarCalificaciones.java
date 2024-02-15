package verificador1;
import java.awt.Container;
 import java.awt.BorderLayout;
 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
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
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.io.File;
 //PAQUETES

public class capturarCalificaciones extends JFrame implements validar {
    //atributos
    private JTextField cali1,cali2,cali3,cali4,cali5,cali6;
    private JLabel titulo,semestre,asignatura,ca1,ca2,ca3,ca4,ca5,ca6;
    private JButton aceptar,cancelar;
    private JPanel norte,central,sur;
    private JComboBox materia,esemestre;
    
    //constructor
    public capturarCalificaciones(){
        Eventos manejador=new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        central=new JPanel(new GridLayout(3,2));
        norte=new JPanel(new GridLayout(1,1));
        titulo=new JLabel("Captura de Calificaciones de la materia seleccionada",SwingConstants.CENTER);
        ca1=new JLabel("Calificacion U1",SwingConstants.CENTER);
        cali1=new JTextField(30);
        ca2=new JLabel("Calificacion U2",SwingConstants.CENTER);
        cali2=new JTextField(30);
        ca3=new JLabel("Calificacion U3",SwingConstants.CENTER);
        cali3=new JTextField(30);
        ca4=new JLabel("Calificacion U4",SwingConstants.CENTER);
        cali4=new JTextField(30);
        ca5=new JLabel("Calificacion U5",SwingConstants.CENTER);
        cali5=new JTextField(30);
        ca6=new JLabel("Calificacion U6",SwingConstants.CENTER);
        cali6=new JTextField(30);
        sur=new JPanel(new GridLayout(1,1));
        aceptar=new JButton("Aceptar");
        aceptar.addActionListener(manejador);
        cancelar=new JButton("Cancelar");
        cancelar.addActionListener(manejador);
        
        
        norte.add(titulo);
        central.add(ca1);
        central.add(cali1);
        central.add(ca2);
        central.add(cali2);
        central.add(ca3);
        central.add(cali3);
        central.add(ca4);
        central.add(cali4);
        central.add(ca5);
        central.add(cali5);
        central.add(ca6);
        central.add(cali6);
        sur.add(aceptar);
        sur.add(cancelar);
        
        
        contenedor.add(norte,BorderLayout.NORTH);
        contenedor.add(central,BorderLayout.CENTER);
        contenedor.add(sur,BorderLayout.SOUTH);
        titulo.setFont(new Font("Garamond",Font.PLAIN,18));
        titulo.setForeground(Color.ORANGE);
        norte.setBackground(Color.DARK_GRAY);
        
        
        setSize(500,400);//pixeles esta es la mama
        setVisible(true);//se define con valores booleanos
        //termina constructor
    }  //metodo borrar
       public void borrar(){
           cali1.setText("");
           cali2.setText("");
           cali3.setText("");
           cali4.setText("");
           cali5.setText("");
           cali6.setText("");
           
       }
       
       
       public void probar(){
        try{   
        String ca1 = cali1.getText();
        int cal1 = Integer.parseInt(ca1);
        String ca2 = cali2.getText();
        int cal2 = Integer.parseInt(ca2);      
        String ca3 = cali3.getText();
        int cal3 = Integer.parseInt(ca3);
        String ca4 = cali4.getText();
        int cal4 = Integer.parseInt(ca4);
        String ca5 = cali5.getText();
        int cal5 = Integer.parseInt(ca5);
        String ca6 = cali6.getText();
        int cal6 = Integer.parseInt(ca6);
        
        
            
        
        
        if((cal1<69)){
            cali1.setText("N/A");
        }
        if((cal2<69)){
            cali2.setText("N/A");
        }
        if((cal3<69)){
            cali3.setText("N/A");
        }
        if((cal4<69)){
            cali4.setText("N/A");
        }
        if((cal5<69)){
            cali5.setText("N/A");
        }
        if((cal6<69)){
            cali6.setText("N/A");
        }
        if((cal1>100)||(cal2>100)||(cal3>100)||(cal4>100)||(cal5>100)||(cal6>100)){
            //JOptionPane.showMessageDialog(null,"Valores ingresados mayor que 100");
            throw new IllegalArgumentException("Valores ingresados mayor que 100");
        }
        if((cal1<0)||(cal2<0)||(cal3<0)||(cal4<0)||(cal5<0)||(cal6<0)){
            throw new IllegalArgumentException("Valores Ingresados son negativos");
        }       
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato ingresaste alguna letra y no un numero");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,"he"+ e.getMessage());
        }
        
        
        
       }
       public void check(){
           String not1=cali1.getText();
           String not2=cali2.getText();
           String not3=cali3.getText();
           String not4=cali4.getText();
           String not5=cali5.getText();
           String not6=cali6.getText();
           if(not1.isEmpty()||not2.isEmpty()||not3.isEmpty()||not4.isEmpty()||not5.isEmpty()||not5.isEmpty()){
               JOptionPane.showMessageDialog(null,"Faltan valores por ingresar");
               throw new IllegalStateException("faltan valores por ingresar");
           }
                  String archivoRuta = "C:\\Users\\jg170\\OneDrive\\Documentos\\NetBeansProjects\\verificador1\\src\\verificador1/baseDatos.txt";
                   try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoRuta, true))) {
                      File archivo = new File(archivoRuta);
                        if (!archivo.exists()) {
                          archivo.createNewFile();
                        }
                      escritor.write("\t" + not1 + "\t" + not2 + "\t" + not3 + "\t" + not4 + "\t" + not5 + "\t" + not6 + "\t");  
                      escritor.newLine();  
                      System.out.println("Datos guardados exitosamente en el archivo.");
                    } catch (IOException e) {
                          System.out.println("Ocurrió un error al guardar los datos en el archivo.");
                          
                        } 
       }
       
           
       
       public static void main(String args[]){
           capturarCalificaciones ventana=new capturarCalificaciones();
           ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
       class Eventos implements ActionListener{
           @Override
           public void actionPerformed(ActionEvent ev){
               if(ev.getSource()==cancelar){
                   borrar();
               }
               if(ev.getSource()==aceptar){
                   check();
                   probar();
                   JOptionPane.showMessageDialog(null,"Valores guardados");
                   System.exit(0);
               }
           }
       }
      
}
