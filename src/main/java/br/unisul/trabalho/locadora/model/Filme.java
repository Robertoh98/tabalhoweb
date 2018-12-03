package br.unisul.trabalho.locadora.model;

import javax.persistence.*;

@Entity
@Table(name = "Filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Codigo;

    private int Quantidade;
    private String Titulo;
    private String Tipo;

    public Filme() {
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
