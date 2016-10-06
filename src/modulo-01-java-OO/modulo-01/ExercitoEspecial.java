import java.util.*;
public class ExercitoEspecial{
    
    private HashMap <String,Elfo> exercito = new HashMap();

    public void alistarElfo (Elfo elfo){
        if (!(elfo instanceof Elfo)){
            this.exercito.put(elfo.getNome(), elfo);

        }
    }   

    public Elfo[] getContingente (){
        Elfo e[] = new Elfo[exercito.size()];
        e = exercito.values().toArray(e);
        return e;
    }

    public Elfo buscar(String nome){
        if (exercito.containsKey(nome)){
            return exercito.get(nome);
        }
        return null;
    }

    public ArrayList<Elfo> buscar (Status status){
        ArrayList <Elfo> arrayDeElfos = new ArrayList();   
        for (Elfo value : exercito.values()) {
            if (value.getStatus() == status){
                arrayDeElfos.add(value);
            }
        }

        return arrayDeElfos;
    }
}