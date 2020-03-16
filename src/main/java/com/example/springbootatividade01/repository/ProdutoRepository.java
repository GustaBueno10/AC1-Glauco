package com.example.springbootatividade01.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.springbootatividade01.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository // Indica ao spring que esta classe eh um repository.
public class ProdutoRepository {

    // VARIAVEIS
    public HashMap<Integer, Produto> HmProds = new HashMap<Integer, Produto>();
    public ArrayList<Produto> prods;

    // CONSTRUTORES
    public ProdutoRepository(){
        HmProds.put(0, new Produto(0, "Arroz", 2.56, 187));
        HmProds.put(1, new Produto(1, "feijão", 2.30, 163));
        HmProds.put(2, new Produto(2, "Batata", 1.40, 167));
        HmProds.put(3, new Produto(3, "Maça", 1.10, 190));
        HmProds.put(4, new Produto(4, "Tomate", 1.45, 87));
        HmProds.put(5, new Produto(5, "Cenora", 1.50, 130));
        HmProds.put(6, new Produto(6, "Laranja", 1.15, 107));
        HmProds.put(7, new Produto(7, "Peixe", 3.99, 174));
        HmProds.put(8, new Produto(8, "Suco", 1.50, 83));
        HmProds.put(9, new Produto(9, "Banana", 1.49, 106));
    }

    // METODOS
    public Produto getProdutoById(int id){ // Retorna o produto com o id indicado.
        return HmProds.get(id);
    }

    public ArrayList<Produto> getProdutos(){ // Retorna todos os produtos cadastrados.
        prods = new ArrayList<Produto>(); // Inicia a lista de produtos.

        for(Map.Entry<Integer, Produto> hm: HmProds.entrySet()){ // Passa todos os produtos do hashmap para o arraylist.
            prods.add(hm.getValue());
        }

        return prods; // Retorna a lista de produtos.
    }
    
}