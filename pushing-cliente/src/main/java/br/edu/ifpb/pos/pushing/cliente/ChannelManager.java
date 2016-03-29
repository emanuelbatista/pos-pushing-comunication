/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.cliente;

import br.edu.ifpb.pos.pushing.core.channel.PushingChannel;
import br.edu.ifpb.pos.pushing.core.channel.RequestChannel;
import br.edu.ifpb.pos.pushing.core.channel.ResponseChannel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ChannelManager {
    
    public static PushingChannel getPushingChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:9000/pushing?wsdl");
        QName qName=new QName("http://channel.core.pushing.pos.ifpb.edu.br/", "PushingChannel");
        Service service=Service.create(url, qName);
        return service.getPort(PushingChannel.class);
    }
    
 
    public static RequestChannel getRequestChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:8080/request?wsdl");
        QName qName=new QName("http://channel.core.pushing.pos.ifpb.edu.br/", "RequestChannel");
        Service service=Service.create(url, qName);
        return service.getPort(RequestChannel.class);
    }
    
    public static ResponseChannel getResponseChannel() throws MalformedURLException{
        URL url=new URL("http://localhost:8080/response?wsdl");
        QName qName=new QName("http://channel.core.pushing.pos.ifpb.edu.br/", "ResponseChannel");
        Service service=Service.create(url, qName);
        return service.getPort(ResponseChannel.class);
    }
    
}
