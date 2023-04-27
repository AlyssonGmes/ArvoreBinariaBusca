import java.util.Scanner;

public class TesteArvoreBinInteiro {

    public static void menu() {
        ArvoreBinInteiro test = new ArvoreBinInteiro();

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
            System.out.println("9. Listar os números internos");
            System.out.println("10. Listar as folhas");
            System.out.println("11. Exibir caminho da raiz a um número");
            System.out.println("12. Retorna raiz");
            System.out.println("0. Sair");


            switch (scn.nextInt()) {
                case 1:
                    System.out.print("Digite o número: ");
                    test.inserir(scn.nextInt());
                    break;
                case 2:
                    System.out.println("O maior número: " + test.retornaMaiorNumero());
                    break;
                case 3:
                    System.out.println("O menor número: " + test.retornaMenorNumero());
                    break;
                case 4:
                    System.out.println("A altura da árvore: " + test.retornarAlturaArvore());
                    break;
                case 5:
                    System.out.print("Percurso Pré-Ordem: ");
                    test.listarArvore(1);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Percurso Pós-Ordem: ");
                    test.listarArvore(2);
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Percurso Simétrico: ");
                    test.listarArvore(3);
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Digite até qual nível: ");
                    test.listarArvore(4, scn.nextInt());
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Números internos: ");
                    test.listarArvore(5);
                    System.out.println();
                    break;
                case 10:
                    System.out.print("Folhas: ");
                    test.listarArvore(6);
                    System.out.println();
                    break;
                case 11:
                    int num;
                    System.out.print("Digite o número: ");
                    num = scn.nextInt();
                    System.out.print("Caminho da raiz até " + num + ": ");
                    test.exibirCaminho(num);
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Raiz: " + test.retornaRaiz());
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
