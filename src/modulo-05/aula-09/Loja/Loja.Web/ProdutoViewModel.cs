using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web
{
    public class ProdutoViewModel
    {
        public ProdutoViewModel(IList<Produto> listaDeProdutos)
        {
            this.ListaDeProdutos = listaDeProdutos;
        }
        public IList<Produto> ListaDeProdutos { get; set; }
    }
}