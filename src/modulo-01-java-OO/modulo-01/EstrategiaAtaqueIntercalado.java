import java.util.*;
public class EstrategiaAtaqueIntercalado implements Estrategia{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContingenteDesproporcionalException{
        List <Elfo> listaDosVivos = filtrarElfosVivos(atacantes);
        List <Elfo> listaOrdenada = new ArrayList <Elfo> ();
        int quantdidadeTotalDeElfos = listaDosVivos.size();
        int quantidadeDeElfosVerdes = 0;
        int quantidadeDeElfosNoturnos = 0;
        //TO-DO: Extrair verificação para um método privado.
        try{            
            for (int i = 0; i < quantdidadeTotalDeElfos; i ++){

                if (listaDosVivos.get(i) instanceof ElfoNoturno){
                    quantidadeDeElfosNoturnos++;
                } else {
                    quantidadeDeElfosVerdes++;
                }              
            }
            if (quantidadeDeElfosVerdes != quantidadeDeElfosNoturnos || quantdidadeTotalDeElfos %2 != 0){
                throw new ContingenteDesproporcionalException();
            }
        } catch (ContingenteDesproporcionalException ex){
            throw ex;
        }
        listaOrdenada.add(listaDosVivos.get(0));
        listaDosVivos.remove(0);

        boolean adicionarElfoNoturno = listaOrdenada.get(0) instanceof ElfoNoturno ? true : false;

        do{
            if (adicionarElfoNoturno){
                for (int i = 0; i < listaDosVivos.size(); i++){
                    if (listaDosVivos.get(i) instanceof ElfoVerde){
                        listaOrdenada.add(listaDosVivos.get(i));
                        listaDosVivos.remove(i);
                        adicionarElfoNoturno = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < listaDosVivos.size(); i ++){
                    if (listaDosVivos.get(i) instanceof ElfoNoturno){
                        listaOrdenada.add(listaDosVivos.get(i));
                        listaDosVivos.remove(i);
                        adicionarElfoNoturno = true;
                        break;
                    }
                }
            }
        } while (listaOrdenada.size() < quantdidadeTotalDeElfos);

        return listaOrdenada;

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
