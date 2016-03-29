/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao;

import br.edu.ifpb.pos.pushing.core.channel.PushingChannel;
import br.edu.ifpb.pos.pushing.notificacao.repository.NotifyRepository;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "PushingChannel", serviceName = "PushingChannel", targetNamespace = "http://channel.core.pushing.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class PushingChannelImpl implements PushingChannel {

    private NotifyRepository notifyRepository;
    
    public PushingChannelImpl() {
        this.notifyRepository=NotifyRepository.getInstance();
    }
    
    @Override
    public boolean pushing(String session) throws RemoteException {
        while (!notifyRepository.getIds().contains(session)){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PushingChannelImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Notificando");
        notifyRepository.getIds().remove(session);
        return true;
    }

}
