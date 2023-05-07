package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.exceptions.*;
import br.com.ed2.arvorebinaria.buscagenerica.interfaces.ArvoreBinBusca;
import br.com.ed2.arvorebinaria.buscagenerica.interfaces.Posicao;
import br.com.ed2.arvorebinaria.inteiros.NoArvoreBinaria;

import java.util.Iterator;

//Classe que implementa a ‘interface’ ArvoreBinBusca para representar uma árvore binária de busca.
public class ArvoreBuscaEncadeada<E extends Comparable<E>> implements ArvoreBinBusca<E> {
    PosicaoArvoreBin<E> root;
    int tamanho = 0;

    public int tamanho() {
        return tamanho;
    }

    // Retorna a quantidade de nodos da Árvore.
    public boolean estaVazia() {
        return root == null;
    }

    // Verifica se a Árvore está vazia. Se estiver vazia retorna true, caso contrário
    //retorna false.
    public Iterator<E> iterator() {
        return null;
    }

    //  Retorna um iterator dos nodos armazenados na Árvore.
    public Iterable<Posicao<E>> posicoes() {
        return null;
    }

    //  Retorna uma coleção navegável de nodos da Árvore.
    public E substituir(Posicao<E> posicao, E elemento) throws PosicaoInvalidaException {
        return null;
    }

    //   Substitui o elemento armazenado na posição especificada.
    public Posicao<E> getRaiz() throws ArvoreVaziaException {
        return root;
    }

    //  Retorna a raiz da Árvore.
    public Posicao<E> pai(Posicao<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if(posicao == null){
            throw new PosicaoInvalidaException("Posição Inválida.");
        }else if(posicao == root){
            throw new LimiteVioladoException("Limite Violado.");
        }

        return posicao.getFather();
    }

    //  Retorna o pai de um determinado nodo.
    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) throws PosicaoInvalidaException {
        return null;
    }
    //   Retorna uma coleção navegável contendo os filhos de um determinado nodo.

    public boolean ehInterno(Posicao<E> posicao) throws PosicaoInvalidaException {
        return false;
    }

    //   Verifica se a posição do elemento representa um nó é interno. Se for um nó
    //   interno retorna true, caso contrário retorna false.
    public boolean ehFolha(Posicao<E> posicao) throws PosicaoInvalidaException {
        return false;
    }

    //   Verifica se a posição do elemento representa um nó folha. Se for um nó folha
    //   retorna true, caso contrário retorna false.
    public boolean ehRaiz(Posicao<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        }

        return posicao == root;
    }

    //   Verifica se a posição do elemento é a raiz da Árvore. Se for a raiz da Árvore
    //   retorna true, caso contrário retorna false.
    public PosicaoArvoreBin<E> filhoEsq(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao Inválida");
        } else if (posicao.getRightChild() == null) {
            throw new LimiteVioladoException("Limite violado.");
        } else {
            return posicao.getLeftChild();
        }
    }

    //   Retorna o filho esquerdo de uma determinada posição na árvore binária.
    public PosicaoArvoreBin<E> filhoDir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao Inválida");
        } else if (posicao.getRightChild() == null) {
            throw new LimiteVioladoException("Limite violado.");
        } else {
            return posicao.getRightChild();
        }
    }

    //  Retorna o filho direito de uma determinada posição na árvore binária.
    public boolean existeFilhoEsq(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao inválida.");
        } else {
            if (posicao.getLeftChild() != null) {
                return true;
            }
        }
        return false;
    }

    //   Verifica se existe filho esquerdo numa determinada posição na árvore binária.
    public boolean existeFilhoDir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao inválida.");
        } else {
            if (posicao.getRightChild() != null) {
                return true;
            }
        }
        return false;
    }

    //   Verifica se existe filho direito numa determinada posição na árvore binária.
    public boolean ehFilhoEsq(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws PosicaoInvalidaException {
        if (pai == null || filho == null || pai.getLeftChild() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        } else {
            return pai.getLeftChild().equals(filho);
        }
    }

    //  Verifica se a posição é filho esquerdo do pai.
    public boolean ehFilhoDir(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws PosicaoInvalidaException {
        if (pai == null || filho == null || pai.getRightChild() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        } else {
            return pai.getRightChild().equals(filho);
        }
    }

    //Verifica se a posição é filho direito do pai.
    public boolean inserir(PosicaoArvoreBin<E> posicao) throws ArvoreNaoVaziaException, PosicaoInvalidaException, ArvoreVaziaException {
        if (root == null) {
            root = posicao;
        } else {
            PosicaoArvoreBin<E> aux = root;
            do {
                if (posicao.getData().compareTo(aux.getData()) > 0) {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        posicao.setFather(aux);
                        aux.setRightChild(posicao);
                        return true;
                    }
                } else {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        posicao.setFather(aux);
                        aux.setLeftChild(posicao);
                        return true;
                    }
                }
            } while (true);
        }
        return false;
    }
    //  Insere uma nova posição na árvore binária de busca, garantindo a sua propriedade.

    @Override
    public boolean remover(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        return false;
    }

    //  Remove uma posição da árvore binária de busca, garantindo a sua propriedade.
    protected PosicaoArvoreBin<E> maior(PosicaoArvoreBin<E> posicao) {
        return null;
    }

    //  Busca o nó com a maior chave na subárvore esquerda de um determino nó.
    private void removerComDoisFilhos(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
    }

    // Remove um nó que possui dois filhos.
    private void removerFilhoUnico(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
    }

    //Remove um nó que possui um único filho.
    private void removerFolha(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {
    }

    // Remove um nó que não possui filhos.
    public PosicaoArvoreBin<E> busca(Posicao<E> posicao) {
        return new PosicaoArvoreBin<>();
    }

    // Busca um determinado nó na árvore.
    public boolean existe(Posicao<E> posicao) {
        return false;
    }
    // Verifica se um determinado nó existe na árvore.
}
