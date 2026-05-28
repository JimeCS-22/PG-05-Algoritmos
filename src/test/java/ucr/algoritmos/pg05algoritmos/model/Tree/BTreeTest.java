package ucr.algoritmos.pg05algoritmos.model.Tree;

/**
 * LAB01 y Lexis son la misma persona pero en computadora diferente, una es en la universidad y la otra desde la casa.
 */

import org.junit.jupiter.api.Test;
import java.util.Random;

class BTreeTest {

    @Test
    public void insert() {
        BTree <Integer> bTree= new BTree();
        System.out.println("Crear un árbol binario númerico");
        for (int i = 0; i < 100; i++) {

            int value = new Random().nextInt(200, 500);
            bTree.add(value);

        }
        System.out.println(bTree);

        //Árbol con el abecedario
        BTree <Character> bTreeAlphabet= new BTree();
        System.out.println("Crear un arbol con las letras del alfabeto");
        for (char c= 'A'; c<= 'Z'; c++) {

            bTreeAlphabet.add(c);

        }

        //Árbol on nombres de personas
        BTree <String> bTreeName= new BTree();
        System.out.println("Crear un árbol con nombres");
        String [] names = {"Ana", "Laura", "Luis", "Jorge", "Sofia", "Sarah", "Carlos", "José", "Ariana", "David"};
        for(String n: names) bTreeName.add(n);

        //Mostrar los recorridos por consola
        System.out.println("Árbol númerico");
        System.out.println(bTree);
        System.out.println();

        System.out.println("Árbol del alfabeto");
        System.out.println(bTreeAlphabet);
        System.out.println();

        System.out.println("Árbol con nombres");
        System.out.println(bTreeName);
        System.out.println();

        //Probar size, min,max
        try {
            System.out.println("Size, min, max del árbol númerico");
            System.out.println("Size: " + bTree.size());
            System.out.println("Min: " + bTree.min());
            System.out.println("Max: " + bTree.max());
            System.out.println();

            System.out.println("Size, min, max del árbol del alfabeto");
            System.out.println("Size: " + bTreeAlphabet.size());
            System.out.println("Min: " + bTreeAlphabet.min());
            System.out.println("Max: " + bTreeAlphabet.max());
            System.out.println();

            System.out.println("Size, min, max del árbol de nombres");
            System.out.println("Size: " + bTreeName.size());
            System.out.println("Min: " + bTreeName.min());
            System.out.println("Max: " + bTreeName.max());
            System.out.println();

            //Probar el contains
            System.out.println("Contains del árbol númerico");
            for (int i = 0; i < 5; i++) {
                int value = new Random().nextInt(200, 500);
                System.out.println(bTree.contains(value) ? "[" + value + "] exists. " : "[" + value + "] does not exist");
            }
            System.out.println();

            System.out.println("Contains del árbol del alfabeto");
            for (int i = 0; i < 5; i++) {
                char c = (char) ('A' + new Random().nextInt(26));
                System.out.println(bTreeAlphabet.contains(c) ? "[" + c + "] exists. " : "[" + c + "] does not exist");

            }
            System.out.println();

            System.out.println("Contains del árbol de nombres");
            String[] namesToSearch = {"Ana", "Luis", "Pedro", "Ariana", "Lucas"};
            for(String n: namesToSearch){
                System.out.println(bTreeName.contains(n) ? "[" + n + "] exists. " : "[" + n + "] does not exist");

            }
            System.out.println();

            //Eliminar 5 elementos del árbol
            System.out.println("Remove del árbol númerico");
            for (int i = 0; i < 5; i++) {
                int value = new Random().nextInt(200, 500);

                if (bTree.contains(value)) {
                    bTree.remove(value);
                    System.out.println("Removed value: "+ value);
                }
            }
            System.out.println();

            System.out.println("Remove del árbol del alfabeto");
            for (int i = 0; i < 5; i++) {
                char c = (char) ('A' + new Random().nextInt(26));

                if (bTreeAlphabet.contains(c)) {
                    bTreeAlphabet.remove(c);
                    System.out.println("Removed: "+ c);
                }

            }
            System.out.println();

            System.out.println("Remove del árbol de nombres");
            String[] namesToRemove = {"Ana", "Luis", "Pedro", "Ariana", "Lucas"};
            for(String n: namesToRemove){

                if (bTreeName.contains(n)) {
                    bTreeName.remove(n);
                    System.out.println("Removed name: "+ n);
                }

            }
            System.out.println();

            //Mostrar el árbol por consola
            System.out.println("Estado del árbol númerico");
            System.out.println(bTree);
            System.out.println();

            System.out.println("Estado del árbol  del alfabeto");
            System.out.println(bTreeAlphabet);
            System.out.println();

            System.out.println("Estado del árbol de nombres");
            System.out.println(bTreeName);
            System.out.println();

            //Altura del arbol
            System.out.println("Altura del árbl númerico");
            System.out.println("Height: " + bTree.height());
            System.out.println();

            System.out.println("Altura del árbol de alfabeto");
            System.out.println("Height: " + bTreeAlphabet.height());
            System.out.println();

            System.out.println("Altura del árbol de nombres");
            System.out.println("Height: " + bTreeName.height());
            System.out.println();

        } catch (TreeException e) {


            throw new RuntimeException(e);
        }

    }

}