public class ArvoreBinInteiro {

    NoArvoreBinaria<Integer> root = new NoArvoreBinaria<>();

    public void inserir(int num) {
        if (root.getData() == null) {
            root.setData(num);
        } else {
            NoArvoreBinaria<Integer> aux = root;
            NoArvoreBinaria<Integer> novaFolha = new NoArvoreBinaria<>();
            novaFolha.setData(num);

            boolean condition = true;
            do {
                if (num > aux.getData()) {
                    if (aux.getRightChild() != null) {
                        aux = aux.getRightChild();
                    } else {
                        aux.setRightChild(novaFolha);
                        novaFolha.setNoPai(aux);
                        condition = false;
                    }
                } else {
                    if (aux.getLeftChild() != null) {
                        aux = aux.getLeftChild();
                    } else {
                        aux.setLeftChild(novaFolha);
                        novaFolha.setNoPai(aux);
                        condition = false;
                    }
                }
            } while (condition);
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
            default:
                System.out.println("Inválido.");
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
            System.out.println(no.getData());

            if (nivel > 1) {
                listarPercursoEmNiveis(no.getLeftChild(), nivel - 1);
            }

            if (aux > 1) {
                listarPercursoEmNiveis(no.getRightChild(), aux - 1);
            }
        }
    }

    public int retornaMaiorNumero() {
        int maior = 0;
        if (root.getData() != null) {
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
        }

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

    public int retornarAlturaArvore(){

        int altura1 = 0, altura2 = 0;

        if (root.getData() != null) {
            NoArvoreBinaria<Integer> aux = root;
            altura1 = 1;
            altura2 = 2;

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

        return Math.max(altura1, altura2);
    }
    public NoArvoreBinaria retornaRaiz() {
        return root;
    }

}
