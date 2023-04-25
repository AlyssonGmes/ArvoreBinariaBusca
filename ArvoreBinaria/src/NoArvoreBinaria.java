public class NoArvoreBinaria <T> {
    private T data;
    private NoArvoreBinaria leftChild;
    private NoArvoreBinaria rightChild;
    private NoArvoreBinaria noPai;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NoArvoreBinaria getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NoArvoreBinaria leftChild) {
        this.leftChild = leftChild;
    }

    public NoArvoreBinaria getRightChild() {
        return rightChild;
    }

    public void setRightChild(NoArvoreBinaria rightChild) {
        this.rightChild = rightChild;
    }

    public NoArvoreBinaria getNoPai() {
        return noPai;
    }

    public void setNoPai(NoArvoreBinaria noPai) {
        this.noPai = noPai;
    }
}


