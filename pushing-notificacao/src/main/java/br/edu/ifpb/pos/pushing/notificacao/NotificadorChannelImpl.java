/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao;

import br.edu.ifpb.pos.pushing.core.channel.NotificadorChannel;
import br.edu.ifpb.pos.pushing.notificacao.repository.ConecaoClienteRepository;
import javax.jws.WebService;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "NotificadorChannel",serviceName = "NotificadorChannel",targetNamespace = "http://channel.core.pushing.pos.ifpb.edu.br/")
public class NotificadorChannelImpl implements NotificadorChannel{
    
    private ConecaoClienteRepository repository;

    public NotificadorChannelImpl() {
        this.repository=ConecaoClienteRepository.getInstance();
    }
    
    public boolean notificar(String session){
        System.out.println("Recendo notificação: "+session);
        if(repository.getConectorCliente().containsKey(session)){
           repository.getConectorCliente().get(session).println("true");
           return true;
        }
        return false;
    }
    
    
}
