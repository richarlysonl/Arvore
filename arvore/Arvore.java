package arvore;

import java.util.*;

public class Arvore {
    No raiz;
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }
    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else {
            raiz.direita = inserirRec(raiz.direita, valor);
        }
        return raiz;
    }
    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
    public void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            inOrdem(no.direita);
        }
    }
    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }
    public void emNivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }
    private No removerRec(No raiz, int valor) {
        if (raiz == null) return null;
        if (valor < raiz.valor) {
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerRec(raiz.direita, valor);
        } else {
            // sem filho
            if (raiz.esquerda == null && raiz.direita == null) {
                return null;
            }
            // um filho
            else if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }
            // dois filhos
            else {
                int menor = menorValor(raiz.direita);
                raiz.valor = menor;
                raiz.direita = removerRec(raiz.direita, menor);
            }
        }

        return raiz;
    }
    private int menorValor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no.valor;
    }
}
