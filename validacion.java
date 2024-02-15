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
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class validacion extends JFrame{
    
     private JTextField periodo;
    private JLabel text,ciclo,semestre,asignatura;
    private JButton aceptar,cancelar;
    private JPanel central;
    private JPanel inicio;
    private JPanel ultimo;
    private JComboBox <String> materia,semestr;
    int periodoIng;
    public validacion(){
        Eventos manejador= new  Eventos();
        
        Container contenedor=getContentPane();
        contenedor.setLayout(new BorderLayout()); 
        
        central = new JPanel(new GridLayout(3,2));
        inicio = new JPanel (new GridLayout(1,1));
        ultimo = new JPanel (new GridLayout(1,1));
        inicio.setBackground(Color.blue);
        periodo= new JTextField(10);
        ciclo=new JLabel("PERIODO");
        
        
        semestre=new JLabel ("SEMESTRE");
        semestr =new JComboBox();
        semestr.addItem("");
        semestr.addItem("Semestre 1");
        semestr.addItem("Semestre 2");
        semestr.addItem("Semestre 3");
        semestr.addItem("Semestre 4"); 
        semestr.addItem("Semestre 5");        
        semestr.addItem("Semestre 6");        
        semestr.addItem("Semestre 7");        
        semestr.addItem("Semestre 8");  
         semestr.setEnabled(false);
        
        asignatura=new JLabel("MATERIA");
        materia=new JComboBox();
        materia.addItem("");
        materia.addItem("calculo");
        materia.addItem("IA");
        materia.addItem("Base de datos");
        materia.addItem("poo"); 
        materia.addItem("CALCULO VECTORIAL");        
        materia.addItem("IA");        
        materia.addItem("MATRERIA");        
        materia.addItem("TITULACION");   
        materia.setEnabled(false);
        
        text= new JLabel ("WELCOME",SwingConstants.CENTER);
        cancelar= new JButton ("cancelar");
        
        cancelar.addActionListener(manejador);
        semestr.addActionListener(manejador);
        
        
        aceptar =new JButton ("ACEPTAR");
        aceptar.addActionListener(manejador);
        
        
        inicio.add(text);
        central.add(ciclo);;
         central.add(periodo);       
         central.add(semestre);        
         central.add(semestr);       
          central.add(asignatura);
          central.add(materia);
          ultimo.add(aceptar);
          ultimo.add(cancelar);
          
          contenedor.add(central,BorderLayout.CENTER);
        contenedor.add(inicio,BorderLayout.NORTH);
        contenedor.add(ultimo,BorderLayout.SOUTH);
        
        periodo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                semestr.setEnabled(true);
               materia.setEnabled(true);
                
            }
            
        });
        
        
         setSize(300,300);
         
         
        setVisible(true);
        
        
             
    }
    public void borrar(){
        periodo.setText("");
        
       }
    
       
    
    public void call(){
        capturarCalificaciones terceraVe=new capturarCalificaciones();
        terceraVe.setVisible(true);
        this.setVisible(false);
    }
     public static void main(String[]args){
    validacion ventana = new validacion();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
     class Eventos implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == cancelar) {
            borrar();
        }
        if (ev.getSource() == aceptar) {
            if (!periodo.getText().equals("")) {
                call();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un periodo válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
      if (ev.getSource() == aceptar) {
            if(semestr.getSelectedIndex()==-1||materia.getSelectedIndex ()==-1){
                      JOptionPane.showMessageDialog(null, "Por favor, ingrese un Semestre", "Error", JOptionPane.ERROR_MESSAGE);
               
                      
                      
            }else {
                
             }   
            }
            
        
        int selectedIndex = semestr.getSelectedIndex();
        materia.setSelectedIndex(selectedIndex);
        
        
    }
}

}
