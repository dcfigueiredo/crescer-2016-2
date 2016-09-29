public class Dwarf {
    private int vida = 110;
    private String status = "VIVO";
    private String nome;
    private DataTerceiraEra dataNascimento;

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void tiraVida (){
        vida = vida -10;
        checaVida();
    }

    private void checaVida () {
        if (vida <= 0 ){
            status = "MORTO";
            vida = 0;
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

    public String getStatus (){
        return status;
    }
}