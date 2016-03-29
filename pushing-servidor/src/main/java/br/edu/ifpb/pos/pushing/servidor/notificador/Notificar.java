/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.notificador;

import br.edu.ifpb.pos.pushing.core.channel.NotificadorChannel;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Notificar extends Thread {

    private String uid;
    private NotificadorChannel notificadorChannel;

    public Notificar(String uid) throws MalformedURLException {
        this.uid = uid;
        notificadorChannel = NotificadorFactory.getInstance();
    }

    @Override
    public void run() {
        try {
            while (!notificadorChannel.notificar(uid)) {
                Thread.sleep(10000);
            }
        } catch (RemoteException | InterruptedException ex) {
            Logger.getLogger(Notificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
