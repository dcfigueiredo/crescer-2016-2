/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class MeuSQLUtils {

    public static void lerSQL(String nomeSQL) {
        if (nomeSQL.endsWith(".sql")) {
            try (BufferedReader br = new BufferedReader(new FileReader(nomeSQL));) {
                String linha = "";
                StringBuffer comandoSQL = new StringBuffer();
                while ((linha = br.readLine()) != null) {
                    comandoSQL.append(linha).append(" ");
                }            
                executarSQL(comandoSQL.toString());
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo não encontrado.");
            } catch (IOException ex) {
                System.out.println("Erro que eu não sei o que significa ainda." + ex);
            }
        } else {
            System.out.println("Arquivo invalido.");
        }
    }
    
    private static void executarSQL(String comando){
        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(comando);){
            
        } catch(SQLException ex){
            
        }
    }
}
