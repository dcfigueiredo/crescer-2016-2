using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void CadastrarProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Added;
                context.SaveChanges();
            }
        }        

        public void EditarProduto(int id)
        {
            throw new NotImplementedException();
        }        

        public void ExcluirProduto(int id)
        {
            throw new NotImplementedException();
        }

        public IList<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList();
            }
        }
    }
}
