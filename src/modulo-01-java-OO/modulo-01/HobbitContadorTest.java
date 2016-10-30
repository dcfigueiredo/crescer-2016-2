import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

<<<<<<< HEAD
public class HobbitContadorTest
{

    @Test
    public void testarDiferencaCom5Pares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18))); //270 - 90 = 180
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5))); // 180 + (20-20) = 180
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60))); // 180 + (720 - 60) = 840
        arrayDePares.add(new ArrayList<>(Arrays.asList(11, 11))); // 840 + (121 - 11) = 950
        arrayDePares.add(new ArrayList<>(Arrays.asList(11, 11))); // 950 + (120 - 11) = 1060
        
        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals (1060, diferenca);
    }

    @Test
    public void testarDiferencaCom3Pares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);

        assertEquals (840, diferenca);
=======
public class HobbitContadorTest {

    @Test
    public void calcularDiferencaTresParesNormais() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        assertEquals(840, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaComZeroEUm() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 91)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));

        HobbitContador contador = new HobbitContador();
        assertEquals(1092, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaSemDiferenca() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(19, 60)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 7)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));

        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaComParesVazio() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
>>>>>>> master
    }

}
