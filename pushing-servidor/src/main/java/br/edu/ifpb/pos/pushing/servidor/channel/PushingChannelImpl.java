/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.channel;

import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.core.channel.PushingChannel;
import br.edu.ifpb.pos.pushing.servidor.producer.Producer;
import java.rmi.RemoteException;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "PushingChannel",serviceName = "PushingChannel",targetNamespace = "http://channel.core.pushing.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class PushingChannelImpl implements PushingChannel{
    
    private Producer producer;

    public PushingChannelImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public Response pushing(String session) throws RemoteException {
        return producer.pushing(session);
    }
    
    
}
