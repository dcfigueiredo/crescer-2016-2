public class ElfoVerde extends Elfo{    
    
    public ElfoVerde (String nome){
        super(nome);
    }

    public ElfoVerde (String nome, int quantidade){
        super(nome, quantidade);   
    }
    
    @Override
    public void inicializarInventario(int quantidade){
        this.mochila.adicionarItem(new Item("Espada de aço valiriano", 1));
        this.mochila.adicionarItem(new Item("Arco e Flecha de Vidro", quantidade));
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeDeFlechas = getFlecha().getQuantidade();
        if ( quantidadeDeFlechas > 0 ){
            mochila.getArrayList().get(1).setQuantidade(quantidadeDeFlechas - 1);
            dwarf.tiraVida();
            experiencia += 2;
        }
    }

    public void adicionarItem(Item item){
        boolean descricaoCerta = "Espada de aço valiriano".equals(item.getDescricao()) || 
            "Arco e Flecha de Vidro".equals(item.getDescricao());
        if (descricaoCerta){
            this.mochila.adicionarItem(item);
        }
    }

}
