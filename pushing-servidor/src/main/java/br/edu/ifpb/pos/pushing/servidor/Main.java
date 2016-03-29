/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor;

import br.edu.ifpb.pos.pushing.servidor.channel.PushingChannelImpl;
import br.edu.ifpb.pos.pushing.servidor.channel.RegistryChannelImpl;
import br.edu.ifpb.pos.pushing.servidor.channel.RequestChannelImpl;
import br.edu.ifpb.pos.pushing.servidor.producer.Processor;
import br.edu.ifpb.pos.pushing.servidor.producer.Producer;
import java.net.MalformedURLException;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        Producer producer = new Producer();
        Endpoint.publish("http://localhost:8080/pushing", new PushingChannelImpl(producer));
        Endpoint.publish("http://localhost:8080/request", new RequestChannelImpl(producer));
        Endpoint.publish("http://localhost:8080/registry", new RegistryChannelImpl(producer));
        new Thread(new Processor()).start();
        System.out.println("Fim");
    }
}
