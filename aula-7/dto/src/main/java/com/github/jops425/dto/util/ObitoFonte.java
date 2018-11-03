package com.github.jops425.dto.util;

/**
 * Classe óbito fonte.
 * @author joao
 *
 */
public class ObitoFonte {

    /**
     * Código.
     */
    private int codigo;

    /**
     * Descrição.
     */
    private String descricao;

    /**
     * Getter para código.
     * @return O código.
     */
    public final int getCodigo() {
        return codigo;
    }

    /**
     * Setter para código.
     * @param cod O código.
     */
    public final void setCodigo(final int cod) {
        this.codigo = cod;
    }

    /**
     * Getter para descrição.
     * @return Descrição.
     */
    public final String getDescricao() {
        return descricao;
    }

    /**
     * Setter para descrição.
     * @param descr A descrição.
     */
    public final void setDescricao(final String descr) {
        this.descricao = descr;
    }

}
