/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.cliente;

import br.edu.ifpb.pos.pushing.core.Message;
import br.edu.ifpb.pos.pushing.core.channel.PushingChannel;
import br.edu.ifpb.pos.pushing.core.channel.RegistryChannel;
import br.edu.ifpb.pos.pushing.core.channel.RequestChannel;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException {
        RegistryChannel registryChannel=ChannelManager.getRegistryChannel();
        RequestChannel requestChannel=ChannelManager.getRequestChannel();
        PushingChannel pushingChannel=ChannelManager.getPushingChannel();
        
        System.out.println("Conectando no notificador...");
        Socket socket=new Socket("localhost", 7000);
        String uid=registryChannel.registry();
        System.out.println("registrado: "+uid);
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
        printWriter.println(uid);
        System.out.println("Concectado ao notificador");
        
        System.out.println("Enviando a messagem ao servidor");
        requestChannel.request(new Message(uid, 10));
        System.out.println("messagem enviada");
        //
        Scanner scanner=new Scanner(socket.getInputStream());
        String respostaNotificacao=scanner.nextLine();
        System.out.println("Notificado");
        if(respostaNotificacao.equals("true")){
            System.out.println(pushingChannel.pushing(uid).getMessage());
        }
    }
}
