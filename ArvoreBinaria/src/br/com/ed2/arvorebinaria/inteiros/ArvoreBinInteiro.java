package br.com.ed2.arvorebinaria.inteiros;

public class ArvoreBinInteiro {

    NoArvoreBinaria<Integer> root = new NoArvoreBinaria<>();

    public void inserir(int num) {
        if (root.getData() == null) {
            root.setData(num);
        } else {
            NoArvoreBinaria<Integer> aux = root;
            NoArvoreBinaria<Integer> novaFolha = new NoArvoreBinaria<>();
            novaFolha.setData(num);

            do {
                if (num > aux.getData()) {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        aux.setRightChild(novaFolha);
                        novaFolha.setNoPai(aux);
                        return;
                    }
                } else {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        aux.setLeftChild(novaFolha);
                        novaFolha.setNoPai(aux);
                        return;
                    }
                }
            } while (true);
        }
    }

    public void listarArvore(int... n) {
        switch (n[0]) {
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
                listarPercursoEmNiveis(root, n[1]);
                break;
            case 5:
                listarNumerosInternos(root);
                break;
            case 6:
                listarFolhas(root);
                break;
            default:
                System.out.println("Inválido.");
        }
    }

    public void listarNumerosInternos(NoArvoreBinaria<Integer> no) {
        if (no != null) {
            //Possui dois filhos
            //if (no.getRightChild() != null && no.getLeftChild() != null) {
            //Possui ao menos um filho

            if (no.getRightChild() != null || no.getLeftChild() != null) {
                System.out.print(no.getData() + " ");
            }
            listarNumerosInternos(no.getLeftChild());
            listarNumerosInternos(no.getRightChild());
        }
    }

    private void listarFolhas(NoArvoreBinaria<Integer> no) {
        if (no != null) {
            if (no.getRightChild() == null & no.getLeftChild() == null) {
                System.out.print(no.getData() + " ");
            }
            listarFolhas(no.getLeftChild());
            listarFolhas(no.getRightChild());
        }
    }

    private void listarPreOrdem(NoArvoreBinaria<Integer> no) {
        if (no != null) {
            System.out.print(no.getData() + " ");
            listarPreOrdem(no.getLeftChild());
            listarPreOrdem(no.getRightChild());
        }
    }

    private void listarPosOrdem(NoArvoreBinaria<Integer> no) {
        if (no != null) {
            listarPosOrdem(no.getLeftChild());
            listarPosOrdem(no.getRightChild());
            System.out.print(no.getData() + " ");
        }
    }

    private void listarSimetrico(NoArvoreBinaria<Integer> no) {
        if (no != null) {
            listarSimetrico(no.getLeftChild());
            System.out.print(no.getData() + " ");
            listarSimetrico(no.getRightChild());
        }
    }

    public void listarPercursoEmNiveis(NoArvoreBinaria<Integer> no, int nivel) {
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

    public void exibirCaminho(int num) {
        if (root.getData() == null) {
            return;
        }

        NoArvoreBinaria<Integer> aux = root;

        System.out.print(aux.getData() + " ");

        while (aux.getData() != num) {
            if (num > aux.getData()) {
                if (aux.getRightChild() != null) {
                    aux = aux.getRightChild();
                } else {
                    return;
                }
            } else {
                if (aux.getLeftChild() != null) {
                    aux = aux.getLeftChild();
                } else {
                    return;
                }
            }
            System.out.print(aux.getData() + " ");

        }
    }

    public int retornaMaiorNumero() {
        int maior = 0;
        if (root.getData() == null) {
            return maior;
        }
        NoArvoreBinaria<Integer> aux = root;
        maior = root.getData();

        do {
            if (aux.getRightChild() != null) {
                aux = aux.getRightChild();
                if (aux.getData() > maior) {
                    maior = aux.getData();
                }
            } else {
                aux = null;
            }
        } while (aux != null);

        return maior;
    }

    public int retornaMenorNumero() {
        int menor = 0;
        if (root.getData() != null) {
            NoArvoreBinaria<Integer> aux = root;
            menor = root.getData();

            do {
                if (aux.getLeftChild() != null) {
                    aux = aux.getLeftChild();
                    if (aux.getData() < menor) {
                        menor = aux.getData();
                    }
                } else {
                    aux = null;
                }
            } while (aux != null);
        }

        return menor;
    }

    public int retornarAlturaArvore() {
        int altura1 = 0, altura2 = 0;

        if (root.getData() != null) {
            NoArvoreBinaria<Integer> aux = root;
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

        return Math.max(altura1, altura2)-1;
    }

    public int retornaRaiz() {
        if (root.getData() != null) {
            return root.getData();
        } else {
            System.out.println("Árvore vazia.");
            return 0;
        }
    }

}
