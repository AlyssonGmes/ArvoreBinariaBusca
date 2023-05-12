package br.com.ed2.arvorebinaria.buscagenerica.interfaces;

import br.com.ed2.arvorebinaria.buscagenerica.PosicaoArvoreBin;

public interface Posicao <E>{
    public E getData();
    public Posicao<E> getFather();
    public Posicao<E> getLeftChild();
    public Posicao<E> getRightChild();

    public void setLeftChild(PosicaoArvoreBin leftChild);
    public void setRightChild(PosicaoArvoreBin leftChild);

    public void setData(E elemento);
}
