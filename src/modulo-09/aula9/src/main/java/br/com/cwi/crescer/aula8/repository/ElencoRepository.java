/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.entity.Elenco;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author daniel.figueiredo
 */
public interface ElencoRepository extends PagingAndSortingRepository<Elenco, Long>{
    
}
