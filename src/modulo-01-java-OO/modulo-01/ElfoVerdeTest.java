import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{

    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void testarSeNasceuComItemsComDescricaoCertao(){
        ElfoVerde elfinho = new ElfoVerde ("asd", 42);
        String descricaoEsperadaEspada = "Espada de aço valiriano";
        String descricaoEsperadaArcoEFlecha = "Arco e Flecha de Vidro";

        assertEquals(descricaoEsperadaEspada, elfinho.getMochila().getArrayList().get(0).getDescricao());
        assertEquals(descricaoEsperadaArcoEFlecha, elfinho.getMochila().getArrayList().get(1).getDescricao());
    }

    @Test
    public void testarAdicionarItensComDescricaoErrada(){
        ElfoVerde elfinho = new ElfoVerde ("asd", 42);
        Item espadaDeAçoInox = new Item ("Tramontina", 42);
        elfinho.adicionarItem(espadaDeAçoInox);

        assertFalse(elfinho.getMochila().getArrayList().contains(espadaDeAçoInox));
    }

    @Test
    public void testarAdicionarItensComDescricaoCerta(){
        ElfoVerde elfinho = new ElfoVerde ("asd", 42);
        Item espadaDeAçoInox = new Item ("Espada de aço valiriano", 1);
        elfinho.adicionarItem(espadaDeAçoInox);

        assertTrue(elfinho.getMochila().getArrayList().contains(espadaDeAçoInox));
    }

    public void testarAumentarExperienciaCom1Flechada(){
        ElfoVerde elfinho = new ElfoVerde("asd", 42);
        elfinho.atirarFlecha(new Dwarf("ASD"));
        elfinho.atirarFlecha(new Dwarf("ASD"));
        assertEquals(40, elfinho.getFlecha().getQuantidade());
        assertEquals(4, elfinho.getExperiencia());
    }

    public void elfoAtiraTodasFlechas() {
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("asd", 42);
        while (elfoDoTeste.getFlecha().getQuantidade() > 0) {
            elfoDoTeste.atirarFlecha(new Dwarf("ASD"));
        }
        // Assert
        assertEquals (0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals (84, elfoDoTeste.getExperiencia());
    }
}
