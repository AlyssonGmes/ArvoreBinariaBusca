package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.exceptions.*;
import br.com.ed2.arvorebinaria.buscagenerica.interfaces.ArvoreBinBusca;
import br.com.ed2.arvorebinaria.buscagenerica.interfaces.Posicao;

import java.util.Iterator;
import java.util.Scanner;

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
        if (posicao == null || elemento == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        }

        if (posicao != root) {
            if (posicao.getFather().getLeftChild() != null && posicao == posicao.getFather().getLeftChild()) {
                if (elemento.compareTo(posicao.getFather().getData()) >= 0) {
                    throw new PosicaoInvalidaException("Posicao Inválida.");
                }
            }
            if (posicao.getFather().getRightChild() != null && posicao == posicao.getFather().getRightChild()) {
                if (elemento.compareTo(posicao.getFather().getData()) < 0) {
                    throw new PosicaoInvalidaException("Posicao Inválida.");
                }
            }
        } else {
            if (posicao.getRightChild() != null && elemento.compareTo(posicao.getRightChild().getData()) >= 0) {
                throw new PosicaoInvalidaException("Posicao Inválida.");
            }
            if (posicao.getLeftChild() != null && elemento.compareTo(posicao.getLeftChild().getData()) < 0) {
                throw new PosicaoInvalidaException("Posicao Inválida.");
            }
        }

        E temp = posicao.getData();
        posicao.setData(elemento);
        return temp;
    }


    //   Substitui o elemento armazenado na posição especificada.
    public Posicao<E> getRaiz() throws ArvoreVaziaException {
        return root;
    }

    //  Retorna a raiz da Árvore.
    public Posicao<E> pai(Posicao<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posição Inválida.");
        } else if (posicao == root) {
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
        if (posicao.getRightChild() != null || posicao.getLeftChild() != null) {
            return true;
        } else {
            return false;
        }
    }

    //   Verifica se a posição do elemento representa um nó é interno. Se for um nó
    //   interno retorna true, caso contrário retorna false.
    public boolean ehFolha(Posicao<E> posicao) throws PosicaoInvalidaException {
        if (posicao.getRightChild() == null && posicao.getLeftChild() == null) {
            return true;
        } else {
            return false;
        }
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
        if (pai == null || filho == null || pai.getRightChild() != filho) {
            throw new PosicaoInvalidaException("Posicao Inválida: pai não tem filho direito ou as posições informadas são inválidas.");
        } else {
            return true;
        }
    }


    //Verifica se a posição é filho direito do pai.
    public boolean inserir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException, ArvoreVaziaException {
        if (root == null) {
            root = posicao;
        } else {
            PosicaoArvoreBin<E> aux = root;
            do {
                if (posicao.getData().compareTo(aux.getData()) < 0) {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        posicao.setFather(aux);
                        aux.setLeftChild(posicao);
                        return true;
                    }
                } else {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        posicao.setFather(aux);
                        aux.setRightChild(posicao);
                        return true;
                    }
                }
            } while (true);
        }
        return false;
    }

    //  Insere uma nova posição na árvore binária de busca, garantindo a sua propriedade.

    private PosicaoArvoreBin<E> sucessor(PosicaoArvoreBin<E> posicao) {
        PosicaoArvoreBin<E> sucessor = posicao.getRightChild();
        while (sucessor.getLeftChild() != null) {
            sucessor = sucessor.getLeftChild();
        }
        return sucessor;
    }


    //  Remove uma posição da árvore binária de busca, garantindo a sua propriedade.
    protected PosicaoArvoreBin<E> maior(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null || posicao.getLeftChild() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida");
        }

        PosicaoArvoreBin<E> aux = posicao.getLeftChild();
        PosicaoArvoreBin<E> maior = aux;

        while (aux.getRightChild() != null) {
            aux = aux.getRightChild();
            if (aux.getData().compareTo(maior.getData()) > 0) {
                maior = aux;
            }
        }

        return maior;
    }

    // Busca o nó com a maior chave na subárvore direita de um determinado nó.
    @Override
    public boolean remover(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        return false;
    }

    private void removerComDoisFilhos(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }


    // Remove um nó que possui dois filhos.
    private void removerFilhoUnico(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }

    //Remove um nó que possui um único filho.
    private void removerFolha(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }
    // Remove um nó que não possui filhos.

    /*    PosicaoArvoreBin aux = busca(no);
        if (aux.getFather().getLeftChild() != null) {
        if (aux.getFather().getLeftChild().equals(no)) {
            aux.getFather().setLeftChild(null);
        }else{
            aux.getFather().setRightChild(null);
        }
    }*/

    public PosicaoArvoreBin<E> busca(Posicao<E> posicao) {
        if (root == null) {
            return null;
        }

        PosicaoArvoreBin<E> aux = root;

        while (aux != null) {
            if (posicao.getData().compareTo(aux.getData()) >= 0) {
                if (aux.getRightChild() != null) {
                    aux = aux.getRightChild();
                } else {
                    return aux;
                }
            } else {
                if (aux.getLeftChild() != null) {
                    aux = aux.getLeftChild();
                } else {
                    return aux;
                }
            }
        }

        return null;
    }

    // Busca um determinado nó na árvore.
    public boolean existe(Posicao<E> posicao) {
        if (root == null) {
            return false;
        }

        PosicaoArvoreBin<E> aux = root;

        while (aux != null) {
            if (posicao.getData().compareTo(aux.getData()) >= 0) {
                if (aux.getRightChild() != null) {
                    aux = aux.getRightChild();
                } else {
                    return true;
                }
            } else {
                if (aux.getLeftChild() != null) {
                    aux = aux.getLeftChild();
                } else {
                    return true;
                }
            }
        }

        return false;
    }
    // Verifica se um determinado nó existe na árvore.

    //novos
    public void listarArvore(int n) {
        switch (n) {
            case 1:
                listarPreOrdem(root);
                break;
            case 2:
                listarPosOrdem(root);
                break;
            case 3:
                listarSimetrico(root);
                break;
            case 4:
                System.out.print("Até qual nível? ");
                listarPercursoEmNiveis(root, new Scanner(System.in).nextInt());
                break;
            case 5:
                listaNosInternos(root);
                break;
            case 6:
                listarFolhas(root);
                break;
            default:
                System.out.println("Inválido.");
        }
    }

    public void listaNosInternos(PosicaoArvoreBin<E> no) {
        if (no != null) {
            // Verifica se o nó atual tem filhos
            if (no.getLeftChild() != null || no.getRightChild() != null) {
                System.out.print(no.getData() + " ");
            }
            listaNosInternos(no.getLeftChild());
            listaNosInternos(no.getRightChild());
        }
    }

    private void listarFolhas(PosicaoArvoreBin<E> no) {
        if (no != null) {
            if (no.getLeftChild() == null && no.getRightChild() == null) {
                System.out.print(no.getData() + " ");
            }
            listarFolhas(no.getLeftChild());
            listarFolhas(no.getRightChild());
        }
    }

    private void listarPreOrdem(PosicaoArvoreBin<E> no) {
        if (no != null) {
            System.out.print(no.getData() + " ");
            listarPreOrdem(no.getLeftChild());
            listarPreOrdem(no.getRightChild());
        }
    }

    private void listarPosOrdem(PosicaoArvoreBin<E> no) {
        if (no != null) {
            listarPosOrdem(no.getLeftChild());
            listarPosOrdem(no.getRightChild());
            System.out.print(no.getData() + " ");
        }
    }

    private void listarSimetrico(PosicaoArvoreBin<E> no) {
        if (no != null) {
            listarSimetrico(no.getLeftChild());
            System.out.print(no.getData() + " ");
            listarSimetrico(no.getRightChild());
        }
    }


    public void listarPercursoEmNiveis(PosicaoArvoreBin<E> no, int nivel) {
        int aux = nivel;

        if (root.getData() == null) {
            return;
        }

        if (no != null) {
            System.out.print(no.getData() + " ");

            if (nivel > 1) {
                listarPercursoEmNiveis(no.getLeftChild(), nivel - 1);
            }

            if (aux > 1) {
                listarPercursoEmNiveis(no.getRightChild(), aux - 1);
            }
        }
    }

    public int retornarAlturaArvore() {
        int altura1 = 0, altura2 = 0;

        if (root.getData() != null) {
            PosicaoArvoreBin<E> aux = root;
            altura1 = 1;
            altura2 = 1;

            do {
                if (aux.getLeftChild() != null) {
                    aux = aux.getLeftChild();
                    altura1++;
                } else {
                    aux = null;
                }
            } while (aux != null);

            aux = root;
            do {
                if (aux.getRightChild() != null) {
                    aux = aux.getRightChild();
                    altura2++;
                } else {
                    aux = null;
                }
            } while (aux != null);
        }

        return Math.max(altura1, altura2) - 1;
    }

}
