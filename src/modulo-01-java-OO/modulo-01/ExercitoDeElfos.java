import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito{

    private ArrayList <Elfo> exercito = new ArrayList<>();

    public Elfo buscar(String nomeDoElfo){
        for (int i = 0; i < exercito.size(); i ++){            
            Elfo e = exercito.get(i);
            if (nomeDoElfo.equals(e.getNome())){             
                return e;
            }
        }    
        return null;
    }

    public void alistarElfo (Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde;

        if (podeAlistar){
            exercito.add(elfo);
        }
    }       

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> novoArray = new ArrayList<>();

        for (int i = 0; i < exercito.size(); i++){
            Elfo elfo = exercito.get(i);
            if (status == elfo.getStatus()){
                novoArray.add(elfo);
            }
        }

        return novoArray;
    }

    public Elfo[] getContingente (){
        Elfo e[] = new Elfo [exercito.size()];
        e = exercito.toArray(e);
        return e;
    }
}



