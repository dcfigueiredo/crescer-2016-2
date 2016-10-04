import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{

    @Test
    public void testarAdicionarItensComDescricaoErrada(){
        ElfoVerde elfinho = new ElfoVerde ("asd");
        Item espadaDeAçoInox = new Item ("Tramontina", 1);
        elfinho.adicionarItem(espadaDeAçoInox);

        assertFalse(elfinho.getMochila().getArrayList().contains(0));
    }

    @Test
    public void testarAdicionarItensComDescricaoCerta(){
        ElfoVerde elfinho = new ElfoVerde ("asd");
        Item espadaDeAçoInox = new Item ("Espada de aço valiriano", 1);
        elfinho.adicionarItem(espadaDeAçoInox);

        assertTrue(elfinho.getMochila().getArrayList().contains(espadaDeAçoInox));
    }
}
