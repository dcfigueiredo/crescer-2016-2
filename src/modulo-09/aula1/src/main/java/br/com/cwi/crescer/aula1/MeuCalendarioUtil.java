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
        String dataNascimento = scanner.nextLine();

        System.out.println("Dia em que nasceu: " + exibirDiaNascimento(dataNascimento));
                
    }

//    public static String diferencaDeData(String data){        
//    }
    
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
