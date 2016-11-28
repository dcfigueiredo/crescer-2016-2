package br.com.cwi.crescer.aula3;

import dao.PessoaDao;
import entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel.figueiredo
 */
public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Daniel");
        PessoaDao pf = new PessoaDao(em);
        pf.insert(pessoa);

        em.close();
        emf.close();
    }
}
