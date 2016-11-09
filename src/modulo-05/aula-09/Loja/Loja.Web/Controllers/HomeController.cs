using Loja.Dominio;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Produtos()
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            IList<Produto> listaDeProdutos = produtoServico.ListarProdutos();
            ProdutoViewModel model = new ProdutoViewModel(listaDeProdutos);
            return View(model.ListaDeProdutos);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Cadastrar(string nome, decimal valor)
        {

            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produtoACadastrar = new Produto(nome, valor);
            produtoServico.CadastrarProduto(produtoACadastrar);
            ViewBag.Mensagem = "Produto cadastrado com sucesso";            

            return RedirectToAction("Produtos");
        }

        public ActionResult Editar()
        {
            return View();
        }
    }
}