/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.notificador;

import br.edu.ifpb.pos.pushing.core.channel.NotificadorChannel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class NotificadorFactory {

    public static NotificadorChannel getInstance() throws MalformedURLException {
        URL url = new URL("http://localhost:9000/notificador?wsdl");
        QName qName = new QName("http://channel.core.pushing.pos.ifpb.edu.br/", "NotificadorChannel");
        Service service = Service.create(url, qName);
        return service.getPort(NotificadorChannel.class);
    }
}
