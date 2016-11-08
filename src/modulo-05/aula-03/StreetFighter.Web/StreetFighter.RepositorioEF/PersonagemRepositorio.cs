using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public List<Personagem> ListarPersonagens(string filtroNome = "")
        {                        
            using (var contexto = new DatabaseContext())
            {
                IQueryable<Personagem> query = contexto.Personagem.Where(personagem => personagem.Nome.Contains(filtroNome));
                return query.ToList();                
            }
        }

        public Personagem EncontrarPersonagem(int id)
        {
            using (var contexto = new DatabaseContext())
            {
                Personagem personagemEncontrado = contexto.Personagem.Find(id);
                return personagemEncontrado;
            }            
        }

        public void ExcluirPersonagem(int id)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using(var contexto = new DatabaseContext())
            {
                contexto.Entry(personagem).State = System.Data.Entity.EntityState.Added;
                contexto.SaveChanges();
            }
        }        
    }
}
