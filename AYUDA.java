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

public class AYUDA extends JFrame {
    private JLabel datos,instructivo,titulo,instrucciones,version;
    private JButton cancelar;
    private JPanel norte,central,sur;
    
    public AYUDA(){
        Eventos manejador=new Eventos();
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        norte=new JPanel(new GridLayout(1,1));
        titulo=new JLabel("Sistema de Ayuda",SwingConstants.CENTER);
        central=new JPanel(new GridLayout(2,2));
        datos=new JLabel("DATOS DEL SISTEMA");
        version=new JLabel("<html>Version: 1.0<br/>"
                + "<br/>Autor:Jesus Alberto Gonzalez Sanchez. <br/>"
                + "<br/>Fecha de Lanzamiento:2023");
        instructivo=new JLabel("INSTRUCCIONES");
        instrucciones=new JLabel(
                "<html><br/>APARTADO DE AYUDA<br/>"
                + "<html/>1.Introduce tu Uuario y Contrasena."
                + "<html/><br/>ACEPTAR.Para Verififcar Usuario/Contrasena."
                + "<br/>*Solo tienes 3 intentos en poner tu usuario y contrasena correctos.No puedes introducir campos Vacios.<br/>"
                + "<html/>*Si acomulastes tu 3 oportunidades te este te sacara.<br/>"
                + "<html/>2.Accederas a ventana de Bienevenida"+"<br/>*Ingresa tu ciclo y selecciona tu Semestre y materia <br/>. "
                + "<html/>3.Ventana de Calificaciones."
                + "<br/>*Introduce la calificaion por cada unidad. <br/>"
                + "<br/>*Boton CANCELAR borra calificaciones capturadas."
                + "<br/>*Boton ACEPTAR te sacara en la ultima ventana. ");
        sur=new JPanel(new GridLayout(1,1));
        cancelar=new JButton("ATRAS");
        cancelar.addActionListener(manejador);
        
        norte.add(titulo);
        central.add(datos);
        datos.setFont(new Font("Georgia",Font.PLAIN,20));
        datos.setForeground(Color.red);
        central.add(version);
        version.setFont(new Font("garamond",Font.PLAIN,14));
        version.setForeground(Color.black);
        central.add(instructivo);
        instructivo.setFont(new Font("Georgia",Font.PLAIN,20));
        instructivo.setForeground(Color.red);
        central.add(instrucciones);
        instrucciones.setFont(new Font("garamond",Font.PLAIN,14));
        instrucciones.setForeground(Color.black);
        sur.add(cancelar);
        
        
        contenedor.add(norte,BorderLayout.NORTH);
        titulo.setFont(new Font("GARAMOND",Font.PLAIN,18));
        titulo.setForeground(Color.orange);
        cancelar.setBackground(Color.DARK_GRAY);
        cancelar.setForeground(Color.orange);
        norte.setBackground(Color.DARK_GRAY);
        contenedor.add(central,BorderLayout.CENTER);
        contenedor.add(sur,BorderLayout.SOUTH);
        
        
        setSize(300,300);
        setVisible(true);
        
    }
    public static void main (String [] args){
        AYUDA ventana=new AYUDA();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void cancelar(){
        Verificador1 primeraventana=new Verificador1();
        primeraventana.setVisible(true);
        this.setVisible(false);
    }
    
    class Eventos implements ActionListener{
        
        public void actionPerformend(ActionEvent ev){
            if(ev.getSource()==cancelar){
                cancelar();
            }
             
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==cancelar);
            cancelar();
        }
    }
}

