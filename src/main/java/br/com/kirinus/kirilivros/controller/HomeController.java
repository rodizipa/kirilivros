package br.com.kirinus.kirilivros.controller;

import br.com.kirinus.kirilivros.model.Produto;
import br.com.kirinus.kirilivros.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public HomeController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/")
    public String helloWorld(Model model){
        List<Produto> lista = produtoRepository.findAll();
        model.addAttribute("produtos", lista);
        return "home";
    }
}
