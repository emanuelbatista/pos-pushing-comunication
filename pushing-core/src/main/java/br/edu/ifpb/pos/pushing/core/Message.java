/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.core;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Message {
    
    private String session;
    private String dado;

    public Message() {
    }

    public Message(String session, String dado) {
        this.session = session;
        this.dado = dado;
    }
    
    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }
    

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
    
    
}
