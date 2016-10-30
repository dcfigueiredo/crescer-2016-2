using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public abstract class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            Equipamentos = new List<IEquipamento>();
        }
        protected Corredor Corredor { get; }
        public List<IEquipamento> Equipamentos { get; }
        public virtual int Velocidade
        {
            get
            {
                int somaDosBonusDeEquipamento = SomarBonus();
                int bonusHabilidadeCorredor = AcharBonusDeHabilidadeDoCorredor();

                return 3 + bonusHabilidadeCorredor + somaDosBonusDeEquipamento;
            }
        }

        public virtual int AcharBonusDeHabilidadeDoCorredor()
        {            
            if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Noob)
            {
                return 3;
            }
            else if (Corredor.Habilidade == Corredor.NivelDeHabilidade.Mediano)
            {
                return 5;
            }
            else
            {
                return 6 + Equipamentos.Count;
            }
        }

        public void AdicionarEquipamento(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        protected internal int SomarBonus()
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
