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
        boolean menu = true;
        do {
            System.out.println("Selecione uma das opções abaixo: ");
            System.out.print("1 - Diferença entre data de hoje e outra data\r2 - Dia do Nascimento\r0 - Sair:     ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 0:
                        System.out.println("Programa encerrado.");
                        menu = false;
                        break;
                    case 1:
                        System.out.println("Insira uma data: ");
                        String data = scanner.nextLine();
                        diferencaDeData(data);
                        break;
                    case 2:
                        System.out.println("Insira a data de nascimento: ");
                        String dataNascimento = scanner.nextLine();
                        exibirDiaNascimento(dataNascimento);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Opção inválida." + ex);
            }
        } while (menu);
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

        System.out.print(difAno > 1 ? difAno + " Anos, " : difAno + " Ano, ");
        System.out.print(difMes > 1 ? difMes + " Meses, " : difMes + " Mes, ");
        System.out.print(difDia > 1 ? difDia + " Dias." : difDia + " Dia.\r");

        return null;
    }

    public static void exibirDiaNascimento(String dataNascimento) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date nascimento = formato.parse(dataNascimento);
            System.out.println((new SimpleDateFormat("EEEE").format(nascimento)));
        } catch (ParseException ex) {
            System.out.println("Data informada no formato errado" + ex);
        }
    }
}
