
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

    @Test
    public void testaPerderVida(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD", new DataTerceiraEra(1,1,2000));
        dwarfDoTeste.tiraVida();
        assertEquals(100,dwarfDoTeste.getVida());
    }

    @Test
    public void testaGanhaExperiencia(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD", new DataTerceiraEra(1,1,2000));
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        assertEquals(2,dwarfDoTeste.getExperiencia());
    }

    @Test
    public void testaDwarfNaoRecebeFlechadaNemExperiencia(){
        Dwarf dwarfDoTeste = new Dwarf ("Meireles", new DataTerceiraEra(1,1,1));
        assertEquals(0,dwarfDoTeste.getExperiencia());
        assertEquals(110,dwarfDoTeste.getVida());
    }

    @Test
    public void testaDwarfNasceVivo(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD", new DataTerceiraEra(1,1,2000));
        assertEquals(Status.VIVO, dwarfDoTeste.getStatus());
    }

    @Test
    public void testaDwarfMorre(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD", new DataTerceiraEra(1,1,1));
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        dwarfDoTeste.tiraVida();
        assertEquals(Status.MORTO,dwarfDoTeste.getStatus());
    }

    @Test
    public void testaAdicionarItem (){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        Item itemEsperado = new Item ("Barba", 1);
        dwarfDoTeste.adicionarItem(itemEsperado);
        assertEquals(true, dwarfDoTeste.getMochila().getArrayList().contains(itemEsperado));
    }

    @Test
    public void testaAdicionar2Itens (){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        Item itemEsperado = new Item ("Barba", 1);
        Item outroItemEsperado = new Item ("OutraBarba", 1);
        dwarfDoTeste.adicionarItem(itemEsperado);
        dwarfDoTeste.adicionarItem(outroItemEsperado);        
        assertEquals(true, dwarfDoTeste.getMochila().getArrayList().contains(itemEsperado));
        assertEquals(true, dwarfDoTeste.getMochila().getArrayList().contains(outroItemEsperado));
    }

    @Test
    public void testaRemoverItem (){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        Item itemEsperado = new Item ("Barba", 1);
        dwarfDoTeste.adicionarItem(itemEsperado);
        dwarfDoTeste.removerItem(itemEsperado);
        assertEquals(false, dwarfDoTeste.getMochila().getArrayList().contains(itemEsperado));
    }

    @Test
    public void testaRemover2Itens (){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        Item itemEsperado = new Item ("Barba", 1);
        Item outroItemEsperado = new Item ("OutraBarba", 1);
        dwarfDoTeste.adicionarItem(itemEsperado);
        dwarfDoTeste.adicionarItem(outroItemEsperado);
        dwarfDoTeste.removerItem(itemEsperado);
        dwarfDoTeste.removerItem(outroItemEsperado);        
        assertEquals(false, dwarfDoTeste.getMochila().getArrayList().contains(itemEsperado));
        assertEquals(false, dwarfDoTeste.getMochila().getArrayList().contains(outroItemEsperado));
    }
}
