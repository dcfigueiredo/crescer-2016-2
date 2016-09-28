
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    public void testaReceber1Flecha (){
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf zangado = new Dwarf ();
        elfoDoTeste.atirarFlecha(zangado);
        assertEquals(100, zangado.getVida());   
    }

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
}
