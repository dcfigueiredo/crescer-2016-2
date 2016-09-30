import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    @Test
    public void testarSorteCom1Item(){
        IrishDwarf dwarf = new IrishDwarf ("ASD", new DataTerceiraEra (1,1,2000));
        dwarf.adicionarItem(new Item ("Moedas de ouro", 5));
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tiraVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getMochila().getArrayList().get(0).getQuantidade());
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
}
