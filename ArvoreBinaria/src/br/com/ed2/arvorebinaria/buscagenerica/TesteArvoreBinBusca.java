package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.inteiros.ArvoreBinInteiro;

import java.util.Scanner;

public class TesteArvoreBinBusca {
    public static void menu() {
        //Falta a instância do objeto ArvoreBinBusca

        do {
            Scanner scn = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Inserir um número");
            System.out.println("2. Retornar o maior número");
            System.out.println("3. Retornar o menor número");
            System.out.println("4. Retornar a altura da árvore");
            System.out.println("5. Listar números (percurso Pré - Ordem)");
            System.out.println("6. Listar números (percurso Pós - Ordem)");
            System.out.println("7. Listar números (percurso Simétrico)");
            System.out.println("8. Listar números (percurso em níveis)");

            switch (scn.nextInt()) {
                case 1:
                    System.out.print("Digite o número: ");

                    break;
                case 2:
                    System.out.println("O maior número: " + 0);
                    break;
                case 3:
                    System.out.println("O menor número: " + 0);
                    break;
                case 4:
                    System.out.println("A altura da árvore: " + 0);
                    break;
                case 5:
                    System.out.print("Percurso Pré-Ordem: ");

                    System.out.println();
                    break;
                case 6:
                    System.out.print("Percurso Pós-Ordem: ");

                    System.out.println();
                    break;
                case 7:
                    System.out.print("Percurso Simétrico: ");

                    System.out.println();
                    break;
                case 8:
                    System.out.print("Digite até qual nível: ");

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
