using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {

        const string caminhoDoBanco = @"C:\Users\daniel.figueiredo\crescer-2016-2\src\modulo-05\aula-03\StreetFighter.Web\StreetFighter.Repositorio\banco.txt";
        public List<Personagem> ListaDePersonagens { get; private set; } = new List<Personagem>();


        public PersonagemRepositorio()
        {
            var personagens = File.ReadAllLines(caminhoDoBanco).ToList();

            foreach (var personagem in personagens)
            {
                var propriedadesSeparadas = personagem.Split(';');
                Personagem personagemASerListado = CriarPersonagem(propriedadesSeparadas);
                this.ListaDePersonagens.Add(personagemASerListado);
            }
        }

        private Personagem CriarPersonagem(string[] propriedadesSeparadas)
        {
            var id = Int32.Parse(propriedadesSeparadas[0]);
            var nome = propriedadesSeparadas[1];
            var nascimento = DateTime.Parse(propriedadesSeparadas[2]);
            var altura = Int32.Parse(propriedadesSeparadas[3]);
            var peso = Double.Parse(propriedadesSeparadas[4]);
            var origem = propriedadesSeparadas[5];
            var golpes = propriedadesSeparadas[6];
            var oculto = bool.Parse(propriedadesSeparadas[7]);
            Personagem personagem = new Personagem(id, nome, nascimento, altura, peso, origem, golpes, oculto);
            return personagem;
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            this.ListaDePersonagens.Add(personagem);
            File.AppendAllText(caminhoDoBanco, Environment.NewLine + personagem.ToString());
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
