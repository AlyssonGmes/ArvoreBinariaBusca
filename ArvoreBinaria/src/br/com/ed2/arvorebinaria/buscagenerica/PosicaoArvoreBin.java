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


    public PosicaoArvoreBin<T> getRightChild() {
        return rightChild;
    }

    @Override
    public Posicao<T> getFather() {
        return father;
    }

    public void setFather(Posicao<T> father) {
        this.father = father;
    }

    public void setLeftChild(PosicaoArvoreBin leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(PosicaoArvoreBin rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public void setData(Object elemento) {
        data = (T) elemento;
    }
}
