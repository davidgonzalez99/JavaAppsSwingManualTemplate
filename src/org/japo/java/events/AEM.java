/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.japo.java.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.japo.java.forms.GUI;

/**
 *
 * @author David González Candelas - davidgonzalezcandelas@gmail.com
 */
public class AEM implements ActionListener {

    private GUI gui;

    public AEM(GUI gui) {
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
