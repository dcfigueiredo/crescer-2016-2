import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{
    @Test
    public void testarPerderVidaComFlechada(){
        ElfoNoturno e = new ElfoNoturno ("asd");
        e.atirarFlecha(new Dwarf("asd"));
        assertEquals(95.0, e.getVida(),0.);
    }
}
