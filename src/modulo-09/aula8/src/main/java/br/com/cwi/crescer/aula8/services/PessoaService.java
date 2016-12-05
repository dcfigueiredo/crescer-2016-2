/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.services;

import br.com.cwi.crescer.aula8.dto.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daniel.figueiredo
 */
public class PessoaService {
    
    @Autowired
    PessoaRepository pr;
    
    public void save(Pessoa p){
        pr.save(p);
    }
    
    public Iterable<Pessoa> findAll(){
        return pr.findAll();
    }
    
    public void delete(Pessoa p){
        pr.delete(p);
    }
}
