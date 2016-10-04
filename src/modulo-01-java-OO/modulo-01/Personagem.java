public class Personagem{
    protected String nome;
    protected Inventario mochila = new Inventario();
    protected Status status;
    protected int experiencia;
    protected double vida;

    public Personagem (String nome){
        this.nome = nome;
        this.status = Status.VIVO;

    }

    public void adicionarItem(Item item){
        this.mochila.adicionarItem(item);
    }

    public void removerItem (Item item){
        this.mochila.removerItem(item);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public Inventario getMochila(){
        return this.mochila;
    }

    public Status getStatus (){
        return status;
    }
}