using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Karts;
using MarioKart;

namespace MarioKartTest
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        //Packception
        public void TestarBonusDeVelocidadeDeUmUltraPackCom2UltraPacksEUmItemNormalDentro()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Noob));
            //TO-DO: Legibilidade
            kart.AdicionarEquipamento(new UltraPack(new UltraPack(new UltraPack(new PneusDeCouroDeDragao()))));
            int velocidadeEsperada = 14;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

        [TestMethod]
        //Packception
        public void TestarBonusDeVelocidadeDeUmUltraPackCom5UltraPacksEFogueteDePlutonioDentro()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Noob));
            //TO-DO: Legibilidade
            kart.AdicionarEquipamento(new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack(new UltraPack(new FogueteDePlutonio(FogueteDePlutonio.Nivel.Cinco))))))));
            int velocidadeEsperada = 27;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

    }
}
