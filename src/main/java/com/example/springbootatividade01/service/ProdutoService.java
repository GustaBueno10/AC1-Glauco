package com.example.springbootatividade01.service;

import java.util.ArrayList;

import com.example.springbootatividade01.model.Produto;
import com.example.springbootatividade01.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service // Indica ao spring que esta classe eh um service.
public class ProdutoService {

    // VARIAVEIS
    @Autowired  // Injecao de dependência.
    private ProdutoRepository pr;

    // METODOS
    public Produto getProduto(int id){ // devolve o produto e se não existir devolve uma mensagem de erro que deve ser apresentado em uma view.
        Produto produto = pr.getProdutoById(id); // Recebe o produto pelo id indicado, caso o produto nao exista, recebe null.

        return produto;
    }

    public ArrayList<Produto> getProdutosEmEstoque(){ // Devolve somente os produtos em estoque.
        ArrayList<Produto> produtos = pr.getProdutos(); // Recebe todos os produtos.
        ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>(); // Lista para produtos em estoque.

        if(!produtos.isEmpty()){ // Caso exista produtos cadastrados.
            for(Produto p: produtos){ // Move todos os produtos em estoque para a lista de protudos em estoque.
                if(p.getEstoque() > 0){
                    produtosEmEstoque.add(p);
                }
            }
        }
        else{ // Caso nao tenha nenhum produto cadastrado.
            produtosEmEstoque = null;
        }

        return produtosEmEstoque;
    }

    public ArrayList<Produto> getProdutosByValorAcima(double valor){ // Devolve todos os produtos acima do valor passado.
        ArrayList<Produto> produtos = pr.getProdutos(); // Recebe todos os produtos.
        ArrayList<Produto> produtosValAcima = new ArrayList<Produto>(); // Lista para produtos acima do valor passado.

        if(!produtos.isEmpty()){ // Caso exista produtos cadastrados.
            for(Produto p: produtos){ // Adiciona a lista de produtos acima do valor todos os produtos que estao acima do valor.
                if(p.getValor() > valor){
                    produtosValAcima.add(p);
                }
            }

            if(produtosValAcima.isEmpty()){ // Se nenhum produto abaixo do valor escolhido foi encontrado.
                produtosValAcima = null;
            }
        }
        else{ // Caso nao tenha nenhum produto cadastrado.
            produtosValAcima = null;
        }

        return produtosValAcima;
    }

    public ArrayList<Produto> getProdutosByValorAbaixo(double valor){ // Devolve todos os produtos abaixo de um valor passado.
        ArrayList<Produto> produtos = pr.getProdutos(); // Recebe todos os produtos.
        ArrayList<Produto> produtosValAbaixo = new ArrayList<Produto>(); // Lista para produtos abaixo do valor passado.

        if(!produtos.isEmpty()){ // Caso exista produtos cadastrados.
            for(Produto p: produtos){ // Adiciona a lista de produtos abaixo do valor todos os produtos que estao abaixo do valor.
                if(p.getValor() < valor){
                    produtosValAbaixo.add(p);
                }
            }
            
            if(produtosValAbaixo.isEmpty()){ // Se nenhum produto abaixo do valor escolhido foi encontrado.
                produtosValAbaixo = null;
            }
        }
        else{ // Caso nao tenha nenhum produto cadastrado.
            produtosValAbaixo = null;
        }

        return produtosValAbaixo;
    }

}