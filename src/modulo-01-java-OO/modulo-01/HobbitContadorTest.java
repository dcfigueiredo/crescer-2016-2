import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void testarDiferencaCom3Pares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals (840, diferenca);
    }

    @Test
    public void testarDiferencaCom5Pares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18))); //270 - 90 = 180
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5))); // 180 + (20-20) = 180
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60))); // 180 + (720 - 60) = 840
        arrayDePares.add(new ArrayList<>(Arrays.asList(11, 11))); // 840 + (121 - 11) = 950
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 50))); //950 + (650 - 1) = 301

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals (301, diferenca);
    }
}
