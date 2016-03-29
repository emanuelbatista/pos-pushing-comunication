/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.producer;

import br.edu.ifpb.pos.pushing.core.Message;
import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.core.ResponseType;
import br.edu.ifpb.pos.pushing.servidor.notificador.Notificar;
import br.edu.ifpb.pos.pushing.servidor.repository.Enqueuer;
import br.edu.ifpb.pos.pushing.servidor.repository.ResponseRepository;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Processor implements Runnable {

    private final Enqueuer enqueuer;
    private final ResponseRepository responseRepository;

    public Processor() throws MalformedURLException {
        enqueuer = Enqueuer.getInstance();
        responseRepository = ResponseRepository.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            Message message = enqueuer.dequeue();
            if (message == null) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                }
                continue;
            }
            try {
                long time = System.currentTimeMillis();
                Random random = new Random();
                String dado = message.getDado();
                Thread.sleep(random.nextInt(20000) + 10000);
                time = System.currentTimeMillis() - time;
                responseRepository.store(message.getSession(),new Response(ResponseType.SUCCESS,dado));
                Timer timer=new Timer();
                timer.schedule(new Notificar(message.getSession()), 0, 10000);
            } catch (InterruptedException|MalformedURLException ex) {
                responseRepository.store(message.getSession(),new Response(ResponseType.FAIL, null));
            }
        }
    }

}
