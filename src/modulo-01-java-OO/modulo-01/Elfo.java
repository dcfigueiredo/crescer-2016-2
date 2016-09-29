public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String nome) {
        this(nome,42);
    }

    public Elfo (String nome, int quantidade){
        this.nome = nome;
        arco = new Item ("Arco", 1);
        flecha = new Item ("Flechas", quantidade >=0 ? quantidade : 42 );
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getFlecha(){
        return flecha;
    }

    public int getExperiencia (){
        return experiencia;
    }

    public Item getArco() {
        return arco;
    }

    public void atirarFlecha(Dwarf dwarf) {
        if (flecha.getQuantidade() > 0 ){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            dwarf.tiraVida();
            experiencia++;
        }
    }

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
}

/*public void atirarFlechaRefactory() {
experiencia++;
flecha.setQuantidade(flecha.getQuantidade()-1);
}*/

