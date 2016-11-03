using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {

        public Personagem(string nome, DateTime nascimento, int altura, double peso, string origem, string golpesFamosos, bool oculto)
        {
            this.Nome = nome;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciaisFamosos = golpesFamosos;
            this.Oculto = oculto;
        }

        public int Id { get; set; }

        public String Imagem { get; set; }

        public String Nome { get; set; }

        public DateTime Nascimento { get; set; }

        public int Altura { get; set; }

        public double Peso { get; set; }

        public String Origem { get; set; }

        public String GolpesEspeciaisFamosos { get; set; }

        public bool Oculto { get; set; }

    }
}
