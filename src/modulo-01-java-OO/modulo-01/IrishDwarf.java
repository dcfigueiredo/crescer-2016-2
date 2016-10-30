<<<<<<< HEAD
public class IrishDwarf extends Dwarf{

    public IrishDwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf (String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }

    //TO-DO: Procurar melhoria.
    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333.0;
        if (temSorte){
            for (int i = 0; i < getMochila().getArrayList().size(); i ++){
                int quantidadeDeItens = getMochila().getArrayList().get(i).getQuantidade();
                int somaDeValores = 0;
                for (int j = 0; j <= Math.abs(quantidadeDeItens); j ++){
                    somaDeValores += j;
                }
                getMochila().getArrayList().get(i).setQuantidade((somaDeValores * 1000) + quantidadeDeItens);
            }
        }
    }   
}
=======
public class IrishDwarf extends Dwarf {

    public IrishDwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome, dataNascimento);
    }
    
    public void tentarSorte() {
        boolean temSorte = getNumeroSorte() == -3333;
        if (temSorte) {
            inventario.aumentarUnidadesProporcionalQuantidadePorItem();
        }
    }
}
>>>>>>> master
