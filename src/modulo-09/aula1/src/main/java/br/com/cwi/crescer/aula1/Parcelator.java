package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author daniel.figueiredo
 */
public class Parcelator {    
    public void parcelar(float valor, float taxa, int numeroParcelas, String dataVencimento) {

        float parcela = valor / numeroParcelas;
        parcela += parcela / taxa;

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            Date data = sdf.parse(dataVencimento);
            calendar.setTime(data);
        } catch (Exception ex) {
            System.out.println("Formato invalido de data " + ex);
        }                
        for (int i = 0; i < numeroParcelas; i++) {            
            System.out.print(calendar.get(Calendar.DATE) +
                    "/" + (calendar.get(Calendar.MONTH)+1) +
                    "/" + calendar.get(Calendar.YEAR)+
                    " - R$ " + parcela + "\n");
            calendar.add(Calendar.MONTH, 1);
        }
    }
}
