public class Dwarf {
    private int vida = 110;

    public void tiraVida (){
        vida = vida -10;
    }

    public boolean checaVida () {
        if (vida > 0 )
            return true;
        return false;
    }
}