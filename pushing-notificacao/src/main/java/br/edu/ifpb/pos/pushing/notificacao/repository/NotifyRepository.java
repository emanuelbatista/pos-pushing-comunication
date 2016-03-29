/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.pushing.notificacao.repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class NotifyRepository{
        
    private List<String> ids;
        
    
    private NotifyRepository() {
        this.ids=new ArrayList<String>();
    }
    
    public static NotifyRepository getInstance() {
        return ConecaoClienteRepositoryHolder.INSTANCE;
    }
    
    private static class ConecaoClienteRepositoryHolder {
        private static final NotifyRepository INSTANCE = new NotifyRepository();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    
    
    
}
