using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Repositorio;
using StreetFighter.Dominio;
using System.IO;
using System.Linq;

namespace StreetFighter.Testes
{
    [TestClass]
    public class PersonagemRepositorioTest
    {
        const string caminhoDoBanco = @"C:\Users\daniel.figueiredo\crescer-2016-2\src\modulo-05\aula-03\StreetFighter.Web\StreetFighter.Repositorio\banco.txt";
        [TestMethod]
        public void TestarSeEstaIncluindoPersonagemNaListaENoArquivo()
        {
            PersonagemRepositorio repositorio = new PersonagemRepositorio();

            Personagem blanka = new Personagem("Blanka", new DateTime(2010, 10, 10), 10, 5.5, "Brasil", "Alahuakabar", false);
            Personagem guile = new Personagem("Guile", new DateTime(2010, 10, 10), 30, 15.0, "America", "Alexfool", false);
            Personagem balrog = new Personagem("Balrog", new DateTime(2010, 05, 15), 1000, 50.5, "Tailandia", "Tiger robocop", true);
            Personagem eu = new Personagem("Eu", new DateTime(2010, 10, 09), 1, 1.5, "Brasil", "CtrlC", false);

            repositorio.IncluirPersonagem(blanka);
            repositorio.IncluirPersonagem(guile);
            repositorio.IncluirPersonagem(balrog);
            repositorio.IncluirPersonagem(eu);

            var listaDoArquivo = File.ReadAllLines(caminhoDoBanco).ToList();

            Assert.AreEqual(listaDoArquivo.Count, repositorio.ListaDePersonagens.Count);
        }        
    }
}