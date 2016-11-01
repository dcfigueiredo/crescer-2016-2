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

        public ActionResult FichaTecnica()
        {
            var model = new FichaTecnicaModel();
            model.Nome = "Blanka";
            model.PrimeiraAparicao = "Street Figther II The World Warrior";
            model.Nascimento = new DateTime(1966,02,12);
            model.Altura = 192;
            model.Peso = 96;
            model.Medidas = "B198, C120, Q172";
            model.TipoSanguineo = "B";
            model.HabilidadesEspeciais = new List<String>() { "Caçar", "Eletricidade" };
            model.Gosta = new List<String>() { "Frutas Tropicais", "Piracuru", "Sua Mãe" };
            model.Desgosta = new List<String>() { "Army Ants (Espécide de formiga)" };
            model.EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira";
            model.Origem = "Brasil (lugar de nascença é provável que seja Tailândia)";
            model.FalaVitoria = "Ver você em ação é uma piada";
            model.NickName1 = "A selvagem criança da natureza";
            model.NickName2 = "A animal pessoa amazonica";
            model.NickName3 = "Guerreiro da selva";
            model.Stage1 = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do Rio Madeira: talvez possa ser Mato Grosso, ou Tocantins";
            model.Stage2 = "Bacia do rio Amazonas (Brasil)";
            model.GolpesEspeciaisFamosos = new List<string>() { "Eletric Thunder", "Rolling Attack" };
            return View(model);
        }

        public ActionResult Sobre()
        {
            var model = new FichaTecnicaModel();
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
    }
}