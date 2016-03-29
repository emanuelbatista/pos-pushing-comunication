/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.producer;

import br.edu.ifpb.pos.pushing.core.Message;
import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.servidor.repository.Enqueuer;
import br.edu.ifpb.pos.pushing.servidor.repository.ResponseRepository;
import java.rmi.RemoteException;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Producer {

    private final Enqueuer enqueuer;
    private final ResponseRepository responseRepository;

    public Producer() {
        this.enqueuer = Enqueuer.getInstance();
        this.responseRepository = ResponseRepository.getInstance();
    }

    
    public void request(Message request){
        enqueuer.enqueue(request);
    }

    public Response response(String session) throws RemoteException {
        Response response = responseRepository.getResponse(session);
        return response;
    }

}
