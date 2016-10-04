public class ElfoVerde extends Elfo{    
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public void adicionarItem(Item item){
        boolean descricaoCerta = "Espada de aço valiriano".equals(item.getDescricao()) || 
        "Arco e Flecha de Vidro".equals(item.getDescricao());
        if (descricaoCerta){
            this.mochila.adicionarItem(item);
        }
    }
    
}
