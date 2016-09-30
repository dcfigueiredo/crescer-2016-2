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
    
    public String getDescricaoDeTodosOsItens(){
        String descricao = "";
        for (int i = 0; i < itens.size(); i++){
            descricao += itens.get(i).getDescricao() + "," ;
        }
        return descricao.substring(0, descricao.length() -1);
    }
    
    //TO-DO CRIAR TESTES!
    public void aumentarMilUnidades(){
        for (Item itens : itens){
            itens.setQuantidade(itens.getQuantidade() + 1000);
        }
    }
}