public class CestoDeLembas{
    private int quantidade;
    public CestoDeLembas (int q){
        quantidade = q;
    }

    public boolean divisaoDeLembas (){
        if (quantidade >=1 && quantidade <= 100){ //Essa parte ficou redundante? Já que o if de baixo só entra se for > que 3. Fiz assim pra "Fazer como o cliente mandou"
            if (quantidade > 3 && quantidade % 2 == 0){
                return true;
            }
        }
        return false;
    }
}