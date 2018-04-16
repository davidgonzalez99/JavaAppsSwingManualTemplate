/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.main;

import java.util.Properties;
import javax.swing.SwingUtilities;
import org.japo.java.forms.GUI;
import org.japo.java.libraries.UtilesApp;

/**
 *
 * @author CicloM
 */
public class Main {

    public static final String FICHERO_PROPIEDADES = "app.properties";

    public static void main(String[] args) {

        // Lanzamos GUI gracias al método invokeLater() que necesita un objeto que implemente el interfaz Runnable, la flecha y el parentesis indica que estamos usando el operador Lambda y 
        // las 3 ordenes están dentro de un metodo run impuesto por el interfaz Runable, con lo cual ya se podría lanzar
        SwingUtilities.invokeLater(() -> {

            // Instanciamos un objeto properties y lo inicializamos con el contenido del fichero
            // properties gracias al método importarPropiedades. Esto servirá para personalizar
            // la aplicación. Para clientes diferentes, propiedades diferentes.
            Properties prp = UtilesApp.importarPropiedades(FICHERO_PROPIEDADES);

            // Instanciamos GUI pasándole las propiedades que sacamos del fichero. El constructor
            // se encarga de construir el interfaz, pero queda invisible.
            GUI gui = new GUI(prp);

            // Una vez se lanza esta orden, empieza la gestión de eventos y la interfaz grafica se hace visible(se lanza). Si se ponen órdenes fuera del hilo de gestor de eventos
            // el programa crasheará, asi que, a partir de este momento todas las instrucciones que se ejecuten deben estar dentro de un evento.
            gui.setVisible(true);
        });
    }

}
