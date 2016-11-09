using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico : IProdutoRepositorio
    {
        public IProdutoRepositorio ProdutoRepositorio { get; set; }
        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.ProdutoRepositorio = produtoRepositorio;
        }
        public void CadastrarProduto(Produto produto)
        {
            this.ProdutoRepositorio.CadastrarProduto(produto);
        }

        public void EditarProduto(int id)
        {
            this.ProdutoRepositorio.EditarProduto(id);
        }

        public void ExcluirProduto(int id)
        {
            this.ProdutoRepositorio.ExcluirProduto(id);
        }

        public IList<Produto> ListarProdutos()
        {
            return this.ProdutoRepositorio.ListarProdutos();
        }
    }
}
