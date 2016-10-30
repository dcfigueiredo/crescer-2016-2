<<<<<<< HEAD
import java.util.ArrayList;

public class HobbitContador{

    //TO-DO: Revisar código e separar em métodos diferentes para retornar mmc e retornar o produto do array para melhorar legibilidade. Mudar nome das variaveis.
    public int calcularDiferenca(ArrayList <ArrayList<Integer>> arrayDePares){
        ArrayList <Integer> arrayDeProdutos = new ArrayList<>();
        ArrayList <Integer> arrayDeMMCs = new ArrayList<>();
        int diferenca = 0;

        for (int i = 0; i < arrayDePares.size(); i++){
            for (int j = 0; j < arrayDePares.get(i).size(); j ++){
                
                int numeroASerMultiplicado1 = arrayDePares.get(i).get(j);
                int numeroASerMultiplicado2 = arrayDePares.get(i).get(j+1);
                arrayDeProdutos.add(numeroASerMultiplicado1*numeroASerMultiplicado2);

                int resto = 1;
                while (resto!=0){
                    resto = numeroASerMultiplicado1 % numeroASerMultiplicado2;
                    numeroASerMultiplicado1 = numeroASerMultiplicado2;
                    numeroASerMultiplicado2 = resto;
                }
                
                arrayDeMMCs.add((arrayDePares.get(i).get(j)*arrayDePares.get(i).get(++j)/numeroASerMultiplicado1));
                diferenca += arrayDeProdutos.get(i) - arrayDeMMCs.get(i);
            }
        }
        
        /*int diferenca = 0;        
        
        for (int i = 0; i < arrayDePares.get(i).size(); i ++){
            diferenca += arrayDeProdutos.get(i) - arrayDeMMCs.get(i);
        }*/
        return diferenca;
    }
}
=======
import java.util.*;

public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> pares) {
        int somaProdutos = 0, somaMmc = 0;

        for (ArrayList<Integer> par : pares) {
            int a = par.get(0), b = par.get(1);
            somaProdutos += a * b;
            somaMmc += new CalculadorMmc(a, b).calcular();
        }
        
        // Fluent APIs
        // crieUmHobbit().depoisCalculeMmc().depoisEnviePorEmail();

        return somaProdutos - somaMmc;
    }

    private class CalculadorMmc {
        private int a, b, mdc;
        private CalculadorMmc(int a, int b) {
            this.a = a;
            this.b = b;
            this.mdc = mdc(a, b);
        }

        // https://en.wikipedia.org/wiki/Least_common_multiple
        private int calcular() {
            boolean temZero = a == 0 || b == 0;
            return temZero ? 0 : a * b / mdc;
        }

        // https://en.wikipedia.org/wiki/Greatest_common_divisor
        private int mdc(int a, int b) {
            while (b != 0) {
                int troca = b;
                b = a % b;
                a = troca;
            }
            return a;
        }
    }
}
>>>>>>> master
