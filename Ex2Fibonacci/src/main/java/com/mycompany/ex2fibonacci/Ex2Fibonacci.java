package com.mycompany.ex2fibonacci;
import java.util.Scanner;
public class Ex2Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero para verificar se está na sequencia de Fibonacci: ");
        int numero = scanner.nextInt();
        if (isFibonacci(numero)) {
            System.out.println("O numero " + numero + " pertence a sequencia de Fibonacci.");
        } else {
            System.out.println("O numero " + numero + " nao pertence a sequancia de Fibonacci.");
        }
        scanner.close();
    }
    public static boolean isFibonacci(int num) {
        if (num < 0) {
            return false;
        }
        int a = 0, b = 1, c = 0;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == num;
    }
}
