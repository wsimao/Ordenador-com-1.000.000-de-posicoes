/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

/**
 *
 * @author wallisons
 */
public class Ordenar {
    
       //quicksort
    public static void quicksort(long[] v, int esq, int dir) {
        if (esq < dir) {
            int j = separar(v, esq, dir);
            quicksort(v, esq, j-1);
            quicksort(v, j+1, dir);
        }
    }

    private static int separar(long[] v, int esq, int dir) {
        int i = esq + 1;
        int j = dir;
        long pivo = v[esq];

        while (i <= j) {
            if (v[i] <= pivo) i++;
            else if (v[j] > pivo) j--;
            else if (i <= j) {
                trocar(v, i, j);
                i++;
                j--;
            }
        }

        trocar(v, esq, j);
        return j;
    }

    private static void trocar(long[] v, int i, int j) {
        long aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void bubbleSort(long vetor[]) {
        boolean troca = true;
        long aux;

        while (troca) {
            troca = false;

            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }

    public static void selectionSort(long[] array) {
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < array.length; i++) {
                if (array[i] < array[menor]) {
                    menor = i;
                }
            }

            if (menor != fixo) {
                long t = array[fixo];
                array[fixo] = array[menor];
                array[menor] = t;
            }
        }
    }
}