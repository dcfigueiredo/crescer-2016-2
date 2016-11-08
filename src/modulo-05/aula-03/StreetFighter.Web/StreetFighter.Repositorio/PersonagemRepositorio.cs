using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {        

        public PersonagemRepositorio()
        {
            
        }
     
        public List<Personagem> ListarPersonagens(string filtroNome)
        {

            if (filtroNome == null || filtroNome.Equals(""))
            {
                filtroNome = "%";
            }

            List<Personagem> listaDePersonagens = new List<Personagem>();
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"]
                                                          .ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_filtro";
                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_filtro", filtroNome));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Personagem personagem = ConverterParaPersonagem(reader);
                    listaDePersonagens.Add(personagem);
                }
                connection.Close();
            }
                return listaDePersonagens;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"]
                                                                      .ConnectionString;

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "";
                    var parameters = ListarParametrosDoPersonagem(personagem);
                    if (personagem.Id > 0)
                    {
                        sql = $"UPDATE Personagem SET Nome = @param_nome, Set Nascimento = @param_nascimento, Set Altura = @param_altura," +
                              $" Set Peso = @param_peso, Set Origem = @param_origem, Set GolpesFamosos = @param_golpes, Set Oculto = @param_oculto) WHERE Id = @param_Id";                        
                    }
                    else
                    {
                        sql = $"INSERT INTO Personagem (Nome, Nascimento, Altura, Peso, Origem, GolpesFamosos, Oculto)" +
                              $"VALUES (@param_nome, @param_nascimento, @param_altura, @param_peso, @param_origem, @param_golpes, @param_oculto)";
                    }
                    var command = new SqlCommand(sql, connection);

                    foreach (SqlParameter parametro in parameters)
                    {
                        command.Parameters.Add(parametro);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (NotImplementedException ex)
                {
                    throw ex;
                }
                finally
                {
                    connection.Close();
                }
            }            
        }        

        public void ExcluirPersonagem(int id)
        {

            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"]
                                                                      .ConnectionString;

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "DELETE FROM Personagem WHERE Id = @param_id";

                    var command = new SqlCommand(sql, connection);
                    command.Parameters.Add(new SqlParameter("param_id", id));

                    command.ExecuteNonQuery();

                    transaction.Complete();
                }
                catch (NotImplementedException ex)
                {
                    throw ex;
                }
                finally
                {
                    connection.Close();
                }
            }
        }
        public void EditarPersonagem(Personagem personagem)
        {

        }

        public Personagem EncontrarPersonagem(int id)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"].
                                                           ConnectionString;

            Personagem personagem = null;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE ID = @param_id";
                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", id));

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    personagem = ConverterParaPersonagem(reader);
                }

                connection.Close();

            }
            return personagem;
        }

        private Personagem ConverterParaPersonagem(SqlDataReader reader)
        {
            var id = Convert.ToInt32(reader["Id"]);
            var nome = reader["Nome"].ToString();
            var nascimento = Convert.ToDateTime(reader["Nascimento"]);
            var altura = Convert.ToInt32(reader["Altura"]);
            var peso = Convert.ToDouble(reader["Peso"]);
            var origem = reader["Origem"].ToString();
            var golpes = reader["GolpesFamosos"].ToString();
            var oculto = Convert.ToInt32(reader["Oculto"]) == 0 ? false : true;

            return new Personagem(id, nome, nascimento, altura, peso, origem, golpes, oculto);
        }

        private static List<SqlParameter> ListarParametrosDoPersonagem(Personagem personagem)
        {
            List<SqlParameter> parameters = new List<SqlParameter>();
            parameters.Add(new SqlParameter("param_Id", personagem.Id));
            parameters.Add(new SqlParameter("param_nome", personagem.Nome));
            parameters.Add(new SqlParameter("param_nascimento", personagem.Nascimento));
            parameters.Add(new SqlParameter("param_altura", personagem.Altura));
            parameters.Add(new SqlParameter("param_peso", personagem.Peso));
            parameters.Add(new SqlParameter("param_origem", personagem.Origem));
            parameters.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciaisFamosos));
            parameters.Add(new SqlParameter("param_oculto", personagem.Oculto));
            return parameters;
        }        
    }
}

