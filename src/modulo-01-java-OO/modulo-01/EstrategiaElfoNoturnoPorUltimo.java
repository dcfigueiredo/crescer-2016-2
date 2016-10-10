import java.util.*;

public class EstrategiaElfoNoturnoPorUltimo implements Estrategia{
    public List<Elfo> getOrdemDeAtaque(List <Elfo> atacantes){
        List <Elfo> listaDosVivos = filtrarElfosVivos(atacantes);        
        List <Elfo> listaDosElfosNaOrdemCerta = new ArrayList<Elfo>();
        
        for (int i = 0; i < listaDosVivos.size(); i++){
            Elfo elfo = listaDosVivos.get(i);
            if (elfo instanceof ElfoVerde){
                listaDosElfosNaOrdemCerta.add(0, elfo);
            } else if (elfo instanceof ElfoNoturno){
                listaDosElfosNaOrdemCerta.add(elfo);
            }
        }
        
        return listaDosElfosNaOrdemCerta;
    }

    private List <Elfo> filtrarElfosVivos(List<Elfo> atacantes){
        List <Elfo> listaDosVivos = new ArrayList<Elfo>();

        for (int i = 0; i < atacantes.size();i ++){
            Elfo elfo = atacantes.get(i);
            if (elfo.getStatus() == Status.VIVO){
                listaDosVivos.add(elfo);
            }
        }
        
        return listaDosVivos;
    }
}
