public class Dwarf {
    private int vida = 110;
    private String nome;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Status status;
    private Inventario mochila;
    
    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }
    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
        mochila = new Inventario();
    }
    
    public void adicionarItem(Item item){
        this.mochila.adicionarItem(item);
    }
    public void removerItem (Item item){
        this.mochila.removerItem(item);
    }
    
    public void tiraVida (){
        double numeroSorte = getNumeroSorte();
        boolean estaVivo = status == Status.VIVO ? true : false;

        if (estaVivo){
            if (numeroSorte < 0 )
                experiencia += 2;
            if (numeroSorte > 100){
                vida = vida-10;            
                if (vida <=0){
                    vida = 0;
                    status = Status.MORTO;
                }
            }
        }
    }

    public double getNumeroSorte(){
        double numeroDaSorte = 101.;
        boolean ehBissexto = dataNascimento.ehBissexto();

        if (ehBissexto && vida >= 80 && vida <= 90){
            numeroDaSorte *= -33;
        }
        if (!ehBissexto && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))){
            numeroDaSorte = (numeroDaSorte *33) % 100;
        }
        return numeroDaSorte;
    }

    public DataTerceiraEra getDataNascimento (){
        return dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public int getVida(){
        return vida;
    }

    public int getExperiencia(){
        return experiencia;
    }
    
    public Inventario getInventario(){
        return this.mochila;
    }
    
    public Status getStatus (){
        return status;
    }
}