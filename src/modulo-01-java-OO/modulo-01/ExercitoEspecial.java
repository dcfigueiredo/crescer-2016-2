import java.util.HashMap;
public class ExercitoEspecial{
    private HashMap <String,Elfo> exercito = new HashMap();

    public void alistarElfo (Elfo elfo){
        if (elfo instanceof ElfoNoturno){
            exercito.put(elfo.getNome(), (ElfoNoturno)elfo);
        } else if (elfo instanceof ElfoVerde){
            exercito.put(elfo.getNome(), (ElfoVerde)elfo);
        }
    }

    public Elfo[] getContingente (){
        Elfo e[] = new Elfo[exercito.size()];
        e = exercito.values().toArray(e);
        return e;
    }
}