package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.exceptions.*;
import br.com.ed2.arvorebinaria.buscagenerica.interfaces.ArvoreBinBusca;

import java.util.Comparator;
import java.util.Iterator;

//Classe que implementa a ‘interface’ ArvoreBinBusca para representar uma árvore binária de busca.
public class ArvoreBuscaEncadeada<E extends Comparable<E>> implements ArvoreBinBusca<E> {
    //Posição do nó inicial
    PosicaoArvoreBin<E> root;

    int tamanho = 0;

    public int tamanho() {
        //Retorna a quantidade de nodos da Árvore.
        return tamanho;
    }

    public boolean estaVazia() {
        //Verifica se a Árvore está vazia. Se estiver vazia retorna true, caso contrário retorna false.
        return tamanho > 0;
    }

    public Iterator<E> iterator() {
        //Retorna um iterator dos nodos armazenados na Árvore.
        return null;
    }

    public Iterable<Posicao<E>> posicoes() {
        //Retorna uma coleção navegável de nodos da Árvore.
        return null;
    }

    public E substituir(Posicao<E> posicao, E elemento) throws PosicaoInvalidaException {
        //Substitui o elemento armazenado na posição especificada.
        return elemento;
    }

    public Posicao<E> getRaiz() throws ArvoreVaziaException {
        //Retorna a raiz da Árvore.
        return null;
    }

    public Posicao<E> pai(Posicao<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        //Retorna o pai de um determinado nodo.
        return posicao;
    }

    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) throws PosicaoInvalidaException {
        //Retorna uma coleção navegável contendo os filhos de um determinado nodo.
        Iterator<E> i = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };

        return (Iterable<Posicao<E>>) i;
    }

    public boolean ehInterno(Posicao<E> posicao) throws PosicaoInvalidaException {
        // Verifica se a posição do elemento representa um nó é interno. Se for um nó
        //  interno retorna true, caso contrário retorna false.
        return false;
    }

    public boolean ehFolha(Posicao<E> posicao) throws PosicaoInvalidaException {
        // Verifica se a posição do elemento representa um nó folha. Se for um nó folha
        //retorna true, caso contrário retorna false
        if (root.getData() == null && tamanho == 0) {
            throw new PosicaoInvalidaException("Pilha Vazia.");
        } else {
            PosicaoArvoreBin<E> aux = root;
            do {
                if (aux.compareTo((PosicaoArvoreBin<E>) posicao) > 0) {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        ;
                        return true;
                    }
                } else if (posicao.compareTo(aux) < 0) {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        aux.setLeftChild(posicao);
                        posicao.setNoPai(aux);
                        return true;
                    }
                } else {
                    return false;
                }
            } while (true);
        }

        return false;
    }

    public boolean ehRaiz(Posicao<E> posicao) throws PosicaoInvalidaException {
        //Verifica se a posição do elemento é a raiz da Árvore. Se for a raiz da Árvore
        //retorna true, caso contrário retorna false.
        if (posicao.equals(root)) {
            return true;
        }
        return false;
    }

    public PosicaoArvoreBin<E> filhoEsq(PosicaoArvoreBin<E> posicao) throws
            PosicaoInvalidaException, LimiteVioladoException {
        //Retorna o filho esquerdo de uma determinada posição na árvore binária.
        PosicaoArvoreBin<E> n = new PosicaoArvoreBin<>();
        return n;
    }

    public PosicaoArvoreBin<E> filhoDir(PosicaoArvoreBin<E> posicao) throws
            PosicaoInvalidaException, LimiteVioladoException {
        //Retorna o filho direito de uma determinada posição na árvore binária.
        PosicaoArvoreBin<E> n = new PosicaoArvoreBin<>();
        return n;
    }

    public boolean existeFilhoEsq(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        //Verifica se existe filho esquerdo em uma determinada posição na árvore binária.
        return false;
    }

    public boolean existeFilhoDir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        //Verifica se existe filho direito em uma determinada posição na árvore binária.
        return false;
    }

    public boolean ehFilhoEsq(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws
            PosicaoInvalidaException {
        //Verifica se a posição é filho esquerdo do pai.
        return false;
    }

    public boolean ehFilhoDir(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws
            PosicaoInvalidaException {
        //Verifica se a posição é filho direito do pai.
        return false;
    }

    public boolean inserir(PosicaoArvoreBin<E> posicao) throws
            ArvoreNaoVaziaException, PosicaoInvalidaException, ArvoreVaziaException {
        //Insere uma nova posição na árvore binária de busca, garantindo propriedade.
        if (root.getData() == null && tamanho == 0) {
            root = posicao;
        } else {
            PosicaoArvoreBin<E> aux = root;
            do {
                if (posicao.compareTo(aux) > 0) {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        aux.setRightChild(posicao);
                        posicao.setNoPai(aux);
                        return true;
                    }
                } else if (posicao.compareTo(aux) < 0) {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        aux.setLeftChild(posicao);
                        posicao.setNoPai(aux);
                        return true;
                    }
                } else {
                    return false;
                }
            } while (true);
        }

        return false;
    }

    public boolean remover(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        //Remove uma posição da árvore binária de busca, garantindo sua propriedade.
        return false;
    }

    protected PosicaoArvoreBin<E> maior(PosicaoArvoreBin<E> posicao) {
        //Busca o nó com a maior chave na subárvore esquerda de um determino nó.
        PosicaoArvoreBin<E> n = new PosicaoArvoreBin<>();
        return n;
    }

    private void removerComDoisFilhos(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
        //Remove um nó que possui dois filhos.
    }

    private void removerFilhoUnico(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
        //Remove um nó que possui um único filho.
    }

    private void removerFolha(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
        //Remove um nó que não possui filhos.
    }

    public PosicaoArvoreBin<E> busca(Posicao<E> posicao) {
        //Busca um determinado nó na árvore.

        PosicaoArvoreBin<E> n = new PosicaoArvoreBin<>();
        return n;
    }

    public boolean existe(Posicao<E> posicao) {
        //Verifica se um determinado nó existe na árvore.
        return false;
    }


}
