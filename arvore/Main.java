package arvore;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore();
        Random rand = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt(101);
            numeros.add(num);
            arvore.inserir(num);
        }
        System.out.println("Números inseridos:");
        System.out.println(numeros);

        System.out.println("\nPré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nIn-ordem:");
        arvore.inOrdem(arvore.raiz);

        System.out.println("\nPós-ordem:");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\nEm nível:");
        arvore.emNivel();


        System.out.println("\n\nRemovendo 5 números:");
        for (int i = 0; i < 5; i++) {
            int indice = rand.nextInt(numeros.size());
            int num = numeros.remove(indice);
            System.out.print(num + " ");
            arvore.remover(num);
        }

        System.out.println("Após remoção:");

        System.out.println("\nPré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\nIn-ordem:");
        arvore.inOrdem(arvore.raiz);

        System.out.println("\nPós-ordem:");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\nEm nível:");
        arvore.emNivel();
    }
}