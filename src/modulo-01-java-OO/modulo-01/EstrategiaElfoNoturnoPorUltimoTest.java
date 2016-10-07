import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaElfoNoturnoPorUltimoTest{
    @Test
    public void testarOrdenarAtaqueComElfosNoturnosPorUltimoAdicionandoElfosIntercalados(){
        EstrategiaElfoNoturnoPorUltimo estrategia = new EstrategiaElfoNoturnoPorUltimo ();
        ElfoNoturno en1 = new ElfoNoturno ("ElfinhoOfTheNiguiti");
        ElfoNoturno en2 = new ElfoNoturno ("xXxElfinhoOfTheNiguitixXx");
        ElfoNoturno en3 = new ElfoNoturno ("---ElfinhoOfTheNiguiti---");
        ElfoVerde ev1 = new ElfoVerde ("ElfinhoOfTheGrin");
        ElfoVerde ev2 = new ElfoVerde ("xXxElfinhoOfTheGrinxXx");
        ElfoVerde ev3 = new ElfoVerde ("---ElfinhoOfTheGrin---");
        List <Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.add(en1);
        listaDeElfos.add(ev1);
        listaDeElfos.add(en2);
        listaDeElfos.add(ev2);
        listaDeElfos.add(en3);
        listaDeElfos.add(ev3);
        ArrayList <Elfo> listaDeElfosOrdenados = (ArrayList) estrategia.getOrdemDeAtaque(listaDeElfos);

        assertEquals(en1, listaDeElfosOrdenados.get(3));
        assertEquals(en2, listaDeElfosOrdenados.get(4));
        assertEquals(en3, listaDeElfosOrdenados.get(5));
    }

    @Test
    public void testarOrdenarAtaqueComElfosNoturnosPorUltimoAdicionando1ElfoMorto(){
        EstrategiaElfoNoturnoPorUltimo estrategia = new EstrategiaElfoNoturnoPorUltimo ();
        ElfoNoturno en1 = new ElfoNoturno ("ElfinhoOfTheNiguiti", 91);
        matarElfo(en1);
        ElfoNoturno en2 = new ElfoNoturno ("xXxElfinhoOfTheNiguitixXx");
        ElfoNoturno en3 = new ElfoNoturno ("---ElfinhoOfTheNiguiti---");
        ElfoVerde ev1 = new ElfoVerde ("ElfinhoOfTheGrin");
        ElfoVerde ev2 = new ElfoVerde ("xXxElfinhoOfTheGrinxXx");
        ElfoVerde ev3 = new ElfoVerde ("---ElfinhoOfTheGrin---");
        List <Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.add(en1);
        listaDeElfos.add(ev1);
        listaDeElfos.add(en2);
        listaDeElfos.add(ev2);
        listaDeElfos.add(en3);
        listaDeElfos.add(ev3);
        ArrayList <Elfo> listaDeElfosOrdenados = (ArrayList) estrategia.getOrdemDeAtaque(listaDeElfos);

        assertEquals(5, listaDeElfosOrdenados.size());
        
    }

    private void matarElfo(ElfoNoturno e){
        while(e.getStatus() == Status.VIVO){
            e.atirarFlecha(new Dwarf("ASD"));
        }
    }
}
