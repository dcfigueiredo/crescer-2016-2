import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }

    @Test
    public void elfoNasceComFlechas() {
        // Act
        Elfo elfoDoTeste = new Elfo("asd");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoAtiraTodasFlechas() {
        // Act
        Elfo elfoDoTeste = new Elfo("asd");
        // Assert
        while (elfoDoTeste.getFlecha().getQuantidade() > 0) {
            elfoDoTeste.atirarFlecha();
        }
    }

    @Test
    public void elfoAtiraDuasFlechas() {
        // Act
        Elfo elfoDoTeste = new Elfo("asd");
        // Assert
        while (elfoDoTeste.getFlecha().getQuantidade() > 0) {
            elfoDoTeste.atirarFlecha();
            elfoDoTeste.atirarFlecha();
        }
    }
}