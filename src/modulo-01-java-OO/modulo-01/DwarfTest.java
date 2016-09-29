
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

    @Test
    public void testaNumeroDaSorte101(){
        double numeroEsperado = 101.0;
        Dwarf dwarfDoTeste = new Dwarf ("asd", new DataTerceiraEra (1,1,1));
        assertEquals(numeroEsperado, dwarfDoTeste.getNumeroSorte(), .0);
    }

    @Test
    public void testaNumeroDaSorteMenos3333(){
        double numeroEsperado = -3333.0;
        Dwarf dwarfDoTeste = new Dwarf ("asd", new DataTerceiraEra (1,1,2000));
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        assertEquals(numeroEsperado, dwarfDoTeste.getNumeroSorte(), .0);
    }

    @Test
    public void testaNumeroDaSorte33(){
        double numeroEsperado = 33;
        Dwarf dwarfDoTeste = new Dwarf ("Meireles", new DataTerceiraEra (1,1,1));
        assertEquals(numeroEsperado, dwarfDoTeste.getNumeroSorte(), .0);
    }
}
