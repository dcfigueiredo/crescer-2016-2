public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private Dwarf zangado;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
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
        String stringDeRetorno = nome; // Inicializa o retorno com o nome do elfo.
        stringDeRetorno = stringDeRetorno + " possui " + Integer.toString(flecha.getQuantidade()) + " flechas "; // Concatena a quantidade de flechas na string retorno
        stringDeRetorno = stringDeRetorno + " e " + Integer.toString(experiencia) + " níveis de experiencia."; // Concatena a quantidade de experiencia do elfo
        return stringDeRetorno;
        //return nome + " possui " + Integer.toString(flecha.getQuantidade()) + " e " + Integer.toString(experiencia) + " níveis de experiencia.";
    }
}

/*public void atirarFlechaRefactory() {
experiencia++;
flecha.setQuantidade(flecha.getQuantidade()-1);
}*/


