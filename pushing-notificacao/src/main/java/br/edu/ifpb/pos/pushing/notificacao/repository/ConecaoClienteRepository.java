/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao.repository;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ConecaoClienteRepository{
        
    private Map<String,PrintWriter> conectorCliente;
        
    
    private ConecaoClienteRepository() {
        this.conectorCliente=new HashMap();
    }
    
    public static ConecaoClienteRepository getInstance() {
        return ConecaoClienteRepositoryHolder.INSTANCE;
    }
    
    private static class ConecaoClienteRepositoryHolder {
        private static final ConecaoClienteRepository INSTANCE = new ConecaoClienteRepository();
    }

    public Map<String, PrintWriter> getConectorCliente() {
        return conectorCliente;
    }

    public void setConectorCliente(Map<String, PrintWriter> conectorCliente) {
        this.conectorCliente = conectorCliente;
    }
    
    
}
