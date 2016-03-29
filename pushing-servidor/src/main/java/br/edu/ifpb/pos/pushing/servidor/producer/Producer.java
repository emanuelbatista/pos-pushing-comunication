/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.producer;

//import br.edu.ifpb.pos.core.bo.Message;
//import br.edu.ifpb.pos.core.bo.Response;
//import br.edu.ifpb.pos.core.bo.ResponseType;
//import br.edu.ifpb.pos.servidor.repository.Enqueuer;
//import br.edu.ifpb.pos.servidor.repository.IndentificationManager;
//import br.edu.ifpb.pos.servidor.repository.ResponseRepository;
import br.edu.ifpb.pos.pushing.core.Message;
import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.servidor.repository.Enqueuer;
import br.edu.ifpb.pos.pushing.servidor.repository.IndentificationManager;
import br.edu.ifpb.pos.pushing.servidor.repository.ResponseRepository;
import java.rmi.RemoteException;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Producer {

    private final Enqueuer enqueuer;
    private final ResponseRepository responseRepository;
    private final IndentificationManager indentificationManager;

    public Producer() {
        this.enqueuer = Enqueuer.getInstance();
        this.responseRepository = ResponseRepository.getInstance();
        this.indentificationManager=IndentificationManager.getInstance();
    }

    public String registry(){
        return indentificationManager.registry();
    }
    
    public void request(Message request){
        enqueuer.enqueue(request);
    }

    public Response pushing(String session) throws RemoteException {
        Response response = responseRepository.getResponse(session);
        this.indentificationManager.release(session);
        return response;
    }

}
