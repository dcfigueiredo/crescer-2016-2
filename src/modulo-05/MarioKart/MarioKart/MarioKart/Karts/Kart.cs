using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public abstract class Kart
    {

        public Corredor Corredor { get; private set; }
        public List<IEquipamentos> Equipamentos { get; private set; }
        public int Velocidade
        {
            get
            {
                return this.Velocidade;
            }
            private set
            {
                
                int velocidadePadrao = 3;
                int bonusDeHabilidadeDoCorredor = 0;
                int bonusDosEquipamentos = somarBonusDeEquipamentos();                
                if (this.Corredor.Nivel == Corredor.Habilidade.noob)
                {
                    bonusDeHabilidadeDoCorredor = 3;
                } else if (this.Corredor.Nivel == Corredor.Habilidade.mediano)
                {
                    bonusDeHabilidadeDoCorredor = 5;
                } else
                {
                    int quantidadeDeEquipamentos = Equipamentos.Count;
                    bonusDeHabilidadeDoCorredor = 6 + quantidadeDeEquipamentos;
                }

                this.Velocidade = velocidadePadrao +
                                  bonusDeHabilidadeDoCorredor +
                                  bonusDosEquipamentos;
            }
        }

        private int somarBonusDeEquipamentos()
        {
            int bonusDeEquipamentos = 0;
            for (int i = 0; i < Equipamentos.Count; i++)
            {
                bonusDeEquipamentos += Equipamentos[i].BonusDeVelocidade;
            }
            return bonusDeEquipamentos;
        }
    }
}
