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

    //TO-DO: Concertar esse método pegando as flechas da mochila.
    public void atirarFlecha(Dwarf dwarf) {
        if (flecha.getQuantidade() > 0 ){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            dwarf.tiraVida();
            experiencia++;
        }
    }
    //TO-DO: Concertar esse método pegando as flechas da mochila.
    public String toString(){
        boolean flechaNoSingular = flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            nome,
            flecha.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
        //return nome + " possui " + flecha.getQuantidade() + " e " + experiencia + " níveis de experiência.";
    }
    
    public Status getStatus(){
        return status;
    }
}

/*public void atirarFlechaRefactory() {
experiencia++;
flecha.setQuantidade(flecha.getQuantidade()-1);
}*/

