package verificador1 ;

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
 import java.awt.Dimension;
 import java.awt.Font;
 import javax.swing.JOptionPane;
 import javax.swing.SwingConstants;
 import java.io.BufferedWriter;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.io.File;

 //PAQUTES


     public class Verificador1 extends JFrame{
          //atributos
          private JTextField entrada,entradaP;
          private JLabel entradaUsua,entradaPas,titulo;
          private JButton cancelar,aceptar,botonAyuda;
          private JPanel central,norte,sur;
          String usuario="Jesus08";
          String password="JesusAKA";
          String usab="";
          String pasb="";
          int contador=0;
          int contadorV=0;
          int limite=3;
          int limiteV=3;
          //contructor
          public Verificador1(){
             Eventos manejador=new Eventos ();
             Container contenedor = getContentPane();
             contenedor.setLayout(new BorderLayout());
             central = new JPanel(new GridLayout(4,2));
             entrada = new JTextField(10);
             entradaP = new JPasswordField(10);
             norte= new JPanel(new GridLayout(1,2));
             titulo= new JLabel("AUTENTICADOR",SwingConstants.CENTER);
           
             botonAyuda=new JButton("?");
             botonAyuda.addActionListener(manejador);
             entradaUsua = new JLabel("Ingrese Usuario",SwingConstants.CENTER);
             entradaPas = new JLabel("Ingrese Password",SwingConstants.CENTER);
             sur=new JPanel(new GridLayout(1,1));
             cancelar=new JButton("Cancelar");
             cancelar.addActionListener(manejador);
             aceptar=new JButton("Aceptar");
             aceptar.addActionListener(manejador);
             
             
             
             
             
             norte.add(titulo); 
             norte.add(botonAyuda);
             central.add(entradaUsua);
             central.add(entrada);
             entradaUsua.setFont(new Font("Georgia",Font.PLAIN,14));
             entradaUsua.setForeground(Color.red);
             central.add(entradaPas);
             central.add(entradaP);
             entradaPas.setFont(new Font("Georgia",Font.PLAIN,14));
             entradaPas.setForeground(Color.red);
             sur.add(aceptar);
             sur.add(cancelar);
             
             
             
             
             contenedor.add(norte,BorderLayout.NORTH);
             titulo.setFont(new Font("GARAMOND",Font.PLAIN,18));
             titulo.setForeground(Color.orange);
             botonAyuda.setBackground(Color.DARK_GRAY);
             botonAyuda.setForeground(Color.orange);
             norte.setBackground(Color.DARK_GRAY);
             contenedor.add(central,BorderLayout.CENTER);
             contenedor.add(sur,BorderLayout.SOUTH); 
              
             setSize(300,300);//pixeles
             setVisible(true);//se define con valor booleano
           }//termina el contructor
           
           public static void main (String []args){
               Verificador1 ventana = new Verificador1();
               ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           }
           
           public void cancelar(){
               entrada.setText("");
               entradaP.setText("");
           }
           
           
           public void verificar(){
               if(usuario.equals(entrada.getText()) && password.equals(entradaP.getText())){
             
                       BIENVENIDA segundaVentana=new BIENVENIDA();
                       segundaVentana.setVisible(true);
                       this.setVisible(false);
                       String nameAlumno=JOptionPane.showInputDialog(null,"Ingrese su nombre");
                       String archivoRuta="C:\\Users\\jg170\\OneDrive\\Documentos\\NetBeansProjects\\verificador1\\src\\verificador1/baseDatos.txt";
                       try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoRuta, true))) {
                         File archivo = new File(archivoRuta);
                          if (!archivo.exists()) {
                                   archivo.createNewFile();
                           }
                              escritor.write("__________________________________________________________________________________________________________________" );
                              escritor.write("\n"+"NOMBRE" + "\t" + "SEMESTRE" + "\t" + "MATERIA" + " \t " + " \t " + " \t " + " \t " + " \t " + " Unidades 1-6 " );
                              escritor.write("__________________________________________________________________________________________________________________" );
                              escritor.write("\n"+nameAlumno + "\t" );  // Escribir los campos separados por tabulaciones
        
                              System.out.println("Datos guardados exitosamente en el archivo.");
                        } catch (IOException ace) {
                                  System.out.println("Ocurrió un error al guardar los datos en el archivo.");
                                   
                        }
                }else{
                  if(entrada.getText().isEmpty()&&entradaP.getText().isEmpty()){
                       JOptionPane.showMessageDialog(null,"Empty Username or Password ");
                       contadorV++;
                       
                   }else
                           
                   JOptionPane.showMessageDialog(null,"Contrasena / Usuario incorrecto");
                   contador++;
                   entrada.setText("");
                   entradaP.setText("");
               }
               if(contador==limite){
                   System.exit(0);
               }
               if(contadorV==limiteV){
                   System.exit(0);
               }
                
           }
           public void ayuda(){
               AYUDA cuartaventana=new AYUDA();
               cuartaventana.setVisible(true);
               this.setVisible(false);
           }
           
              
          

          class Eventos implements ActionListener{
          @Override
          public void actionPerformed(ActionEvent ev){
           if(ev.getSource()==botonAyuda){
               ayuda();
           }   
           if(ev.getSource()==cancelar){
            cancelar();
           }
           if(ev.getSource()==aceptar){
            verificar();
            
            
           }  
           
           
    }
}
     }