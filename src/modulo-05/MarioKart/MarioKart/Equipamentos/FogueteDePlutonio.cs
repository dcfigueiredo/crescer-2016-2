using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public enum Nivel { Um, Dois, Tres, Quatro, Cinco }
        public FogueteDePlutonio(Nivel nivel)
        {
            this.BonusDeVelocidade = IdentificarBonusVelocidade(nivel);
        }

        public int BonusDeVelocidade { get; }

        private int IdentificarBonusVelocidade(Nivel nivel)
        {
            if (nivel == Nivel.Um)
            {
                return 1;
            }
            else if (nivel == Nivel.Dois)
            {
                return 2;
            }
            else if (nivel == Nivel.Tres)
            {
                return 3;
            }
            else if (nivel == Nivel.Quatro)
            {
                return 4;
            }
            else if (nivel == Nivel.Cinco)
            {
                return 5;
            }
            else
            {
                return 2;
            }
        }

    }
}
