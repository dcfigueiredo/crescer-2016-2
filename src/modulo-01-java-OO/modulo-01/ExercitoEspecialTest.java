import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoEspecialTest{
    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void testarAlistarElfoNoturno (){
        ExercitoEspecial exercito = new ExercitoEspecial ();

        ElfoNoturno en = new ElfoNoturno ("asd");        
        exercito.alistarElfo(en);
        Elfo e[] = exercito.getContingente();
        assertEquals(en, e[0]);
    }

    @Test
    public void testarAlistarElfoVerde (){
        ExercitoEspecial exercito = new ExercitoEspecial ();

        ElfoVerde ev = new ElfoVerde ("ThisIsARandomElfoVerdeNameJustForGanharDinheiroTestando");        
        exercito.alistarElfo(ev);
        Elfo e[] = exercito.getContingente();
        assertEquals(1, e.length);
    }

    @Test
    public void testarAlistarElfosDeDoisTipos (){
        ExercitoEspecial exercito = new ExercitoEspecial ();

        ElfoVerde ev = new ElfoVerde ("ThisIsARandomElfoVerdeNameJustForGanharDinheiroTestando");  
        ElfoNoturno en = new ElfoNoturno ("ThisIsAlsoFor$$$");
        exercito.alistarElfo(ev);
        exercito.alistarElfo(en);
        Elfo e[] = exercito.getContingente();
        assertEquals (2, e.length);
    }

    @Test
    public void testarAlistar2ElfosNormaisE3ElfosEspeciais (){
        ExercitoEspecial exercito = new ExercitoEspecial ();

        ElfoVerde ev1 = new ElfoVerde ("ThisIsARandomElfoVerdeNameJustForGanharDinheiroTestando");  
        ElfoNoturno en1 = new ElfoNoturno ("ThisIsAlsoFor$$$");
        Elfo e1 = new Elfo ("adsd");
        Elfo e2= new Elfo ("asasdsadsad");
        ElfoNoturno en2 = new ElfoNoturno("!@#$%¨&*");
        exercito.alistarElfo(ev1);
        exercito.alistarElfo(en1);
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(en2);
        Elfo e[] = exercito.getContingente();
        assertEquals (3, e.length);
    }
}
