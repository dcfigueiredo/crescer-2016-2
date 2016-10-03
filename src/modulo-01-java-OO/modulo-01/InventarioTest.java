import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest{

    @Test
    public void testarDescricaoDe2Itens(){
        Dwarf dwarfDoTeste = new Dwarf (" ");
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        assertEquals("Bala,Bala", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }

    @Test
    public void testarDescricaoDe4Itens(){
        Dwarf dwarfDoTeste = new Dwarf (" ");
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        dwarfDoTeste.adicionarItem(new Item ("Bala", 1));
        assertEquals("Bala,Bala,Bala,Bala", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }

    @Test
    public void testarMaiorItemEntre5Itens(){
        Dwarf dwarfDoTeste = new Dwarf ("Urist");
        Item itemEsperado = new Item ("Plump helmets", 50);
        dwarfDoTeste.adicionarItem(new Item ("Plump helmets", 50));
        dwarfDoTeste.adicionarItem(new Item ("Master Crafter Axe", 1));
        dwarfDoTeste.adicionarItem(new Item ("Master Crafter Axe", 1));
        dwarfDoTeste.adicionarItem(new Item ("Master Crafter Axe", 1));
        dwarfDoTeste.adicionarItem(new Item ("Master Crafter Axe", 1));
        assertEquals(itemEsperado.getDescricao(), dwarfDoTeste.getMochila().itemComMaiorQuantidade().getDescricao());
        assertEquals(itemEsperado.getQuantidade(), dwarfDoTeste.getMochila().itemComMaiorQuantidade().getQuantidade());
    }

    @Test
    public void testarOrdenarInventarioCom3Itens(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        dwarfDoTeste.adicionarItem(new Item ("Barba", 1));
        dwarfDoTeste.adicionarItem(new Item ("Flechas", 24));
        dwarfDoTeste.adicionarItem(new Item ("Ossos", 3));
        dwarfDoTeste.getMochila().ordenarItens();
        assertEquals("Barba,Ossos,Flechas", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }

    @Test
    public void testarOrdenarInventarioCom8Itens(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        dwarfDoTeste.adicionarItem(new Item ("Barba", 1));
        dwarfDoTeste.adicionarItem(new Item ("Flechas", 24));
        dwarfDoTeste.adicionarItem(new Item ("Ossos", 3));
        dwarfDoTeste.adicionarItem(new Item ("Olhos", 3));
        dwarfDoTeste.adicionarItem(new Item ("Esferas", 3));        
        dwarfDoTeste.adicionarItem(new Item ("Cerveja", 7));
        dwarfDoTeste.adicionarItem(new Item ("Mais Cerveja", 100));
        dwarfDoTeste.getMochila().ordenarItens();
        assertEquals("Barba,Ossos,Olhos,Esferas,Cerveja,Flechas,Mais Cerveja", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }

    @Test
    public void testarOrdenarInventarioCom8ItensAscendente(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        dwarfDoTeste.adicionarItem(new Item ("Barba", 1));
        dwarfDoTeste.adicionarItem(new Item ("Flechas", 24));
        dwarfDoTeste.adicionarItem(new Item ("Ossos", 3));
        dwarfDoTeste.adicionarItem(new Item ("Olhos", 3));
        dwarfDoTeste.adicionarItem(new Item ("Esferas", 3));        
        dwarfDoTeste.adicionarItem(new Item ("Cerveja", 7));
        dwarfDoTeste.adicionarItem(new Item ("Mais Cerveja", 100));
        dwarfDoTeste.getMochila().ordenarItens(TipoOrdenacao.ASCENDENTE);
        assertEquals("Barba,Ossos,Olhos,Esferas,Cerveja,Flechas,Mais Cerveja", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }

    @Test
    public void testarOrdenarInventarioCom8ItensDescendente(){
        Dwarf dwarfDoTeste = new Dwarf ("ASD");
        dwarfDoTeste.adicionarItem(new Item ("Barba", 1));
        dwarfDoTeste.adicionarItem(new Item ("Flechas", 24));
        dwarfDoTeste.adicionarItem(new Item ("Ossos", 2));
        dwarfDoTeste.adicionarItem(new Item ("Olhos", 3));
        dwarfDoTeste.adicionarItem(new Item ("Esferas", 4));        
        dwarfDoTeste.adicionarItem(new Item ("Cerveja", 7));
        dwarfDoTeste.adicionarItem(new Item ("Mais Cerveja", 100));
        dwarfDoTeste.getMochila().ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Mais Cerveja,Flechas,Cerveja,Esferas,Olhos,Ossos,Barba", dwarfDoTeste.getMochila().getDescricaoDeTodosOsItens());
    }
}
