using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
//            this.velocidade = 3;
            Equipamentos = new List<IEquipamento>();
        }
        public Corredor Corredor { get; set; }
        public List<IEquipamento> Equipamentos { get; set; }
//        private int velocidade { get; set; }
        public int Velocidade        
        {
            get
            {
                //velocidade + bonus dos equipamentos + bonus do corredor
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = 0;
                if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Noob)
                {
                    bonusHabilidadeCorredor = 3;
                }
                else if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Mediano)
                {
                    bonusHabilidadeCorredor = 5;
                }
                else
                {
                    bonusHabilidadeCorredor = 6 + Equipamentos.Count;
                }

                return 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento;
            }
        }

        public void AdicionarEquipamento (IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        private int SomarBonus()
        {
            if (Equipamentos.Count == 0) return 0;
            int somaDosBonus = 0;
            foreach (var equipamento in Equipamentos)
            {
                somaDosBonus += equipamento.BonusDeVelocidade;
            }
            return somaDosBonus;
        }
    }
}
