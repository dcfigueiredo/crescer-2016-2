import java.util.ArrayList;
public interface Exercito{	
    
    Elfo [] getContingente();

    void alistarElfo (Elfo elfo);

    Elfo buscar (String nome);

    ArrayList<Elfo> buscar (Status status);
}
