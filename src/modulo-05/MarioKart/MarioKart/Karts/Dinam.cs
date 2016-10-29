using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {
            
        }
        //TO-DO: Achar maneira de chamar o método sobreescrito para não repetir código.
        public override int Velocidade { get
            {
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = AcharBonusDeHabilidadeDoCorredor();

                return 3 + (bonusHabilidadeCorredor*2) + somaDosBonusDeEquipamento;
            }
        }
                
    }
}
