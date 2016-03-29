/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.channel;

import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.core.channel.ResponseChannel;
import br.edu.ifpb.pos.pushing.servidor.producer.Producer;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "ResponseChannel",serviceName = "ResponseChannel",targetNamespace = "http://channel.core.pushing.pos.ifpb.edu.br/")
public class ResponseChannelImpl implements ResponseChannel{

    private Producer producer;

    public ResponseChannelImpl(Producer producer) {
        this.producer=producer;
    }
    
    
    @Override
    public Response responseResult(String session) throws RemoteException {
        return producer.response(session);
    }
    
}
