/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao;

import br.edu.ifpb.pos.pushing.core.channel.NotifyChannel;
import br.edu.ifpb.pos.pushing.notificacao.repository.NotifyRepository;
import javax.jws.WebService;
import javax.jws.Oneway;
import javax.jws.WebMethod;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "NotifyChannel",serviceName = "NotifyChannel",targetNamespace = "http://channel.core.pushing.pos.ifpb.edu.br/")
public class NotifyChannelImpl implements NotifyChannel{
    
    private NotifyRepository repository;

    public NotifyChannelImpl() {
        this.repository=NotifyRepository.getInstance();
    }
    
    @Oneway
    @WebMethod
    public void notify(String session){
        System.out.println("Recendo notificação: "+session);
        repository.getIds().add(session);
    }
    
    
}
