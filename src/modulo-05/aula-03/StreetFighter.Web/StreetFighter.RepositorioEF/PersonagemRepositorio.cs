using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        public void EditarPersonagem(int id)
        {
            using (var contexto = new DatabaseContext())
            {
                Personagem personagemPraEditar = EncontrarPersonagem(id); 
                contexto.Entry(personagemPraEditar).State = EntityState.Modified;
                contexto.SaveChanges();
            }
        }

        public IList<Personagem> ListarPersonagens(string filtroNome)
        {                        
            using (var contexto = new DatabaseContext())
            {
                if (!String.IsNullOrEmpty(filtroNome))
                {
                    return contexto.Personagem.Where(personagem => personagem.Nome.Contains(filtroNome)).ToList();
                }
                else
                {
                    filtroNome = "";
                    return contexto.Personagem.Where(personagem => personagem.Nome.Contains(filtroNome)).ToList();
                }
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
            using (var contexto = new DatabaseContext())
            {
                contexto.Entry(EncontrarPersonagem(id)).State = EntityState.Deleted;
                contexto.SaveChanges();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using(var contexto = new DatabaseContext())
            {
                contexto.Entry(personagem).State = EntityState.Added;
                contexto.SaveChanges();
            }
        }        
    }
}
