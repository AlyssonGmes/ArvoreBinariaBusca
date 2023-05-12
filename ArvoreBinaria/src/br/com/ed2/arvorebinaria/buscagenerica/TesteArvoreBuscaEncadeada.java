package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.exceptions.ArvoreVaziaException;
import br.com.ed2.arvorebinaria.buscagenerica.exceptions.PosicaoInvalidaException;

import java.util.Scanner;

public class TesteArvoreBuscaEncadeada<E extends Comparable<E>> {
    public void menu() throws ArvoreVaziaException, PosicaoInvalidaException {
        ArvoreBuscaEncadeada<E> test = new ArvoreBuscaEncadeada();

        do {
            Scanner scn = new Scanner(System.in);
            PosicaoArvoreBin<E> n = new PosicaoArvoreBin<>();

            System.out.println("Menu");
            System.out.println("1. Inserir um número");
            System.out.println("2. Excluir um número");
            System.out.println("3. Retornar a altura da árvore");
            System.out.println("4. Listar números (percurso Pré - Ordem)");
            System.out.println("5. Listar números (percurso Pós - Ordem)");
            System.out.println("6. Listar números (percurso Simétrico)");
            System.out.println("7. Listar números (percurso em níveis)");
            System.out.println("8. Listar os números de forma ordenada");
            System.out.println("0. Sair");

            switch (scn.nextInt()) {
                case 1:
                    System.out.print("Digite o número: ");
                    n.setData(scn.nextInt());
                    test.inserir(n);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Excluir um número: ");
                    System.out.println("Não implementado");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("A altura da árvore: ");
                    System.out.println(test.retornarAlturaArvore());
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Percurso Pré-Ordem: ");
                    test.listarArvore(1);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Percurso Pós-Ordem: ");
                    test.listarArvore(2);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Percurso Simétrico: ");
                    test.listarArvore(3);
                    System.out.println();
                    break;
                case 7:
                    test.listarArvore(4);
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Listar os números de forma ordenada: ");
                    System.out.println("Não implementado");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);
    }
}
