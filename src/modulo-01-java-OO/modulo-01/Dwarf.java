public class Dwarf {
    private int vida = 110;
    private String status = "VIVO";
    public void tiraVida (){
        vida = vida -10;
        checaVida();
    }

    public void checaVida () {
        if (vida <= 0 ){
            status = "MORTO";
            vida = 0;
        }
    }

    public int getVida(){
        return vida;
    }

    public String getStatus (){
        return status;
    }
}