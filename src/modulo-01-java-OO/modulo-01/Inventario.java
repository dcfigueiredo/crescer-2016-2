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
    //TO-DO Melhorar legibilidade	
    public Item itemComMaiorQuantidade(){
        int maiorQuantidade = 0;
        Item item = new Item ("asd", 0); //TO-DO arrumar essa gambiarra	
        for (int i = 0; i < itens.size(); i++){
            if (maiorQuantidade < itens.get(i).getQuantidade()){
                maiorQuantidade = itens.get(i).getQuantidade();
                item = itens.get(i);
            }
        }
        return item;
    }
    
    public void ordentarItens(){
        Item itemASerComparado;
        for (int i = 0; i < itens.size(); i++){
            itemASerComparado = itens.get(i);
            for (int j = i + 1; j < itens.size(); j++){
                if (itemASerComparado.getQuantidade() > itens.get(j).getQuantidade()){
                    itens.set(i, itens.get(j));
                    itens.set(j, itemASerComparado);
                    break;
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}