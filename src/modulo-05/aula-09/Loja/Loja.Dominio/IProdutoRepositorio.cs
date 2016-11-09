using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        IList<Produto> ListarProdutos();
        void CadastrarProduto(Produto produto);
        void EditarProduto(int id);
        void ExcluirProduto(int id);
    }
}
