using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {

        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;
        }

        public IEquipamento Equipamento { get; }
        public int BonusDeVelocidade
        {
            get
            {
                return (int)Math.Ceiling(1.2 * this.Equipamento.BonusDeVelocidade);
            }
        }


        //TO-DO: Fazer método recursivo que funcione
        /*private int CalcularBonus(IEquipamento equipamento)
        {
            double bonusDeVelocidade = 0;
            if (equipamento is UltraPack && Equipamento != this.Equipamento)
            {
                bonusDeVelocidade += (CalcularBonus((UltraPack)equipamento.Equipamento) * 1.2) + 1;
            }
            else if (equipamento == null)
            {
                return 0;
            }
            else
            {
                bonusDeVelocidade += equipamento.BonusDeVelocidade;
            }           
            return (int)Math.Ceiling(bonusDeVelocidade);
        }*/
    }
}
