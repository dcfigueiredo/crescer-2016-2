public class Dwarf {
    private int vida = 110;
    private String status = "VIVO";
    private String nome;
    private DataTerceiraEra dataNascimento;
    private int experiencia;

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void tiraVida (){
        double numeroSorte = getNumeroSorte();
        if (numeroSorte < 0 )
            experiencia += 2;
        if (numeroSorte > 100)
            vida = vida -10;
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
    
    public int getExperiencia(){
        return experiencia;
    }
}