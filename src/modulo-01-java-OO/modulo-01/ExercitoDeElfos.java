import java.util.ArrayList;
public abstract class ExercitoDeElfos{
    private ArrayList <Elfo> exercito = new ArrayList<>();

    public Elfo buscarElfoPeloNome(String nomeDoElfo){
        for (int i = 0; i < exercito.size(); i ++){            
            Elfo e = exercito.get(i);
            if (nomeDoElfo.equals(((ElfoNoturno)e).getNome())){
                return (ElfoNoturno)e;
            } else if (nomeDoElfo.equals(((ElfoVerde)e).getNome())){
                return (ElfoVerde)e;
            }
        }

        return null;
    }

    public void alistarElfo (ElfoNoturno elfo){ // This is a temporary gambi
        exercito.add(elfo);
    }

    public void alistarElfo (ElfoVerde elfo){ //This is a temporary gambi
        exercito.add(elfo);
    }

}
