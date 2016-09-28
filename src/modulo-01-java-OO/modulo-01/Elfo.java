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

    public void atirarFlecha() {
        if (flecha.getQuantidade() > 0 ){
            if (zangado.checaVida() == true){
                flecha.setQuantidade(flecha.getQuantidade() - 1);
                zangado.tiraVida();
                experiencia++;
            }
        }
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

