public class Item {
    private String descricao;
    private int quantidade;

    //TO-DO: Repetição de código no constructors
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    public Item(int quantidade, String descricao) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
<<<<<<< HEAD

=======
    
    public void aumentarUnidades(int unidades) {
        quantidade += unidades;
    }
    
>>>>>>> master
    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void aumentarProporcionalQuantidade() {
        /*int resultado = 0;
        for (int i = 1; i <= this.quantidade; i++) {
        resultado += i;
        }*/
        // Usando PA:
        int quantidadeAbsoluta = Math.abs(this.quantidade);
        int resultado = quantidadeAbsoluta * (quantidadeAbsoluta + 1) / 2;
        this.quantidade += (resultado * 1000);
    }
    
    @Override
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return
            this.descricao.equals(outro.descricao) &&
            this.quantidade == outro.quantidade;
    }
}




