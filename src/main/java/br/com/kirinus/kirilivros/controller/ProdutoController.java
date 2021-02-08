package br.com.kirinus.kirilivros.controller;

import br.com.kirinus.kirilivros.dto.RequisicaoProdutoDTO;
import br.com.kirinus.kirilivros.model.Produto;
import br.com.kirinus.kirilivros.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public String novoProduto(@PathVariable("id") Long id, Model model){

        Produto produto = produtoRepository.findById(id).orElse(null);
        model.addAttribute("produto", produto);
        return "produto/produto";
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

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/";
    }
}
