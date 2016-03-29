/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.core.channel;

import br.edu.ifpb.pos.pushing.core.Response;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService
public interface ResponseChannel extends Remote{
    
    
    public Response responseResult(String session) throws RemoteException;
    
}
