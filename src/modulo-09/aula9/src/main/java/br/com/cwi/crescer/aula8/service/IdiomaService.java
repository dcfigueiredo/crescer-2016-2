/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Idioma;
import br.com.cwi.crescer.aula8.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class IdiomaService {

    @Autowired
    IdiomaRepository idiomaRepository;

    public Page<Idioma> findAll(Pageable pgbl) {
        return idiomaRepository.findAll(pgbl);
    }

    public Iterable<Idioma> findAll() {
        return idiomaRepository.findAll();
    }

    public Idioma save(Idioma p) {
        return idiomaRepository.save(p);
    }

    public void delete(Long id) {
        idiomaRepository.delete(id);
    }

    public Idioma findOne(Long id) {
        return idiomaRepository.findOne(id);
    }

}
