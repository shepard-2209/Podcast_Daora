package com.mycompany.prototipotelas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class GraficoMemoria {
    public void dadoMemoria() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(20.1, "Máximo", "5 minutos");
        dataset.addValue(10.1, "Máximo", "4 minutos");
        dataset.addValue(0.1, "Máximo", "3 minutos");
        dataset.addValue(20.1, "Máximo", "2 minutos");
        dataset.addValue(100.1, "Máximo", "1 minuto");
        
        JFreeChart criagrafico = ChartFactory.createLineChart("Gráfico Mémoria",
                "Tempo", "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        try{
            System.out.println("Atualizando Memória...");
            OutputStream png = new FileOutputStream("GraficoMemoria.png");
            ChartUtils.writeChartAsPNG(png, criagrafico, 500, 400);
            png.close();
        }catch(IOException io){
            System.out.println("Erro:" + io.getMessage());
        }
        System.out.println("Memória Atualizado!");
    }
}
