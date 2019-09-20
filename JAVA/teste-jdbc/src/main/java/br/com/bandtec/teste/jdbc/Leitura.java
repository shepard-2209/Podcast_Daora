package br.com.bandtec.teste.jdbc;

import java.util.Date;

public class Leitura {
    private int id;
    private String origem;
    private double valor;
    private Date dataHora; // será mapeado para "data_hora"

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Leitura{" + "id=" + id + ", origem=" + origem + ", valor=" + valor + ", dataHora=" + dataHora + '}';
    }
    
    
    
    
}
