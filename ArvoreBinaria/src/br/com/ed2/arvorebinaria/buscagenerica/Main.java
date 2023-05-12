package br.com.ed2.arvorebinaria.buscagenerica;

import br.com.ed2.arvorebinaria.buscagenerica.exceptions.ArvoreVaziaException;
import br.com.ed2.arvorebinaria.buscagenerica.exceptions.PosicaoInvalidaException;

public class Main {

    public static void main(String[] args) throws ArvoreVaziaException, PosicaoInvalidaException {
        TesteArvoreBuscaEncadeada n = new TesteArvoreBuscaEncadeada();
        n.menu();

    }

}
