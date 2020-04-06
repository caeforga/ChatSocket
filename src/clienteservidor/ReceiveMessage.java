/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor;

import com.sun.istack.internal.logging.Logger;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JTextArea;

/**
 *
 * @author osito
 */
public class ReceiveMessage extends Thread {
    String msg = " ";
    DataInputStream dis = null;
    JTextArea txt_area = null;
    
    public ReceiveMessage(DataInputStream d, JTextArea a) {
        this.dis = d;
        this.txt_area = a;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                msg = dis.readUTF();
                txt_area.append("\n" + this.getName() + ":" + msg);
            } catch (IOException ex) {
                
                /*Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);*/
            }
        }
    }
}
