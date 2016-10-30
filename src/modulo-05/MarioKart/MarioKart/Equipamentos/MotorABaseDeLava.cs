using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class MotorABaseDeLava : IEquipamento
    {
        public MotorABaseDeLava()
        {
            this.BonusDeVelocidade = 3;
        }
        public int BonusDeVelocidade { get; }
    }
}
