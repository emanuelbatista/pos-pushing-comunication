/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.servidor.repository;


import br.edu.ifpb.pos.pushing.core.Response;
import br.edu.ifpb.pos.pushing.core.ResponseType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ResponseRepository {
    
    private final Map<String,Response> responses;
    
    private ResponseRepository() {
        this.responses=new HashMap();
    }
    
    public static ResponseRepository getInstance() {
        return ResponseRepositoryHolder.INSTANCE;
    }
    
    private static class ResponseRepositoryHolder {

        private static final ResponseRepository INSTANCE = new ResponseRepository();
    }
    
    public void store(String id,Response response){
        responses.put(id, response);
    }
    
    public Response getResponse(String uid){
        Response response=responses.get(uid);
        if(response==null){
            return new Response(ResponseType.NO_RESPONSE, null);
        }
        responses.remove(uid);
        return response;
    }
}
