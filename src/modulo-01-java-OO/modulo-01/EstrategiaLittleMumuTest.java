import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class EstrategiaLittleMumuTest{
    @Test
    public void testarEstrategiaLittleMumu (){
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        ElfoVerde ev1 = new ElfoVerde ("Verde 1", 0);          
        ElfoVerde ev2 = new ElfoVerde ("Verde 2", 40);
        ElfoVerde ev3 = new ElfoVerde ("Verde 3", 50);
        ElfoNoturno en1 = new ElfoNoturno ("Noturno 1", 3);
        ElfoNoturno en2 = new ElfoNoturno ("Noturno 2", 12);
        List <Elfo> elfosDoMumuzinho = new ArrayList <Elfo>();
        elfosDoMumuzinho.add(ev1);
        elfosDoMumuzinho.add(ev2);
        elfosDoMumuzinho.add(ev3);
        elfosDoMumuzinho.add(en1);
        elfosDoMumuzinho.add(en2);

        List <Elfo> listaEstrategica = estrategia.getOrdemDeAtaque(elfosDoMumuzinho);

        assertEquals(3, listaEstrategica.size());
        assertTrue(listaEstrategica.contains(en1));
        assertFalse(listaEstrategica.contains(en2));
        assertFalse(listaEstrategica.contains(ev1));
    }

    @Test
    public void testarEstrategiaLittleMumuSemNenhumElfo (){
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();

        List <Elfo> listaEstrategica = estrategia.getOrdemDeAtaque(new ArrayList<Elfo>());

        assertEquals(0, listaEstrategica.size());
    }

    @Test
    public void testarEstrategiaLittleMumuComElfoNormal (){
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        ElfoVerde ev1 = new ElfoVerde ("Verde 1", 0);          
        ElfoVerde ev2 = new ElfoVerde ("Verde 2", 40);
        ElfoVerde ev3 = new ElfoVerde ("Verde 3", 50);
        ElfoNoturno en1 = new ElfoNoturno ("Noturno 1", 3);
        ElfoNoturno en2 = new ElfoNoturno ("Noturno 2", 12);
        Elfo elfo = new Elfo ("asd");
        List <Elfo> elfosDoMumuzinho = new ArrayList <Elfo>();
        elfosDoMumuzinho.add(ev1);
        elfosDoMumuzinho.add(ev2);
        elfosDoMumuzinho.add(ev3);
        elfosDoMumuzinho.add(en1);
        elfosDoMumuzinho.add(en2);
        elfosDoMumuzinho.add(elfo);

        List <Elfo> listaEstrategica = estrategia.getOrdemDeAtaque(elfosDoMumuzinho);

        assertFalse(listaEstrategica.contains(elfo));
        assertEquals(3, listaEstrategica.size());
        assertTrue(listaEstrategica.contains(en1));
        assertFalse(listaEstrategica.contains(en2));
        assertFalse(listaEstrategica.contains(ev1));
    }

    @Test
    public void testarElfosOrdenadosDeAcordoComAQuantidadeDeFlechas (){
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        ElfoVerde ev1 = new ElfoVerde ("Verde 1", 0);          
        ElfoVerde ev2 = new ElfoVerde ("Verde 2", 40);
        ElfoVerde ev3 = new ElfoVerde ("Verde 3", 50);
        ElfoNoturno en1 = new ElfoNoturno ("Noturno 1", 3);
        ElfoNoturno en2 = new ElfoNoturno ("Noturno 2", 12);
        List <Elfo> elfosDoMumuzinho = new ArrayList <Elfo>();
        elfosDoMumuzinho.add(ev1);
        elfosDoMumuzinho.add(ev2);
        elfosDoMumuzinho.add(ev3);
        elfosDoMumuzinho.add(en1);
        elfosDoMumuzinho.add(en2);

        List <Elfo> listaEstrategica = estrategia.getOrdemDeAtaque(elfosDoMumuzinho);

        assertEquals(ev3, listaEstrategica.get(0));
        assertEquals(ev2, listaEstrategica.get(1));
        assertEquals(en1, listaEstrategica.get(2));

    }
}
