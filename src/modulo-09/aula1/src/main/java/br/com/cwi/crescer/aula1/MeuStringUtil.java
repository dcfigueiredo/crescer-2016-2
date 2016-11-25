package br.com.cwi.crescer.aula1;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class MeuStringUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        do {
            System.out.println("Selecione uma das opções abaixo: ");
            System.out.print("1 - Identificar palindromo.\r2 - Inverter String\r3 - Contar vogais\r0 - Sair ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 0) {
                    menu = false;
                } else if (opcao == 1) {
                    System.out.print("Informe uma palavra ou frase: ");
                    String string = scanner.nextLine();
                    if (!validarStringVazia(string)) {
                        System.out.println(identificarPalindromo(string) ? "É um palindromo" : "Não é um palindromo");
                    } else {
                        System.out.println("Palavra vazia.");
                    } 
                } else if (opcao == 2) {
                    System.out.print("Informe uma palavra ou frase: ");
                    String string = scanner.nextLine();
                    if (!validarStringVazia(string)) {
                        System.out.println("Invertida: " + inverterString(string));
                    } else {
                        System.out.println("Palavra vazia.");
                    }
                } else if (opcao == 3){
                    System.out.print("Informe uma palavra ou frase: ");
                    String string = scanner.nextLine();
                    if (!validarStringVazia(string)) {
                        System.out.println("Quantidade de vogais: " + qtdVogais(string));
                    } else{
                        System.out.println("Palavra vazia.");
                    }
                } else{
                    System.out.println("Opção invalida.");
                }
            } catch (Exception ex) {
                System.out.println("Opção invalida.");
            }
        } while (menu);
    }

    public static boolean identificarPalindromo(String string) {
        StringBuffer buffer = new StringBuffer(string);

        //Deleta os espaços da string
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == ' ') {
                buffer.deleteCharAt(i);
            }
        }

        int charDoFim = buffer.length() - 1;
        int charDoInicio = 0;
        while (charDoInicio < charDoFim) {
            char letraDoFim = Character.toUpperCase(buffer.charAt(charDoFim));
            char letraDoInicio = Character.toUpperCase(buffer.charAt(charDoInicio));

            if (letraDoFim != letraDoInicio) {
                return false;
            }

            charDoInicio++;
            charDoFim--;
        }

        return true;
    }

    public static String inverterString(String palavra) {
        return new StringBuffer(palavra).reverse().toString();
    }

    public static int qtdVogais(String palavra) {
        //char [] vogais = new char[]{'a','e','i','o','u'};
        int qtd = 0;
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                qtd++;
            }
        }
        return qtd;
    }

    public static boolean validarStringVazia(String string) {
        return string.isEmpty();
    }
}
