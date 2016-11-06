using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using FakeItEasy;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestarSeEstaChamandoOMetodoIncluirPersonagem()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem("João",new DateTime (1000,1,1) , 10, 11.2, "Atras Daquele Morro","Cacetada de cacetinho", true);

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
            .MustHaveHappened();        
        }

        [TestMethod]
        public void TestarSeEstaChamandoOMetodoExcluirPersonagem()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem("João", new DateTime(1000, 1, 1), 10, 11.2, "Atras Daquele Morro", "Cacetada de cacetinho", true);

            aplicativo.Excluir(personagem);

            A.CallTo(() => repositorioFake.ExcluirPersonagem(personagem))
            .MustHaveHappened();
        }

        [TestMethod]
        public void TestarSeEstaChamandoOMetodoListarPersonagem()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);            

            aplicativo.ListarPersonagens("João");

            A.CallTo(() => repositorioFake.ListarPersonagens("João"))
            .MustHaveHappened();
        }        
    }
}
