
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void testaReceber1Flecha (){
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf zangado = new Dwarf ();
        elfoDoTeste.atirarFlecha(zangado);
        assertEquals(100, zangado.getVida());   
    }

    @Test	
    public void testaDwarfMorto ()  {
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf atchim = new Dwarf ();
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        elfoDoTeste.atirarFlecha(atchim);
        assertEquals("MORTO", atchim.getStatus());	
    }

    @Test
    public void testaDwarfVidaNegativa ()  {
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf dunga = new Dwarf ();
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        elfoDoTeste.atirarFlecha(dunga);
        assertEquals(0, dunga.getVida());	
    }
}
