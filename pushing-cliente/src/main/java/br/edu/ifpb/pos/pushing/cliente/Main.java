/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.cliente;

import br.edu.ifpb.pos.pushing.core.Message;
import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.core.channel.PushingChannel;
import br.edu.ifpb.pos.pushing.core.channel.RequestChannel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import br.edu.ifpb.pos.pushing.core.channel.ResponseChannel;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String idUser = "101A";
        System.out.println("Id do usuário: " + idUser);
        String idMensagem = String.valueOf(System.currentTimeMillis());
        System.out.println("Id Mensagem: " + idMensagem);
        String id = idUser + ":" + idMensagem;
        //
        RequestChannel requestChannel = ChannelManager.getRequestChannel();
        ResponseChannel responseChannel = ChannelManager.getResponseChannel();
        PushingChannel pushingChannel = ChannelManager.getPushingChannel();

        System.out.println("Enviando a messagem ao servidor");
        Scanner in = new Scanner(System.in);
        System.out.print("Digite a Mensagem: ");
        requestChannel.request(new Message(id, in.nextLine()));
        System.out.println("messagem enviada");
        //
        if (pushingChannel.pushing(id)) {
            System.out.println("Notificado");
            Response response=responseChannel.responseResult(id);
            System.out.println("Resposta: "+response.getMessage());

        }

    }
}
