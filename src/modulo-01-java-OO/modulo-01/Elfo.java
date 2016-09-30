public class Elfo {
    private String nome;
    //private Item arco;
    //private Item flecha;
    private int experiencia;
    private Status status;
    private Inventario mochila;
    public Elfo(String nome) {
        this(nome,42);
    }

    public Elfo (String nome, int quantidade){
        this.nome = nome;
        mochila.adicionarItem(new Item ("Arco", 1));
        mochila.adicionarItem (new Item ("Flechas", quantidade >=0 ? quantidade : 42 ));
        status = Status.VIVO;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public int getExperiencia (){
        return experiencia;
    }

    //TO-DO: Melhorar legibilidade e repetição de código
    public void atirarFlecha(Dwarf dwarf) {
        if (mochila.getArrayList().get(1).getQuantidade() > 0 ){
            mochila.getArrayList().get(1).setQuantidade((mochila.getArrayList().get(1).getQuantidade() - 1));
            dwarf.tiraVida();
            experiencia++;
        }
    }
    //TO-DO: Melhorar legibilidade e repetição de código
    public String toString(){
        boolean flechaNoSingular = getFlecha().getQuantidade() == 1;
        boolean experienciaNoSingular = experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            nome,
            mochila.getArrayList().get(1).getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
        //return nome + " possui " + flecha.getQuantidade() + " e " + experiencia + " níveis de experiência.";
    }

    public Item getArco(){
        return this.mochila.getArrayList().get(0);
    }

    public Item getFlecha(){
        return this.mochila.getArrayList().get(1);
    }

    public Inventario getMochila(){
        return mochila;
    }

    public Status getStatus(){
        return status;
    }
}

/*public void atirarFlechaRefactory() {
experiencia++;
flecha.setQuantidade(flecha.getQuantidade()-1);
}*/

