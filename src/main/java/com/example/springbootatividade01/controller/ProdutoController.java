package com.example.springbootatividade01.controller;

import java.util.ArrayList;

import com.example.springbootatividade01.model.Produto;
import com.example.springbootatividade01.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProdutoController
 */
@Controller  // Indica ao spring que esta classe eh um controller.
public class ProdutoController {

    @Autowired // Injecao de dependência.
    private ProdutoService ps;

    @GetMapping("/produto/{id}") // Recebe o id do produto na url.
    public ModelAndView getProduto(@PathVariable("id") int id){ // Seta o id passado na url para a variavel id.
        ModelAndView mv = new ModelAndView("produtoView"); // Seta a view para qual as informacoes serao enviadas.

        Produto prod = ps.getProduto(id); // Recebe o produto passando o id para a camada service.

        mv.addObject("prod", prod); // Adiciona um objeto na view setada.

        return mv; // Manda todos os objetos adicionados para a view setada.
    }

    @GetMapping("/produtosEmEstoque")
    public ModelAndView getProdutosEmEstoque(){
        ModelAndView mv = new ModelAndView("produtosEmEstoqueView"); // Seta a view para qual as informacoes serao enviadas.

        ArrayList<Produto> produtos = ps.getProdutosEmEstoque(); // Recebe um arraylist com todos os produtos em estoque que a camada service mandou.

        mv.addObject("prods", produtos); // Adiciona a lista de produtos em estoque (produtos) na variavel (prods).

        return mv; // Manda todos os objetos adicionados para a view setada.
    }

    @GetMapping("/produtosValorAcima/{val}") // Recebe o valor do produto na url.
    public ModelAndView getProdutosValorAcima(@PathVariable("val") double valorProd){ // Seta o valor passado na url para a variavel valorProd.
        ModelAndView mv = new ModelAndView("produtosValorAcimaView"); // Seta a view para qual as informacoes serao enviadas.

        ArrayList<Produto> prods = ps.getProdutosByValorAcima(valorProd); // Recebe um arraylist com todos os produtos com valores acima do valor passado na url.

        mv.addObject("produtos", prods); // Adiciona a lista de produtos com valores acima ao escolhido (prods) na variavel (produtos).

        return mv; // Manda todos os objetos adicionados para a view setada.
    }

    @GetMapping("/produtosValorAbaixo/{valor}") // Recebe o valor do produto na url.
    public ModelAndView getProdutosValorAbaixo(@PathVariable("valor") double valor){ // Seta o valor passado na url para a variavel valor.
        ModelAndView mv = new ModelAndView("produtosValorAbaixoView"); // Seta a view para qual as informacoes serao enviadas.

        ArrayList<Produto> produtos = ps.getProdutosByValorAbaixo(valor); // Recebe um arraylist com todos os produtos com valores abaixo do valor passado na url.

        mv.addObject("produtos", produtos); // Adiciona a lista de produtos com valores abaixo ao escolhido (produtos) na variavel (produtos).

        return mv; // Manda todos os objetos adicionados para a view setada.
    }

}