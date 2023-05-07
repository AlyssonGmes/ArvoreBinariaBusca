package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.interfaces.Posicao;

public class PosicaoArvoreBin<T extends Comparable<T>> implements Posicao {
    private T data;
    private PosicaoArvoreBin<T> leftChild;
    private PosicaoArvoreBin<T> rightChild;
    private Posicao<T> father;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PosicaoArvoreBin<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(PosicaoArvoreBin<T> leftChild) {
        this.leftChild = leftChild;
    }

    public PosicaoArvoreBin<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(PosicaoArvoreBin<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public Posicao<T> getFather() {
        return father;
    }

    public void setFather(Posicao<T> father) {
        this.father = father;
    }
}
