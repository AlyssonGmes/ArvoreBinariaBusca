package br.com.ed2.arvorebinaria.buscagenerica;
public class PosicaoArvoreBin<T extends Comparable<T>> implements Posicao, Comparable<PosicaoArvoreBin<T>> {
    private T data;
    private PosicaoArvoreBin<T> leftChild;
    private PosicaoArvoreBin<T> rightChild;
    private PosicaoArvoreBin<T> noPai;

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

    public PosicaoArvoreBin<T> getNoPai() {
        return noPai;
    }

    public void setNoPai(PosicaoArvoreBin<T> noPai) {
        this.noPai = noPai;
    }

    @Override
    public int compareTo(PosicaoArvoreBin<T> o) {
        return this.data.compareTo(o.getData());
    }
}
