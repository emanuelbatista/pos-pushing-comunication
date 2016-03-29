/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.notificador;

import br.edu.ifpb.pos.pushing.core.channel.NotifyChannel;
import br.edu.ifpb.pos.pushing.servidor.repository.ResponseRepository;
import java.net.MalformedURLException;
import java.util.TimerTask;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Notificar extends TimerTask {

    private String uid;
    private NotifyChannel notifyChannel;
    private ResponseRepository responseRepository;

    public Notificar(String uid) throws MalformedURLException {
        this.uid = uid;
        notifyChannel = NotifyFactory.getInstance();
        responseRepository = ResponseRepository.getInstance();
    }

    @Override
    public void run() {
        if (responseRepository.getResponses().containsKey(uid)) {
            notifyChannel.notify(uid);
        } else {
            this.cancel();
        }
    }

}
