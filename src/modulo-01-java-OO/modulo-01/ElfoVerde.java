<<<<<<< HEAD
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

=======
import java.util.*;

public class ElfoVerde extends Elfo {

    public ElfoVerde(String nome) {
        super(nome);
    }

    public ElfoVerde(String nome, int quantidadeFlechas) {
        super(nome, quantidadeFlechas);
    }

    @Override
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlechas(dwarf, 2);
    }

    @Override
    protected void inicializarInventario(int quantidadeFlechas) {
        this.adicionarItem(new Item("Arco de Vidro", 1));
        this.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void adicionarItem(Item item) {        
        String[] validas = getNomesValidos();
        boolean podeAdicionar = item != null && new ArrayList<>(Arrays.asList(validas)).contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }

    private String[] getNomesValidos() {
        return new String[] { 
            "Espada de aço valiriano", 
            "Arco de Vidro",
            "Flecha de Vidro"
        };
    }
>>>>>>> master
}
