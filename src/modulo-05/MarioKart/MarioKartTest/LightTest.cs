using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class LightTest
    {
        [TestMethod]
        public void TestarBonusDeVelocidadeComPilotoNoob()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Noob));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 11;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

        [TestMethod]
        public void TestarBonusDeVelocidadeComPilotoProfissional()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Profissional));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 14;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
    }
}
