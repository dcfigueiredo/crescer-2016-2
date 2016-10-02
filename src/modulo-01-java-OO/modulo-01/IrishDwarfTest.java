import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    @Test
    public void testarSorteCom1ItemQuantidadePositiva(){
        IrishDwarf dwarf = new IrishDwarf ("ASD", new DataTerceiraEra (1,1,2000));
        dwarf.adicionarItem(new Item ("Moedas de ouro", 5));
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getMochila().getArrayList().get(0).getQuantidade());
    }

    @Test
    public void testarSorteCom5ItemQuantidadePositiva(){
        IrishDwarf dwarf = new IrishDwarf ("ASD", new DataTerceiraEra (1,1,2000));
        dwarf.adicionarItem(new Item ("Moedas de ouro", 5));
        dwarf.adicionarItem(new Item ("Kobol Ear", 6)); // 21 * 1000 + 6
        dwarf.adicionarItem(new Item ("Teclado", 7)); // 28 * 1000 + 7
        dwarf.adicionarItem(new Item ("Iphone", 8)); // 36 * 1000 + 8
        dwarf.adicionarItem(new Item ("Orelhas do Mickey", 9)); // 45 * 100 + 9
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getMochila().getArrayList().get(0).getQuantidade());
        assertEquals(21006, dwarf.getMochila().getArrayList().get(1).getQuantidade());
        assertEquals(28007, dwarf.getMochila().getArrayList().get(2).getQuantidade());
        assertEquals(36008, dwarf.getMochila().getArrayList().get(3).getQuantidade());
        assertEquals(45009, dwarf.getMochila().getArrayList().get(4).getQuantidade());
    }

    @Test
    public void testarSorteCom1ItemQuantidadeNegativa() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item(-5, "Pint de Guinness"));
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getMochila().getArrayList().get(0).getQuantidade());
    }

    @Test
    public void testarSorteCom5ItensQuantidadeNegativa(){
        IrishDwarf dwarf = new IrishDwarf ("ASD", new DataTerceiraEra (1,1,2000));
        dwarf.adicionarItem(new Item ("Moedas de ouro", -5));
        dwarf.adicionarItem(new Item ("Kobol Ear", -6)); // 21 * 1000 + 6
        dwarf.adicionarItem(new Item ("Teclado", -7)); // 28 * 1000 + 7
        dwarf.adicionarItem(new Item ("Iphone", -8)); // 36 * 1000 + 8
        dwarf.adicionarItem(new Item ("Orelhas do Mickey", -9)); // 45 * 100 + 9
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getMochila().getArrayList().get(0).getQuantidade());
        assertEquals(20994, dwarf.getMochila().getArrayList().get(1).getQuantidade());
        assertEquals(27993, dwarf.getMochila().getArrayList().get(2).getQuantidade());
        assertEquals(35992, dwarf.getMochila().getArrayList().get(3).getQuantidade());
        assertEquals(44991, dwarf.getMochila().getArrayList().get(4).getQuantidade());
    }

    public void testarSorteCom5ItensQuantidadeNegativaEPositiva(){
        IrishDwarf dwarf = new IrishDwarf ("ASD", new DataTerceiraEra (1,1,2000));
        dwarf.adicionarItem(new Item ("Moedas de ouro", +5));
        dwarf.adicionarItem(new Item ("Kobol Ear", -6)); // 21 * 1000 + 6
        dwarf.adicionarItem(new Item ("Teclado", -7)); // 28 * 1000 + 7
        dwarf.adicionarItem(new Item ("Iphone", -8)); // 36 * 1000 + 8
        dwarf.adicionarItem(new Item ("Orelhas do Mickey", +9)); // 45 * 100 + 9
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getMochila().getArrayList().get(0).getQuantidade());
        assertEquals(20994, dwarf.getMochila().getArrayList().get(1).getQuantidade());
        assertEquals(27993, dwarf.getMochila().getArrayList().get(2).getQuantidade());
        assertEquals(35992, dwarf.getMochila().getArrayList().get(3).getQuantidade());
        assertEquals(45009, dwarf.getMochila().getArrayList().get(4).getQuantidade());
    }

}
