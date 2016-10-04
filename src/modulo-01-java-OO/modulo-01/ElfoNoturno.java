public class ElfoNoturno extends Elfo{

    public ElfoNoturno (String nome){
        super(nome);
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeDeFlechas = getFlecha().getQuantidade();
        if ( quantidadeDeFlechas > 0 && status == Status.VIVO){
            mochila.getArrayList().get(1).setQuantidade(quantidadeDeFlechas - 1);
            dwarf.tiraVida();
            tiraVidaAtirandoFlecha();
            experiencia+=3;
        }
    }
    //TO-DO: Criar teste para ver se está morrendo.
    private void tiraVidaAtirandoFlecha (){
        vida = vida - (vida * 0.05);
        if (vida < 1){
            status = Status.MORTO;
        }
    }
    //Os elfos noturnos não podem morrer atualmente pois o cliente 
    //ainda não pediu pra fazer isso... Sua vinda nunca chega a zero

    public double getVida(){
        return vida;
    }
}
