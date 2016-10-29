using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class DinamTest
    {
        [TestMethod]
        public void TestarSeOBonusDeCorredorEstaSendoAtribuidoCorretamente()
        {
            Kart kart = new Dinam(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Mediano));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 15;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
        [TestMethod]
        public void TestarSeOBonusDeCorrederEstaSendoAtribuidoCorretamenteComCorredorProfissional()
        {
            Kart kart = new Dinam(new MarioKart.Corredor("12322122321", MarioKart.Corredor.NivelDeHabilidade.Profissional));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 27;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
    }
}
