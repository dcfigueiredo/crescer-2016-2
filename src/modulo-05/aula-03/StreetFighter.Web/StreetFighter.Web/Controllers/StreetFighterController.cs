using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;
using StreetFighter.Dominio;
using StreetFighter.Aplicativo;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro(FichaTecnicaModel model)
        {
            PopularOrigem();
            if (ModelState.IsValid)
            {
                Personagem personagem = CriarPersonagem(model);
                PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo(); //???
                personagemAplicativo.Salvar(personagem);
                ViewBag.Mensagem = "Cadastro concluido com sucesso.";
                return View("~/Views/StreetFighter/Cadastro.cshtml");
            }
            else
            {
                ViewBag.Mensagem = "Cadastro inválido";
                return View("~/Views/StreetFighter/Cadastro.cshtml");
            }
        }

        public ActionResult FichaTecnica(int idPersonagem)
        {
            var model = CriarModel(idPersonagem);
            return View(model);
        }
       
        public ActionResult Sobre()
        {
            var model = new SobreModel();
            model.Nome = "Daniel";
            model.PrimeiraAparicao = "Crescer Edição 2016-2";
            model.Nascimento = new DateTime(1993, 09, 22);
            model.Altura = 161;
            model.Peso = 56;
            model.Medidas = "Desconhecidas";
            model.TipoSanguineo = "-O";
            model.HabilidadesEspeciais = new List<String>() { "Fazer site para a vovó", "super audição" };
            model.Gosta = new List<String>() { "Massa com atum", "Café", "Sua Mãe" };
            model.Desgosta = new List<String>() { "Murlocs", "Cicero" };
            model.EstiloDeLuta = "Luta Selvagem autodidata (Gatinhos)";
            model.Origem = "Brasil";
            model.FalaVitoria = "Eu manjo das magias!";
            model.NickName1 = "Dani Elf";
            model.NickName2 = "Trivial Dani";
            model.NickName3 = "Dani das Firulas";
            model.Stage1 = "Mina do Leão II - Subterraneo - Brasil.";
            model.Stage2 = "Torre do Carvão (Brasil)";
            model.GolpesEspeciaisFamosos = new List<string>() { "CTRL+C", "CTRL+V" };
            return View(model);
        }

        public ActionResult ListaDePersonagens(string filtroNome)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            if (filtroNome == null)
            {
                var model = personagemAplicativo.ListarPersonagens("");
                return View(model);
            }
            else
            {
                var model = personagemAplicativo.ListarPersonagens(filtroNome);
                return View(model);
            }
        }

        private FichaTecnicaModel CriarModel(int id)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            var personagemDaLista = personagemAplicativo.EncontrarPersonagem(id);
            var model = new FichaTecnicaModel();
            model.Nome = personagemDaLista.Nome;
            model.Nascimento = personagemDaLista.Nascimento;
            model.Altura = personagemDaLista.Altura;
            model.Peso = personagemDaLista.Peso;
            model.Origem = personagemDaLista.Origem;
            model.GolpesEspeciaisFamosos = personagemDaLista.GolpesEspeciaisFamosos;
            model.Oculto = personagemDaLista.Oculto;
            return model;
        }

        private Personagem CriarPersonagem(FichaTecnicaModel model)
        {
            var nome = model.Nome;
            var nascimento = model.Nascimento;
            var altura = model.Altura;
            var peso = model.Peso;
            var origem = model.Origem;
            var golpes = model.GolpesEspeciaisFamosos;
            var oculto = model.Oculto;
            return new Personagem(nome, nascimento, altura, peso, origem, golpes, oculto);
        }

        private void PopularOrigem()
        {
            ViewData["ListaOrigem"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BRA", Text = "Brasil"},
                new SelectListItem() { Value = "GER", Text = "Alemanha"},
                new SelectListItem() { Value = "IND", Text = "India"},
                new SelectListItem() { Value = "JAP", Text = "Japão"},
                new SelectListItem() { Value = "MDP", Text = "Morro da Pedra"}
            };
        }
    }
}

