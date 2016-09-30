import java.util.ArrayList;

public class Inventario{
    private ArrayList <Item> itens = new ArrayList<>();
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    public void removerItem(Item item){
        this.itens.remove(item);
    }
    
    //TO-DO: Pesquisar se tem uma maneira melhor de acessar a lista.
    public ArrayList<Item> getArrayList (){
        return itens;
    }
    
    //TO-DO: Adicionar testes na classe Elfo e Dwarf;
    public String getDescricoesItens(){
        String descricao = "";
        for (int i = 0; i < itens.size(); i++){
            descricao += itens.get(i).getDescricao() + "," ;
        }
        return descricao;
    }
    
    //TO-DO CRIAR TESTES!
    public void aumentaMilUnidades(){
        for (Item itens : itens){
            itens.setQuantidade(itens.getQuantidade() + 1000);
        }
    }
}