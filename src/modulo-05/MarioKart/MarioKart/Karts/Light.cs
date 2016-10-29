using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) :base (corredor)
        {

        }

        public override int Velocidade
        {
            get
            {
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = AcharBonusDeHabilidadeDoCorredor();

                return 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento;
            }
        }

        public override int AcharBonusDeHabilidadeDoCorredor()
        {
            int bonusHabilidadeCorredor = 0;
            if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Noob)
            {
                bonusHabilidadeCorredor = 3 + 3;
            }
            else if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Mediano)
            {
                bonusHabilidadeCorredor = 5;
            }
            else
            {
                bonusHabilidadeCorredor = 6 + Equipamentos.Count - 1;
            }
            return bonusHabilidadeCorredor;
        }
    }
}
