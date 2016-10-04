public class Dwarf extends Personagem{
    protected int vida = 110;
    protected DataTerceiraEra dataNascimento;

    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
        this.vida = 110;
    }

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.dataNascimento = dataNascimento;
    }

    public void tiraVida (){
        double numeroSorte = getNumeroSorte();
        boolean estaVivo = status == Status.VIVO ? true : false;

        if (estaVivo){
            if (numeroSorte < 0 )
                experiencia += 2;
            if (numeroSorte > 100){
                this.vida = this.vida-10;            
                if (this.vida <=0){
                    this.vida = 0;
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

    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333.0;
        if (temSorte){
            mochila.aumentarMilUnidades();
        }
    }

    public DataTerceiraEra getDataNascimento (){
        return dataNascimento;
    }

    public int getVida(){
        return vida;
    }
}