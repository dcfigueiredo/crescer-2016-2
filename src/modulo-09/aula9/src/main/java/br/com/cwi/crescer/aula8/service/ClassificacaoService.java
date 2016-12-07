/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Classificacao;
import br.com.cwi.crescer.aula8.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
/**
 *
 * @author daniel.figueiredo
 */
@Service
public class ClassificacaoService {
    
    @Autowired
    ClassificacaoRepository classificacaoRepository;
    
        public Page<Classificacao> findAll(Pageable pgbl) {
        return classificacaoRepository.findAll(pgbl);
    }

    public Iterable<Classificacao> findAll() {
        return classificacaoRepository.findAll();
    }

    public Classificacao save(Classificacao g) {
        return classificacaoRepository.save(g);
    }

    public void delete(Long id) {
        classificacaoRepository.delete(id);
    }

    public Classificacao findOne(Long id) {
        return classificacaoRepository.findOne(id);
    }
}
