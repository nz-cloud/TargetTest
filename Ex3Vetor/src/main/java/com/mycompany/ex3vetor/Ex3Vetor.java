package com.mycompany.ex3vetor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex3Vetor {

    public static void main(String[] args) {
        String jsonData = readJsonFromFile("src/main/faturamento.json");
        JSONArray faturamentos = new JSONArray(jsonData);

        List<Double> valores = new ArrayList<>();
        for (int i = 0; i < faturamentos.length(); i++) {
            JSONObject obj = faturamentos.getJSONObject(i);
            Double valor = obj.optDouble("valor", -1);
            if (valor >= 0) {
                valores.add(valor);
            }
        }

        if (valores.isEmpty()) {
            System.out.println("Não há dados de faturamento.");
            return;
        }

        double menorValor = valores.stream().mapToDouble(v -> v).min().orElseThrow();
        double maiorValor = valores.stream().mapToDouble(v -> v).max().orElseThrow();
        double mediaMensal = valores.stream().mapToDouble(v -> v).average().orElseThrow();

        long diasAcimaDaMedia = valores.stream().filter(v -> v > mediaMensal).count();

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    private static String readJsonFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
