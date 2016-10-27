using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public enum Habilidade { noob, mediano, profissional};
        public Corredor(String nome, Habilidade nivel)
        {
            this.Nome = nome;
            this.Nivel = nivel;
        }

        public String Nome { get; private set; }
        public Habilidade Nivel { get; set; }

    }
}
