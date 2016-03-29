/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao;

import br.edu.ifpb.pos.pushing.notificacao.repository.ConecaoClienteRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ConexaoCliente {
    
    public static void ativarConexao() throws IOException{
        ServerSocket serverSocket=new ServerSocket(7000);
        ConecaoClienteRepository conecaoClienteRepository=ConecaoClienteRepository.getInstance();
        while(true){
            Socket socket=serverSocket.accept();
            Scanner scanner=new Scanner(socket.getInputStream());
            String uid=scanner.nextLine();
            conecaoClienteRepository.getConectorCliente().put(uid, new PrintWriter(socket.getOutputStream(),true));
        }
    }
    
}
