/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.forms;

import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author David González Candelas - davidgonzalezcandelas@gmail.com
 */
// Clase que herede del contener JFrame
public class GUI extends JFrame {

    // Establecemos las constantes que representan el nombre de las propiedades del fichero properties
    public static final String PRP_LOOK_AND_FEEL = "look_and_feel";
    public static final String PRP_FAVICON = "favicon";

    // Establecemos unas constantes que establecen su valor por defecto, así que en caso de que no existan
    // en el fichero properties estas serán las opciones por defecto
    public static final String DEF_LOOK_AND_FEEL = UtilesSwing.LNF_WINDOWS;
    public static final String DEF_FAVICON = "img/favicon.png";

    // Instanciamos un objeto Properties que contendrá las propiedades que le pasaremos con el constructor de GUI(gracias al método initBefore())
    // es decir, las comunicamos con las properties del constructor GUI
    private Properties prp;

    // Clase que recibe las propiedades cargadas desde el Main
    public GUI(Properties prp) {

        // Inicializa antes de la construcción, pasándole las propiedades del método(que serán las propiedades de la clase), si es necesario para el programa lo ejecutaremos
        initBefore(prp);

        // Es el encargado de instanciar y parametrizar el interfaz grafico
        initComponents();

        // Inicializa después de la construcción, si es necesario para el programa lo ejecutaremos
        initAfter();
    }

    private void initComponents() {
        
        // Instanciamos un objeto de JPanel, con la notación húngara inversa "pnl" para identificar el componente
        // que representa el área cliente de la ventana(lo que hay dentro de la ventana)
        JPanel pnlPpal = new JPanel();
        
        // Llamamos al método heredado para decirle que el área cliente es el panel, sería lo mismo que poner this.setContentPane(pnlPpal);
        setContentPane(pnlPpal);
        
        // Establecemos el título de la ventana
        setTitle("Swing Manual #00");
        
        // Establecemos que la ventana no se pueda redimensionar
        setResizable(false);
        
        // Establecemos el tamaño de la ventana
        setSize(600,400);
        
        // Establece la posición de la ventana relativa al componente que hemos establecido, como el componente es null, la ventana se coloca en el centro de la pantalla
        setLocationRelativeTo(null);
        
        // Definimos la función de la "x" es la ventana, en este caso cierra el hilo de ejecución Main, es decir
        // cuando se cierra la ventana el programa mierte
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método que servirá para ejecutar instrucciones antes de lanzar el programa, lo que lancemos deopenderá de las necesidades del programa.
    // Por ejemplo, detectar que hay un programa igual en ejecución y al intentar lanzar otro igual. este muera.
    private void initBefore(Properties prp) {

        // Establecemos que estas propiedades, sean las propiedades de la clase. A partir de este momento las propiedades estarán disponibles, comunicamos el campo de la clase
        this.prp = prp;
        
        // Utilizamos el metodo establecerLnf para cargar el favicon establecido en el archivo propeties,
        // si no hay ninguno establecido, cogerá el Lnf por defecto
        UtilesSwing.establecerLnF(prp.getProperty(PRP_LOOK_AND_FEEL, DEF_LOOK_AND_FEEL));
        
    }

    private void initAfter() {

        // Utilizamos el metodo establecerFavicon para cargar el favicon establecido en el archivo propeties,
        // si no hay ninguno establecido, cogerá el favicon por defecto.
        // this hace referencia a la propia ventana, es decir, al objeto de la ventana. Se puede sustituir por el nombre del objeto de la bentana
        // al que lo queremos aplicar
        UtilesSwing.establecerFavicon(this, prp.getProperty(PRP_FAVICON, DEF_FAVICON));
        
    }

}
