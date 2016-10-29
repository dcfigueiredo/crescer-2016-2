using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Karts;
using MarioKart.Equipamentos;

namespace MarioKartTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void TestarSeAVelocidadeEstaCertComUmItemECorredorMediano()
        {
            Kart kart = new Kart(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Mediano));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            int velocidadeEsperada = 10;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);

        }

        [TestMethod]
        public void TestarSeAVelocidadeEstaCertaComUmCorredorProfissionalSemItemsNoKart()
        {
            Kart kart = new Kart(new MarioKart.Corredor("Samus Aran", MarioKart.Corredor.NivelDeHabilidade.Profissional));
            int velocidadeEsperada = 9;
            int velocidadeDoKart = kart.Velocidade;
            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

        [TestMethod]
        public void TestarSeAVelocidadeEstaCertaComUmCorredorProfissionalETresItemsNoKart()
        {
            Kart kart = new Kart(new MarioKart.Corredor("///EssaehumastringdetestespqobernardocontouumahistoriasobrenomesesperadosumdiaXxxXx00", MarioKart.Corredor.NivelDeHabilidade.Profissional));
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            kart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            kart.AdicionarEquipamento(new MotorABaseDeLava());
            int velocidadeEsperada = 19;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
    }
}
