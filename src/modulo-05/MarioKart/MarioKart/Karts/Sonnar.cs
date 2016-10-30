using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {

        }

        public override int Velocidade
        {
            get
            {
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = AcharBonusDeHabilidadeDoCorredor();
                int velocidadeTotal = somaDosBonusDeEquipamento + bonusHabilidadeCorredor;
                bool temMaisQueUmEquip = Equipamentos.Count > 0;
                if (temMaisQueUmEquip)
                {
                    return 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento + 2;
                }

                return 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento;
            }
        }
    }
}
