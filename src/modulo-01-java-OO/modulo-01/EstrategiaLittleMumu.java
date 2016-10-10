import java.util.*;

public class EstrategiaLittleMumu implements Estrategia{

    public List <Elfo> getOrdemDeAtaque (List <Elfo> atacantes){
        List <Elfo> listaDosElfosVivosEComFlechas = filtrarElfosVivosEComFlechas (atacantes);
        List <Elfo> listaDeElfosOrganizados = new ArrayList<Elfo>();

        int quantidadeTotalDeElfos = listaDosElfosVivosEComFlechas.size();
        int quantidadeDeElfosNoturnosPermitida = (int)(quantidadeTotalDeElfos * 0.3);

        for (int i = 0; i < quantidadeTotalDeElfos; i ++){
            Elfo elfo = listaDosElfosVivosEComFlechas.get(i);
            if (elfo instanceof ElfoNoturno && quantidadeDeElfosNoturnosPermitida > 0){
                quantidadeDeElfosNoturnosPermitida--;
                listaDeElfosOrganizados.add(elfo);
            } else if (elfo instanceof ElfoVerde) {
                listaDeElfosOrganizados.add(elfo);
            }
        }

        boolean continuaTrocandoPosicoes;

        do {
            continuaTrocandoPosicoes = false;
            for (int i = 0; i < listaDeElfosOrganizados.size() - 1; i++){
                Elfo elfoASerComparado = listaDeElfosOrganizados.get(i);
                Elfo proximoElfo = listaDeElfosOrganizados.get(i+1);

                boolean precisaTrocarPosicao = elfoASerComparado.getFlecha().getQuantidade() < proximoElfo.getFlecha().getQuantidade();

                if (precisaTrocarPosicao){
                    listaDeElfosOrganizados.set(i, proximoElfo);
                    listaDeElfosOrganizados.set(i+1, elfoASerComparado);
                    continuaTrocandoPosicoes = true;
                }
            }
        } while (continuaTrocandoPosicoes);

        return listaDeElfosOrganizados;
    }

    private List <Elfo> filtrarElfosVivosEComFlechas (List <Elfo> atacantes){
        List <Elfo> listaDosElfosVivosEComFlechas = new ArrayList<Elfo>();

        for (int i = 0; i < atacantes.size(); i++){
            Elfo elfo = atacantes.get(i);
            if (elfo.getStatus() == Status.VIVO && elfo.getFlecha().getQuantidade() > 0){
                listaDosElfosVivosEComFlechas.add(elfo);
            }
        }

        return listaDosElfosVivosEComFlechas;
    }

}
