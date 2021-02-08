package br.com.kirinus.kirilivros.dto;

import br.com.kirinus.kirilivros.model.Produto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class RequisicaoProdutoDTO {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String autor;
    private BigDecimal preco;
    private String url;
    private String sinopse;
    private String imagem;

    public Produto toPedido() {
        Produto produto = new Produto();
        produto.setNome(this.nomeProduto);
        produto.setAutor(this.autor);
        produto.setPreco(this.preco);
        produto.setUrl(this.url);
        produto.setSinopse(this.sinopse);
        produto.setImagem(this.imagem);
        return produto;
    }
}
