/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class MeuWriterUtils {

    public static void escrever(String nomeArquivo, List<String> conteudo) {
        if (new File(nomeArquivo).exists()) {
            if (!nomeArquivo.endsWith(".txt")) {
                System.out.println("Arquivo solicitado invalido");
                return;
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo));) {
                for (int i = 0; i < conteudo.size(); i++) {
                    bw.write(conteudo.get(i));
                    bw.newLine();
                    bw.flush();
                }
                System.out.println("Conteudo inserido com sucesso.");
            } catch (IOException ex) {
                System.out.println("Erro que ue não sei exatamente o que é. " + ex);
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
