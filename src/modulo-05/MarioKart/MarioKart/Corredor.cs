using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public Corredor(string nome, NivelDeHabilidade habilidade = NivelDeHabilidade.Noob)
        {
            this.Nome = nome;
            this.Habilidade = habilidade;
        }
        public enum NivelDeHabilidade { Noob, Mediano, Profissional}
        public string Nome { get; set; }
        public NivelDeHabilidade Habilidade { get; set; }

    }
}
