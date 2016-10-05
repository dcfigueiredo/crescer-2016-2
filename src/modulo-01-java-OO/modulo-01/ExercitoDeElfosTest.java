import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{
    @Test
    public void testarAlistarElfoEProcurarPeloNome(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno ("Elfinho da night");
        Elfo elfoVerde1 = new ElfoVerde("Elfinho da grama");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoVerde1);
        
        assertEquals(elfoNoturno1, exercito.buscarElfoPeloNome("Elfinho da night"));
        assertEquals(elfoVerde1, exercito.buscarElfoPeloNome("Elfinho da grama"));
    }
}
