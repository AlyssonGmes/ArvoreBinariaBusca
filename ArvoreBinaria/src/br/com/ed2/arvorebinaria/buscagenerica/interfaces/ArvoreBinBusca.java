package br.com.ed2.arvorebinaria.buscagenerica.interfaces;

import br.com.ed2.arvorebinaria.buscagenerica.PosicaoArvoreBin;
import br.com.ed2.arvorebinaria.buscagenerica.exceptions.*;

public interface ArvoreBinBusca<E extends Comparable<E>> extends ArvoreBinaria<E>{

    public boolean inserir(PosicaoArvoreBin<E> posicao) throws ArvoreNaoVaziaException, PosicaoInvalidaException, ArvoreVaziaException;
    // Insere uma nova posição na árvore binária de busca, garantindo a sua propriedade

    public boolean remover(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException;
    //Remove uma posição da árvore binária de busca, garantindo a sua propriedade.
}

