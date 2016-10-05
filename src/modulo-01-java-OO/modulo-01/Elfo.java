public class Elfo extends Personagem{
    private static int censoDeElfos = 0;
    
    public Elfo(String nome) {
        this(nome,42);
    }

    public Elfo (String nome, int quantidadeDeFlechas){
        super(nome);        
        this.vida = 100;
        inicializarInventario(quantidadeDeFlechas);
        Elfo.censoDeElfos++;
    }    
    
    public static int getCensoDeElfos(){
        return Elfo.censoDeElfos;
    }
    
    public void inicializarInventario(int quantidadeDeFlechas){
        mochila.adicionarItem(new Item ("Arco", 1));
        mochila.adicionarItem (new Item ("Flechas", quantidadeDeFlechas >=0 ? quantidadeDeFlechas : 42 ));
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeDeFlechas = getFlecha().getQuantidade();
        if ( quantidadeDeFlechas > 0 ){
            mochila.getArrayList().get(1).setQuantidade(quantidadeDeFlechas - 1);
            dwarf.tiraVida();
            experiencia++;
        }
    }

    public String toString(){
        int quantidadeDeFlechas = getFlecha().getQuantidade();
        boolean flechaNoSingular = quantidadeDeFlechas == 1;
        boolean experienciaNoSingular = experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            nome,
            quantidadeDeFlechas,
            flechaNoSingular ? "flecha" : "flechas",
            experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
        //return nome + " possui " + flecha.getQuantidade() + " e " + experiencia + " níveis de experiência.";
    }

    protected void finalize () throws Throwable{
        super.finalize();
        censoDeElfos --;
    }
    
    public Item getArco(){
        return this.mochila.getArrayList().get(0);
    }

    public Item getFlecha(){
        return this.mochila.getArrayList().get(1);
    }
}

/*public void atirarFlechaRefactory() {
experiencia++;
flecha.setQuantidade(flecha.getQuantidade()-1);
}*/

