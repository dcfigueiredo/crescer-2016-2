import java.util.ArrayList;

public class ExercitoDeElfos{
    
    private ArrayList <Elfo> exercito = new ArrayList<>();

    public Elfo buscarElfoPeloNome(String nomeDoElfo){
        for (int i = 0; i < exercito.size(); i ++){            
            Elfo e = exercito.get(i);
            if (e instanceof ElfoNoturno && nomeDoElfo.equals(e.getNome())){
                return (ElfoNoturno)e;
            } else if (e instanceof ElfoVerde && nomeDoElfo.equals(e.getNome())){
                return (ElfoVerde)e;
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
