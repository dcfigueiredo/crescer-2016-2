package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author daniel.figueiredo
 */
public class Run {

    public static void main(String[] args) {
        try (final Connection connection = ConnectionUtils.getConnection();) {
            final String query = "SELECT * FROM DANIEL";
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while(resultSet.next()){
                        final long idPessoa = resultSet.getLong("ID_PESSOA");
                        final String nomePessoa = resultSet.getString("NM_PESSOA");
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException ex) {

        };
    }
}
