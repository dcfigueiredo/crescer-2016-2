import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{
    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void testarPerderVidaComFlechada(){
        ElfoNoturno e = new ElfoNoturno ("asd");
        e.atirarFlecha(new Dwarf("asd"));
        assertEquals(95.0, e.getVida(),0.);
    }

    @Test
    public void testarMorrerVidaComFlechada(){
        ElfoNoturno e = new ElfoNoturno ("asd", 90);
        while ( e.getFlecha().getQuantidade() > 0){            
            e.atirarFlecha(new Dwarf("asd"));
        }
        assertEquals(Status.MORTO, e.getStatus());
    }
}
