/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class MeuReaderUtils {    
    public static void exibirConteudo(String nomeArquivo) {
        if (nomeArquivo.endsWith(".txt")) {
            try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                String linha = "";
                while ((linha = br.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (FileNotFoundException ex) {
                System.err.println("O arquivo não existe");
                
            } catch (IOException ex) {
                System.err.println("Erro que eu não sei o que significa. ");
            }
        } else {
            System.out.println("Arquivo solicitado é incompativel.");
        }
    }
}
