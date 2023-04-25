import java.util.Scanner;

public class TesteArvoreBinInteiro {

    public void menu() {
        ArvoreBinInteiro test = new ArvoreBinInteiro();

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

        System.out.println("Opção: ");
        int opcao = scn.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o número: ");
                test.inserir(scn.nextInt());
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 0:

                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}
