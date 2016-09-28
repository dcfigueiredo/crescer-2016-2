import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest {

    @Test
    public void testarLembasDiviziveis (){
        //Arrange
        boolean expected = true;
        //Act
        CestoDeLembas dietLembas = new CestoDeLembas (10);
        //Assert
        assertEquals(expected, dietLembas.divisaoDeLembas());
    }

    @Test
    public void testarLembasNaoDiviziveis (){
        //Arrange
        boolean expected = false;
        //Act
        CestoDeLembas dietLembas = new CestoDeLembas (1);
        //Assert
        assertEquals(expected, dietLembas.divisaoDeLembas());
    }

    @Test
    public void testarLembasNegativas (){
        //Arrange
        boolean expected = false;
        //Act
        CestoDeLembas dietLembas = new CestoDeLembas (-5);
        //Assert
        assertEquals(expected, dietLembas.divisaoDeLembas());
    }
    
    @Test
    public void testarManyLembas (){
        //Arrange
        boolean expected = false;
        //Act
        CestoDeLembas dietLembas = new CestoDeLembas (101);
        //Assert
        assertEquals(expected, dietLembas.divisaoDeLembas());
    }
}