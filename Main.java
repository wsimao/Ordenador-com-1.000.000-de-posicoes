/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 *
 * @author wallisons
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
          Ordenar ord = new Ordenar();
        long vet[] = new long[1000000];
        Random r = new Random();

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        FileWriter arq = new FileWriter("Ordenacao " +new SimpleDateFormat("dd_MMM_yyyy-HH_mm_ss").format(new Date(System.currentTimeMillis()))+".txt");
        PrintWriter gravaArq = new PrintWriter(arq);

        gravaArq.print("Desordenado\n");

        for (int i = 0; i < 1000000; i++) {
            gravaArq.print(vet[i] = r.nextInt(1000000));
            gravaArq.print(",");
        }

        gravaArq.print("\nOrdenado com QuickSort\n");

        long start1 = System.currentTimeMillis();
        ord.quicksort(vet, 0, vet.length - 1);
        gravaArq.print(Arrays.toString(vet));
        long finish1 = System.currentTimeMillis();
        long elapsed1 = finish1 - start1;
        gravaArq.print("\nTempo de execução QuickSort: " +dateFormat.format(new Date(elapsed1)));

        gravaArq.print("\nOrdenado com BubbleSort\n");

        long start2 = System.currentTimeMillis();
        ord.bubbleSort(vet);
        gravaArq.print(Arrays.toString(vet));
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        gravaArq.print("\nTempo de execução BubbleSort: " +dateFormat.format(new Date(elapsed2)));

        gravaArq.print("\nOrdenado com SelectionSort\n");

        long start3 = System.currentTimeMillis();
        ord.selectionSort(vet);
        gravaArq.println(Arrays.toString(vet));
        long finish3 = System.currentTimeMillis();
        long elapsed3 = finish3 - start3;
        gravaArq.print("\nTempo de execução SelectionSort: " +dateFormat.format(new Date(elapsed3)));

        long totalElapsed = finish3 - start1;
        gravaArq.print("\nTempo Total de execução: " +dateFormat.format(new Date(totalElapsed)));

        arq.close();
    }
}
