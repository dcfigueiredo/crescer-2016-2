import java.util.ArrayList;

public class Inventario{
    private ArrayList <Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        this.itens.add(item);
    }

    public void removerItem(Item item){
        this.itens.remove(item);
    }

    public ArrayList<Item> getArrayList (){
        return itens;
    }

    public String getDescricaoDeTodosOsItens(){
        String descricao = "";
        for (int i = 0; i < itens.size(); i++){
            descricao += itens.get(i).getDescricao() + "," ;
        }
        return descricao.substring(0, descricao.length() -1);
    }

    public void aumentarMilUnidades(){
        for (Item itens : itens){
            itens.setQuantidade(itens.getQuantidade() + 1000);
        }
    }

    public Item itemComMaiorQuantidade(){
        int maiorQuantidade = 0;
        Item item = new Item ("", 0);
        for (int i = 0; i < itens.size(); i++){
            if (maiorQuantidade < itens.get(i).getQuantidade()){
                maiorQuantidade = itens.get(i).getQuantidade();
                item = itens.get(i);
            }
        }
        return item;
    }

    public void ordenarItens() { 
        ordenarItens(TipoOrdenacao.ASCENDENTE); 
    } 

    public void ordenarItens(TipoOrdenacao ordenar){
       boolean continuaTrocandoPosicoes;
       boolean ascendente = ordenar == TipoOrdenacao.ASCENDENTE;
       do {
           continuaTrocandoPosicoes = false;
           for (int i = 0; i < itens.size() - 1; i++){
               Item itemASerComparado = itens.get(i);
               Item proximoItem = itens.get(i+1);
               
               boolean precisaTrocarPosicao = ascendente ? itemASerComparado.getQuantidade() > proximoItem.getQuantidade() : itemASerComparado.getQuantidade() < proximoItem.getQuantidade(); 
               
               if (precisaTrocarPosicao){
                 itens.set(i, proximoItem);
                 itens.set(i+1, itemASerComparado);
                 continuaTrocandoPosicoes = true;
                }
            }
        } while (continuaTrocandoPosicoes);
    }

}