/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author daniel.figueiredo
 */
public class DataRun {

    public static void main(String[] args) {
        System.out.print("Data atual: ");
        exibirDataAtual();
        exibirDiaNascimento();
    }

    public static void exibirDiaNascimento() {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Scanner console = new Scanner(System.in);
        System.out.print("Data do nascimento: ");
        String dataNascimento = console.nextLine();

        try {
            Date nascimento = formato.parse(dataNascimento);
            System.out.println(new SimpleDateFormat("EEEE").format(nascimento));
        } catch (Exception ex) {
            System.out.println("Data inserida errada." + ex);
        }        
    }

    public static void exibirDataAtual() {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        System.out.println(formato.format(data));
    }
}
