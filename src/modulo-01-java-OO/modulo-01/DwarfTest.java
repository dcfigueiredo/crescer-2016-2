
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void testaReceber1Flecha (){
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf zangado = new Dwarf ("zangado", new DataTerceiraEra(1,1,1));
        elfoDoTeste.atirarFlecha(zangado);
        assertEquals(100, zangado.getVida());   
    }

    @Test	
    public void testaDwarfMorto ()  {
        Elfo elfoDoTeste = new Elfo ("asd");
        Dwarf atchim = new Dwarf ("Atchim", new DataTerceiraEra(1,1,1));
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
        Dwarf dunga = new Dwarf ("Dunga", new DataTerceiraEra(1,1,1));
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

    @Test
    public void testaDataDeNascimento (){
        DataTerceiraEra dataEsperada = new DataTerceiraEra(22,1,3987);
        Dwarf muradinBronzebeard = new Dwarf ("Muradin", dataEsperada);
        assertEquals(22, muradinBronzebeard.getDataNascimento().getDia());
        assertEquals(1, muradinBronzebeard.getDataNascimento().getMes());
        assertEquals(3987, muradinBronzebeard.getDataNascimento().getAno());
    }
    
    @Test
    public void testaNomeDoDwarf(){
        String nomeEsperado = "Magni";
        Dwarf dwarfDoTeste = new Dwarf (nomeEsperado, new DataTerceiraEra(1,1,1));
        assertEquals("Magni", dwarfDoTeste.getNome());
    }
}
