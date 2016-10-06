import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoDeElfosTest{
    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void testarAlistarElfoNoturnoEElfoVerdeEProcurarPeloNome(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno ("Elfinho da night");
        Elfo elfoVerde1 = new ElfoVerde("Elfinho da grama");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoVerde1);

        assertEquals(elfoNoturno1, exercito.buscar("Elfinho da night"));
        assertEquals(elfoVerde1, exercito.buscar("Elfinho da grama"));
    }

    @Test
    public void testarAlistarElfoNormal(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNormal = new Elfo ("asd");
        exercito.alistarElfo(elfoNormal);

        assertEquals(null, exercito.buscar("asd"));
    }

    @Test
    public void testarBuscarPorStatusVivo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno ("Elfinho da night");
        Elfo elfoVerde1 = new ElfoVerde("Elfinho da grama");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoVerde1);
        ArrayList <Elfo> arrayDeElfosVivos = exercito.buscar(Status.VIVO);
        assertEquals(elfoNoturno1, arrayDeElfosVivos.get(0));
        assertEquals(elfoVerde1, arrayDeElfosVivos.get(1));
    }

    @Test
    public void testarBuscarPorElfoVivoComElfosMortosNoExercito(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno ("Elfinho da night");
        Elfo elfoNoturno2 = new ElfoNoturno ("xXxNarutoxXx",90);
        Elfo elfoVerde1 = new ElfoVerde("Elfinho da grama");
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoNoturno2);
        exercito.alistarElfo(elfoVerde1);

        while (elfoNoturno2.getStatus() != Status.MORTO){
            elfoNoturno2.atirarFlecha(new Dwarf("ASD"));
        }

        ArrayList <Elfo> arrayDeElfosVivos = exercito.buscar(Status.VIVO);
        assertEquals(elfoNoturno1, arrayDeElfosVivos.get(0));
        assertEquals(elfoVerde1, arrayDeElfosVivos.get(1));
    }
}
