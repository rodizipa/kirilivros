package br.com.kirinus.kirilivros.controller;

import br.com.kirinus.kirilivros.dto.RequisicaoProdutoDTO;
import br.com.kirinus.kirilivros.model.Produto;
import br.com.kirinus.kirilivros.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("novo")
    public String novoProduto(RequisicaoProdutoDTO formProdutoDTO){
        return "produto/novoProduto";
    }

    @PostMapping("save")
    public String salvarProduto(@Valid RequisicaoProdutoDTO formProdutoDTO, BindingResult result){
        if (result.hasErrors()){
            return "produto/novoProduto";
        }

        Produto produto = formProdutoDTO.toPedido();
        produtoRepository.save(produto);
        return "produto/novoProduto";
    }

}
