package com.mycompany.prototipo.aplicacao;

public class Dados {

    PrototipoAplicacao dadosApp = new PrototipoAplicacao();
    ConexaoBanco insert = new ConexaoBanco();
    private String nome = "Marcelo";
    private String sobrenome = "Lixo";
    
    
        //Esse método faz a conecção e faz um insert das informações no Banco 
    public void EnviarBanco() {
        insert.getConnection();
        insert.template().update(
                "insert into Computador (fabricante,modelo,processador,memoriaTotal,memoriaDisp) "
                + "values (?,?,?,?,?)", dadosApp.Fabricante(), dadosApp.Modelo(),
                dadosApp.Processador(), dadosApp.MemoriaTotal(), dadosApp.MemoriaDisp());
                
    }
}
