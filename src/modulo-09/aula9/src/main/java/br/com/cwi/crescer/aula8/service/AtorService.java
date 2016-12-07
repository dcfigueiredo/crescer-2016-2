/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class AtorService {

    @Autowired
    AtorRepository idiomaRepository;

    public Page<Ator> findAll(Pageable pgbl) {
        return idiomaRepository.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return idiomaRepository.findAll();
    }

    public Ator save(Ator g) {
        return idiomaRepository.save(g);
    }

    public void delete(Long id) {
        idiomaRepository.delete(id);
    }

    public Ator findOne(Long id) {
        return idiomaRepository.findOne(id);
    }
}
