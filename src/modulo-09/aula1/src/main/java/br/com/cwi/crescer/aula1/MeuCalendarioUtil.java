package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class MeuCalendarioUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Data do nascimento: ");
        String data = scanner.nextLine();

        System.out.println("Dia em que nasceu: " + exibirDiaNascimento(data));
        
        System.out.print("Digite a data para a qualquer saber a diferença: ");
        data = scanner.nextLine();
        
        diferencaDeData(data);

    }
    
    //TO-DO: Achar uma maneira mais elegante de fazer isso
    public static String diferencaDeData(String data) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar antes = Calendar.getInstance();
        Calendar agora = Calendar.getInstance();

        try {
            Date date = sdf.parse(data);
            antes.setTime(date);
        } catch (Exception ex) {
            System.out.println("Data errada." + ex);
        }

        int anoAntes = antes.get(Calendar.YEAR);
        int mesAntes = antes.get(Calendar.MONTH);
        int diaAntes = antes.get(Calendar.DATE);

        int anoAgora = agora.get(Calendar.YEAR);
        int mesAgora = agora.get(Calendar.MONTH);
        int diaAgora = agora.get(Calendar.DATE);

        int difAno = anoAgora - anoAntes;
        int difMes = mesAgora - mesAntes;
        int difDia = diaAgora - diaAntes;

        System.out.println(difAno > 1 ? difAno + " Anos" : difAno + " Ano");
        System.out.println(difMes > 1 ? difMes + " Meses" : difMes + " Mes");
        System.out.println(difDia > 1 ? difDia + " Dias" : difDia + " Dia");

        return null;
    }

    public static String exibirDiaNascimento(String dataNascimento) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date nascimento = formato.parse(dataNascimento);
            return (new SimpleDateFormat("EEEE").format(nascimento));
        } catch (ParseException ex) {
            System.out.println("Data informada no formato errado" + ex);
        }
        return null;
    }
}
