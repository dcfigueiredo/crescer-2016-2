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

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
}




