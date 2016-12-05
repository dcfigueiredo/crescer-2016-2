/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.dto.Pessoa;
import br.com.cwi.crescer.aula8.services.PessoaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel.figueiredo
 */
@RestController
public class PessoaController {
    
    @Autowired private PessoaService pessoaService;
    
    @ResponseBody
    @RequestMapping(value="/pessoas.json", method = RequestMethod.GET)
    public Iterable<Pessoa> list(){
        return pessoaService.findAll();
    }
        
    @ResponseBody
    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setDtNascimento(new Date());        
        pessoaService.save(p);
        return Stream.of(p).collect(Collectors.toList());
    }
    
}
