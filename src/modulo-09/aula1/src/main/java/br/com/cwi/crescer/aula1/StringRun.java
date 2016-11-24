package br.com.cwi.crescer.aula1;
import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author daniel.figueiredo
 */
public class StringRun {

    public static void main(String[] args) {
        if ("A" == new String("A")) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }

        Scanner console = new Scanner(System.in);
        System.out.println("Digite uma palavra.");
        String palavra = console.nextLine();
        int qtdVogais = acharVogal(palavra);
        System.out.println(qtdVogais);
        System.out.println(inverterString(palavra));

        String estadosConcatenados = concatenarEstados();
        System.out.println(estadosConcatenados);
    }

    public static String concatenarEstados() {
        
        StringBuffer estadosConcatenados = new StringBuffer();
        for (Estados estados : Estados.values()) {
            estadosConcatenados.append(estados.getNome()).append(", ");
        }
        estadosConcatenados.deleteCharAt(estadosConcatenados.length()-2);
        return estadosConcatenados.toString();
        
    }

    public static String inverterString(String palavra) {
        return new StringBuffer(palavra).reverse().toString();
    }

    public static int acharVogal(String palavra) {
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
}

enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
