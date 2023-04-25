public class Main {
    public static void main(String[] args) {
        ArvoreBinInteiro n = new ArvoreBinInteiro();
        n.inserir(10);
        n.inserir(9);
        n.inserir(8);
        n.inserir(5);
        n.inserir(4);
        n.inserir(6);
        n.inserir(2);
        n.inserir(11);
        n.inserir(7);
        n.inserir(12);
        n.inserir(15);
        n.inserir(14);
        n.inserir(17);
        n.inserir(23);
        n.inserir(13);
        //System.out.println(n.retornaMaiorNumero());
        //n.listarArvore(4, 5);
        System.out.println(n.retornarAlturaArvore());
    }
}
