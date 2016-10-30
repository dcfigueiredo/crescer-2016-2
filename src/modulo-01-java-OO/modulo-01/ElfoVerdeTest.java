import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
public class ElfoVerdeTest{

    @After
    public void tearDown(){
=======
public class ElfoVerdeTest {

    @After
    // executa após cada cenário de testes.
    public void tearDown() {
>>>>>>> master
        System.gc();
    }

    @Test
<<<<<<< HEAD
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
=======
    public void elfoVerdeAdicionaEspadaValiriana() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        Item espada = new Item("Espada de aço valiriano", 1);
        sortudo.adicionarItem(espada);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(espada, sortudo.getInventario().getItens().get(2));
    }

    @Test
    public void elfoVerdeAdicionaItemComDescricaoInvalida() {
        ElfoVerde sortudo = new ElfoVerde("Mugless");
        Item caneca = new Item("Caneca", 1);
        sortudo.adicionarItem(caneca);
        boolean adicionou = sortudo.getInventario().getItens().contains(caneca);
        assertEquals(2, sortudo.getInventario().getItens().size());
        assertFalse(adicionou);
    }

    @Test
    public void elfoVerdeAdicionaFlechaVidroENulo() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        Item flechaDeVidro = new Item("Flecha de Vidro", 1);
        sortudo.adicionarItem(flechaDeVidro);
        sortudo.adicionarItem(null);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(flechaDeVidro, sortudo.getInventario().getItens().get(2));
    }

    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroEDescricaoNula() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        Item arcoEFlecha = new Item("Arco de Vidro", 1);
        Item descricaoNula = new Item(null, 1);
        sortudo.adicionarItem(arcoEFlecha);
        sortudo.adicionarItem(descricaoNula);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(arcoEFlecha, sortudo.getInventario().getItens().get(2));
    }

    @Test
    public void elfoVerdeGanhaExperienciaMesmoNaoTendoFlechas() {
        ElfoVerde greenLegolas = new ElfoVerde("Green Legolas", 1);
        greenLegolas.atirarFlecha(new Dwarf());
        greenLegolas.atirarFlecha(new Dwarf());
        assertEquals(2, greenLegolas.getExperiencia());
    }

>>>>>>> master
}
