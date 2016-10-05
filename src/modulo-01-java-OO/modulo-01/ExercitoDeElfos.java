import java.util.ArrayList;

public class ExercitoDeElfos{

    private ArrayList <Elfo> exercito = new ArrayList<>();

    public Elfo buscarElfoPeloNome(String nomeDoElfo){
        for (int i = 0; i < exercito.size(); i ++){            
            Elfo e = exercito.get(i);
            if (nomeDoElfo.equals(e.getNome())){             
                return e;
            }
        }    
        return null;
    }

    public void alistarElfo (Elfo elfo){
        if (elfo instanceof ElfoNoturno){
            exercito.add((ElfoNoturno)elfo);
        } else if (elfo instanceof ElfoVerde){
            exercito.add((ElfoVerde)elfo);
        }
    }       
}
