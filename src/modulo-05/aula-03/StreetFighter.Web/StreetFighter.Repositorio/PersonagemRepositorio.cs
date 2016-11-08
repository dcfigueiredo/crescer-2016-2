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

        //const string caminhoDoBanco = @"C:\Users\daniel.figueiredo\crescer-2016-2\src\modulo-05\aula-03\StreetFighter.Web\StreetFighter.Repositorio\banco.txt";
        //public List<Personagem> ListaDePersonagens { get; private set; } = new List<Personagem>();


        public PersonagemRepositorio()
        {
            //CarregarListaDoBanco();

            //Modo Arquivo
            /*var personagensDoArquivo = File.ReadAllLines(caminhoDoBanco).ToList();

            foreach (var personagem in personagensDoArquivo)
            {
                var propriedadesSeparadas = personagem.Split(';');
                Personagem personagemASerListado = CriarPersonagem(propriedadesSeparadas);
                this.ListaDePersonagens.Add(personagemASerListado);
            }*/
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
                return listaDePersonagens; //ListaDePersonagens.Where(personagem => personagem.Nome.Contains(filtroNome)).ToList();
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


            /*bool editou = false;
            foreach (var personagemDaLista in ListaDePersonagens)
            {
                if (personagemDaLista.Equals(personagem))
                {
                    EditarPersonagem(personagem);
                    editou = true;
                    break;
                }
            }
            if (!editou)
            {
                this.ListaDePersonagens.Add(personagem);
                //ReescreverBanco();
            }*/
        }

        public void EditarPersonagem(Personagem personagem)
        {

        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            //this.ListaDePersonagens.Remove(personagem);
            //ReescreverBanco();
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

        /*public Personagem EncontrarPersonagem(int id)
        {
            foreach (var personagem in ListaDePersonagens)
            {
                if (personagem.Id == id)
                {
                    return personagem;
                }
            }
            return null;
        }*/

        /*private void ReescreverBanco()        
        {
            File.AppendAllText(caminhoDoBanco, "");
            using (StreamWriter writer = new StreamWriter(caminhoDoBanco))
            {
                foreach (var personagemDaLista in ListaDePersonagens)
                {
                    writer.WriteLine(personagemDaLista.ToString());
                }
            }
        }*/

    }
}

