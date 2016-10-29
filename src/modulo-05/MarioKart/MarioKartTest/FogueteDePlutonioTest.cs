using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart.Equipamentos;
using MarioKart.Karts;

namespace MarioKartTest
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void TestarLightComFogueteDePlutonioNivel1()
        {
            Kart kart = new Light(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Noob));
            kart.AdicionarEquipamento(new FogueteDePlutonio(FogueteDePlutonio.Nivel.Um));
            int velocidadeEsperada = 10;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }

        [TestMethod]
        public void TestarSonnarComFogueteDePlutonioNivel5()
        {
            Kart kart = new Sonnar(new MarioKart.Corredor("Megaman", MarioKart.Corredor.NivelDeHabilidade.Profissional));
            kart.AdicionarEquipamento(new FogueteDePlutonio(FogueteDePlutonio.Nivel.Cinco));
            int velocidadeEsperada = 17;
            int velocidadeDoKart = kart.Velocidade;

            Assert.AreEqual(velocidadeEsperada, velocidadeDoKart);
        }
    }
}
