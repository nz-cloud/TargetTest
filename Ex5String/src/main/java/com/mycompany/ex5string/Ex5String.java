package com.mycompany.ex5string;
import java.util.Scanner;
public class Ex5String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string para inverter (ou pressione Enter para usar uma string pre-definida):");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            input = "Exemplo de string";
        }
        String invertida = inverterString(input);
        System.out.println("String original: " + input);
        System.out.println("String invertida: " + invertida);
    }
    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;
        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;
            inicio++;
            fim--;
        }
        return new String(caracteres);
    }
}
