using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;


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
            PoupularListaOrigem();
            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluido com sucesso.";
                return View("~/Views/StreetFighter/FichaTecnica.cshtml", model);
            }
            else
            {             
                return View("~/Views/StreetFighter/Cadastro.cshtml");
            }
        }
        
        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();
            model.Nome = "Blanka";
            model.Nascimento = new DateTime(1966, 02, 12);
            model.Altura = 192;
            model.Peso = 96;
            model.Origem = "Brasil (lugar de nascença é provável que seja Tailândia)";
            model.GolpesEspeciaisFamosos = "Eletric Thunder, Rolling Attack";
            model.Oculto = false;
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


        private void PoupularListaOrigem()
        {
            ViewData["ListaOrigem"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "PRU", Text = "Peru"},
                new SelectListItem() { Value = "JAP", Text = "Japão"},
                new SelectListItem() { Value = "CAN", Text = "Canada"},
                new SelectListItem() { Value = "IND", Text = "India"},
                new SelectListItem() { Value = "NEZ", Text = "Nova Zelandia"},
                new SelectListItem() { Value = "GER", Text = "Alemanha"},
            };
        }
    }
}

