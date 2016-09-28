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
    public void elfoNasceCom42Flechas() {
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
        while (elfoDoTeste.getFlecha().getQuantidade() > 0) {
            elfoDoTeste.atirarFlecha();
        }
        // Assert
        assertEquals (0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals (42, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoAtiraDuasFlechas() {
        // Act
        Elfo elfoDoTeste = new Elfo("asd");
        elfoDoTeste.atirarFlecha();
        elfoDoTeste.atirarFlecha();
        // Assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoTemFlechasNegativas() {
        // Act
        Elfo elfoDoTeste = new Elfo("asd");
        while (elfoDoTeste.getFlecha().getQuantidade() > 0) {
            elfoDoTeste.atirarFlecha();
            elfoDoTeste.atirarFlecha();
            elfoDoTeste.atirarFlecha();
            elfoDoTeste.atirarFlecha();
        }
        // Assert
        assertEquals (0, elfoDoTeste.getFlecha().getQuantidade());
    }
}