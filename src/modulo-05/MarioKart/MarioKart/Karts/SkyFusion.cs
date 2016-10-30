using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {

        }

        public List<IEquipamento> Equipamentos { get; }
        public int BonusDeVelocidade
        {
            get
            {
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = AcharBonusDeHabilidadeDoCorredor();
                int velocidadeTotal = 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento;
                bool velocidadeMaiorQueDoze = velocidadeTotal > 12;
                if (velocidadeMaiorQueDoze)
                {
                    return velocidadeTotal + 5;
                }
                return velocidadeTotal;
            }
        }

        public override int AcharBonusDeHabilidadeDoCorredor()
        {
            int bonusHabilidadeCorredor = 0;
            if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Noob)
            {
                bonusHabilidadeCorredor = 3 + 1;
            }
            else if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Mediano)
            {
                bonusHabilidadeCorredor = 5 + 2;
            }
            else
            {
                bonusHabilidadeCorredor = 6 + Equipamentos.Count + 3;
            }
            return bonusHabilidadeCorredor;
        }

    }
}
