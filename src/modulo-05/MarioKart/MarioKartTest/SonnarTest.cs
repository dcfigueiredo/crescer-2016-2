using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class SonnarTest
    {
        [TestMethod]
        public void TestarSonarCom1Equipamento()
        {
            Kart kart = new Sonnar(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Mediano));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 12;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

        [TestMethod]
        public void TestarSonarCom0Equipamentos()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Mediano));
            int velocidadeEsperada = 8;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
    }
}
