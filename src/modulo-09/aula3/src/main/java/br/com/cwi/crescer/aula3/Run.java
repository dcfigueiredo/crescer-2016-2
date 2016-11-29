package br.com.cwi.crescer.aula3;

import dao.ClientDao;
import entity.Client;
import java.util.List;
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
        
        ClientDao cd = new ClientDao(em);
        Client client = new Client();
        
        client.setDsEmail("a@a");
        client.setDsPassword("123");
        client.setDsPreferredCoin("Real");
        client.setDsState("Estado");
        client.setDsUserName("Dani");
        client.setNmClient("Daniel");
        client.setTpPERMISSION("Nenhuma");
        
        cd.insert(client);
        cd.export();

    }
}
