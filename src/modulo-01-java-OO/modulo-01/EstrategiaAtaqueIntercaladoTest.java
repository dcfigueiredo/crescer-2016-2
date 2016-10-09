import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaAtaqueIntercaladoTest{

    @Test
    public void testarOrdemDeAtaqueIntercaladaComeçandoComElfoNoturno(){
        EstrategiaAtaqueIntercalado estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList <Elfo> listaDeAtacantes = new ArrayList <Elfo>();
        List <Elfo> listaOrdenada = new ArrayList <Elfo>();

        ElfoNoturno en1 = new ElfoNoturno ("asd");
        ElfoVerde ev1 = new ElfoVerde ("asd");
        ElfoNoturno en2 = new ElfoNoturno ("asd");
        ElfoVerde ev2 = new ElfoVerde ("asd");
        ElfoNoturno en3 = new ElfoNoturno ("asd");
        ElfoVerde ev3 = new ElfoVerde ("asd");

        listaDeAtacantes.add(en1);
        listaDeAtacantes.add(en2);
        listaDeAtacantes.add(en3);
        listaDeAtacantes.add(ev1);
        listaDeAtacantes.add(ev2);
        listaDeAtacantes.add(ev3);

        try {
            listaOrdenada = estrategia.getOrdemDeAtaque(listaDeAtacantes);
        } catch (ContingenteDesproporcionalException ex){
            System.out.println ("Erro inesperado");
        }

        assertEquals(en1, listaOrdenada.get(0));
        assertEquals(ev1, listaOrdenada.get(1));
        assertEquals(en2, listaOrdenada.get(2));
        assertEquals(ev2, listaOrdenada.get(3));
        assertEquals(en3, listaOrdenada.get(4));
        assertEquals(ev3, listaOrdenada.get(5));

    }

    public void testarOrdemDeAtaqueIntercaladaComeçandoComElfoVerde(){
        EstrategiaAtaqueIntercalado estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList <Elfo> listaDeAtacantes = new ArrayList <Elfo>();
        List <Elfo> listaOrdenada = new ArrayList <Elfo>();

        ElfoNoturno en1 = new ElfoNoturno ("asd");
        ElfoVerde ev1 = new ElfoVerde ("asd");
        ElfoNoturno en2 = new ElfoNoturno ("asd");
        ElfoVerde ev2 = new ElfoVerde ("asd");
        ElfoNoturno en3 = new ElfoNoturno ("asd");
        ElfoVerde ev3 = new ElfoVerde ("asd");

        listaDeAtacantes.add(ev1);
        listaDeAtacantes.add(ev2);
        listaDeAtacantes.add(ev3);
        listaDeAtacantes.add(en1);
        listaDeAtacantes.add(en2);
        listaDeAtacantes.add(en3);

        try {
            listaOrdenada = estrategia.getOrdemDeAtaque(listaDeAtacantes);
        } catch (ContingenteDesproporcionalException ex){
            System.out.println ("Erro inesperado");
        }

        assertEquals(ev1, listaOrdenada.get(0));
        assertEquals(en1, listaOrdenada.get(1));
        assertEquals(ev2, listaOrdenada.get(2));
        assertEquals(en2, listaOrdenada.get(3));
        assertEquals(ev3, listaOrdenada.get(4));
        assertEquals(en3, listaOrdenada.get(5));

    }

    @Test (expected = ContingenteDesproporcionalException.class)
    public void testarOrdemDeAtaqueIntercaladaComElfoMorto() throws ContingenteDesproporcionalException{
        EstrategiaAtaqueIntercalado estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList <Elfo> listaDeAtacantes = new ArrayList <Elfo>();
        List <Elfo> listaOrdenada;

        ElfoNoturno en1 = new ElfoNoturno ("asd", 91);
        ElfoVerde ev1 = new ElfoVerde ("asd");
        ElfoNoturno en2 = new ElfoNoturno ("asd");
        ElfoVerde ev2 = new ElfoVerde ("asd");
        ElfoNoturno en3 = new ElfoNoturno ("asd");
        ElfoVerde ev3 = new ElfoVerde ("asd");

        matarElfo(en1);

        listaDeAtacantes.add(en1);
        listaDeAtacantes.add(en2);
        listaDeAtacantes.add(en3);
        listaDeAtacantes.add(ev1);
        listaDeAtacantes.add(ev2);
        listaDeAtacantes.add(ev3);
        try{
            listaOrdenada = estrategia.getOrdemDeAtaque(listaDeAtacantes);
        } catch (ContingenteDesproporcionalException ex){
            throw ex;
        }
    }

    @Test (expected = ContingenteDesproporcionalException.class)
    public void testarOrdemDeAtaqueIntercaladaComApenasUmTipoDeElfo() throws ContingenteDesproporcionalException{
        EstrategiaAtaqueIntercalado estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList <Elfo> listaDeAtacantes = new ArrayList <Elfo>();
        List <Elfo> listaOrdenada;

        ElfoNoturno en1 = new ElfoNoturno ("asd", 91);
        ElfoNoturno en2 = new ElfoNoturno ("asd");
        ElfoNoturno en3 = new ElfoNoturno ("asd");

        matarElfo(en1);
        listaDeAtacantes.add(en1);
        listaDeAtacantes.add(en2);
        listaDeAtacantes.add(en3);

        try{
            listaOrdenada = estrategia.getOrdemDeAtaque(listaDeAtacantes);
        } catch (ContingenteDesproporcionalException ex){
            throw ex;
        }
    }

    private void matarElfo(ElfoNoturno e){
        while(e.getStatus() == Status.VIVO){
            e.atirarFlecha(new Dwarf("ASD"));
        }
    }

}
