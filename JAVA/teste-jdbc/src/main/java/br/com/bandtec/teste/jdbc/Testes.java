/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.teste.jdbc;

import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Testes {
    
    
    public static void main(String[] args)  {
        // datasource de conexão com o Mysql
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gaga?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");   
        
        // objeto de operação com o banco
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        System.out.println(
            jdbcTemplate.queryForList("select * from leitura")
        );
        
        List<Map<String, Object>> lista = 
           jdbcTemplate.queryForList("select * from leitura");
        
        for (Map linha: lista) {
            System.out.println(linha);
        }
        
        
        List<Leitura> lista2 = jdbcTemplate.query(
                "select * from leitura",
                new BeanPropertyRowMapper<Leitura>(Leitura.class)
        );
        
        System.out.println(lista2);
        for (Leitura linha : lista2) {
            System.out.println(linha);
        }
        
        // where id > 2
        List<Leitura> lista3 = jdbcTemplate.query(
            "select * from leitura where id > ?",
            new BeanPropertyRowMapper<Leitura>(Leitura.class),
            2
        );
        
        System.out.println(lista3);
        
        int idPesquisa = 200; // pegou não sei de onde
        String origemPesquisa = "cpu"; // não sei de onde
        
        // where id < 200 and origem='cpu'
        List<Leitura> lista4 = jdbcTemplate.query(
        "select * from leitura where id < ? and origem = ?",
            new BeanPropertyRowMapper<Leitura>(Leitura.class),
            idPesquisa, origemPesquisa
        );
        
        System.out.println(lista4);        
        
        
    }
}
