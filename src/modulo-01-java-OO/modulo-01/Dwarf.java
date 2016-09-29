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