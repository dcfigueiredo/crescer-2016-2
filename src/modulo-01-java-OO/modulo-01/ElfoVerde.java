public class ElfoVerde extends Elfo{    

    //TO-DO: Pesquisar pq tenho que chamar o construtor da super.
    public ElfoVerde (String nome, int quantidade){
        super(nome, quantidade);   
        this.mochila.getArrayList().set(0, new Item ("Espada de aço valiriano", 1));
        this.mochila.getArrayList().set(1, new Item ("Arco e Flecha de Vidro", quantidade));
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
