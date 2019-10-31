package com.mycompany.prototipotelas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Grafico {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(50.1, "Máximo", "1ºHora");
        dataset.addValue(10.1, "Máximo", "2ºHora");
        dataset.addValue(30.1, "Máximo", "3ºHora");
        dataset.addValue(40.1, "Máximo", "4ºHora");
        dataset.addValue(70.1, "Máximo", "5ºHora");
        
        JFreeChart criagrafico = ChartFactory.createLineChart("Gráfico Teste",
                "Tempo", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        try{
            System.out.println("Criando o Gráfico...");
            OutputStream png = new FileOutputStream("GraficoSimples.png");
            ChartUtils.writeChartAsPNG(png, criagrafico, 500, 400);
            png.close();
        }catch(IOException io){
            System.out.println("Erro:" + io.getMessage());
        }
        System.out.println("Gráfico Criado!");
    }
}
