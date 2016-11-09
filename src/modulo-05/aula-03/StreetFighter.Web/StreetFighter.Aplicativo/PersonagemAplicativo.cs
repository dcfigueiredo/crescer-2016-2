using StreetFighter.Dominio;
using StreetFighter.RepositorioEF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public IList<Personagem> ListarPersonagens(string filtroNome)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public Personagem EncontrarPersonagem(int id)
        {
            return repositorio.EncontrarPersonagem(id);
        }

        public void Salvar(Personagem personagem)
        {
            repositorio.IncluirPersonagem(personagem);
        }

        public void Editar(int id)
        {
            repositorio.EditarPersonagem(id);
        }

        public void Excluir(int id)
        {
            repositorio.ExcluirPersonagem(id);
        }
    }
}