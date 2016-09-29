
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest{
    @Test
    public void testaBissextoDivisivelPor400(){
        DataTerceiraEra ano2000 = new DataTerceiraEra (22,22,2000);
        assertEquals(true,ano2000.ehBissexto());
    }

    @Test
    public void testaAnoNormal(){
        DataTerceiraEra ano2000 = new DataTerceiraEra (22,22,2015);
        assertEquals(false,ano2000.ehBissexto());
    }

    @Test
    public void testaAnoNormalDivisivelPor100(){
        DataTerceiraEra ano2000 = new DataTerceiraEra (22,22,1000);
        assertEquals(false,ano2000.ehBissexto());
    }
}
