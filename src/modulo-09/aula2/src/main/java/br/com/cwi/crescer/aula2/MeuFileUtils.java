/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class MeuFileUtils {

    public static void main(String[] args) {               
        if (args[0].equals("mk") && args.length == 2) {
            boolean criou = criarArquivo(args[1]);
            if (criou) {
                System.out.println("Aquivo criado com sucesso.");
            } else {
                System.out.println("O arquivo não pode ser criado.");
            }
        } else if (args[0].equals("rm") && args.length == 2) {
            boolean deletou = deletarArquivo(args[1]);
            if (deletou) {
                System.out.println("Arquivo deletado com sucesso");
            } else {
                System.out.println("Arquivo não encontrado ou invalido");
            }
        } else if (args[0].equals("ls") && args.length == 2) {
            if (args[1].endsWith(".txt")) {
                System.out.println("Caminho absoluto: " + new File(args[1]).getAbsolutePath());
            } else {
                String[] arquivos = new File(args[1]).list();
                System.out.println("Arquivos da pasta: ");
                for (String arquivo : arquivos) {
                    System.out.println(arquivo);
                }
            }
        } else if (args[0].equals("mv") && args.length == 3) {
            boolean moveu = moverAqruivo(args);
            if(moveu){
                System.out.println("Arquivo movido com sucesso");
            } else {
                System.out.println("O arquivo não foi encontrado");
            }
        }
    }

    public static boolean criarArquivo(String nomeArquivo) {
        File f = new File(nomeArquivo);
        try {
            if (!f.exists()) {
                if (nomeArquivo.endsWith(".txt")) {
                    return f.createNewFile();
                } else {
                    return f.mkdir();
                }
            }
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro." + ex);
        }
        return false;
    }

    public static boolean deletarArquivo(String nomeArquivo) {
        if (nomeArquivo.endsWith(".txt")) {
            return new File(nomeArquivo).delete();
        }
        return false;
    }

    public static boolean moverAqruivo(String[] args) {
        File f = new File (args[1]);
        String caminho = args[2];        
        return f.renameTo(new File(caminho + f.getName()));        
    }       
}
