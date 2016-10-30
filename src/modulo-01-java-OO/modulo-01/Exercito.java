<<<<<<< HEAD
import java.util.ArrayList;
public interface Exercito{	
    
    Elfo [] getContingente();

    void alistarElfo (Elfo elfo);

    Elfo buscar (String nome);

    ArrayList<Elfo> buscar (Status status);
=======
import java.util.List;

public interface Exercito {
    Elfo[] getContingente();
    void alistar(Elfo elfo) throws NaoPodeAlistarException;
    Elfo buscar(String nome);
    List<Elfo> buscar(Status status);
    void atacar();
>>>>>>> master
}
