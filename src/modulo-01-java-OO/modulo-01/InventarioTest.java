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
}
