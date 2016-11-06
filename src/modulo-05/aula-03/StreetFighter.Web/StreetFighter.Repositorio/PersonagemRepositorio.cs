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

        const string caminhoDoBanco = @"C:\Users\Daiane Figueiredo\crescer-2016-2\src\modulo-05\aula-03\StreetFighter.Web\StreetFighter.Repositorio\banco.txt";
        public List<Personagem> ListaDePersonagens { get; private set; } = new List<Personagem>();


        public PersonagemRepositorio()
        {
            var personagensDoArquivo = File.ReadAllLines(caminhoDoBanco).ToList();

            foreach (var personagem in personagensDoArquivo)
            {
                var propriedadesSeparadas = personagem.Split(';');
                Personagem personagemASerListado = CriarPersonagem(propriedadesSeparadas);
                this.ListaDePersonagens.Add(personagemASerListado);
            }
        }


        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            return ListaDePersonagens.Where(personagem => personagem.Nome.Equals(filtroNome)).ToList();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            bool editou = false;
            foreach (var personagemDaLista in ListaDePersonagens)
            {
                if (personagemDaLista.Equals(personagem))
                {
                    EditarPersonagem(personagem);
                    editou = true;
                    break;
                }
            }
            if(!editou)
            {
                this.ListaDePersonagens.Add(personagem);
                ReescreverBanco();
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            foreach (var personagemDaLista in ListaDePersonagens)
            {
                if (personagem.Equals(personagemDaLista))
                {
                    var posicao = ListaDePersonagens.IndexOf(personagemDaLista);
                    ListaDePersonagens[posicao] = personagem;
                    ReescreverBanco();
                    break;
                }
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            this.ListaDePersonagens.Remove(personagem);
            ReescreverBanco();
        }

        private void ReescreverBanco()
        {
            File.AppendAllText(caminhoDoBanco, "");
            using (StreamWriter writer = new StreamWriter(caminhoDoBanco))
            {
                foreach (var personagemDaLista in ListaDePersonagens)
                {
                    writer.WriteLine(personagemDaLista.ToString());
                }
            }
        }

        private Personagem CriarPersonagem(string[] propriedadesSeparadas)
        {
            var nome = propriedadesSeparadas[1];
            var nascimento = DateTime.Parse(propriedadesSeparadas[2]);
            var altura = Int32.Parse(propriedadesSeparadas[3]);
            var peso = Double.Parse(propriedadesSeparadas[4]);
            var origem = propriedadesSeparadas[5];
            var golpes = propriedadesSeparadas[6];
            var oculto = bool.Parse(propriedadesSeparadas[7]);
            Personagem personagem = new Personagem(nome, nascimento, altura, peso, origem, golpes, oculto);
            return personagem;
        }
    }
}
