using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {
        IList<Personagem> ListarPersonagens(string filtroNome);
        void IncluirPersonagem(Personagem personagem);
        void EditarPersonagem(int id);
        void ExcluirPersonagem(int id);
        Personagem EncontrarPersonagem(int id);
    }
}
