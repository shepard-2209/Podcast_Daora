package br.com.bandtec.teste.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestesInsert {

    public static void main(String[] args) throws ParseException {
          // datasource de conexão com o Mysql
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gaga?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");   
        
        // objeto de operação com o banco
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // fazendo um insert na tabela
        jdbcTemplate.update(
            "insert into leitura (origem, valor) values "+
            "('cpu', 99.9)");
        
        // insert com parâmetros
        String origemQq = "disco";
        double valorQq = 0.01;
        Date dataHoraQq = new Date();
        
        jdbcTemplate.update(
         "insert into leitura "
                + "(origem, valor, data_hora) values (?,?,?)",
         origemQq, valorQq, dataHoraQq
        );
        
        
        // invoque uma instrução update
        // na tabela leitura
        //     update leitura set data_hora = ? 
        //     where data_hora is null
        // informe o parâmetro usando uma variável
        // do tipo Date recém criada
        // dica: use o método jdbcTemplate.update(...)
        Date diaTal = 
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                        .parse("08/10/2003 15:30:04");
        
        jdbcTemplate.update(
                "update leitura set data_hora = ? " +
                "where data_hora is null", diaTal);
        
        jdbcTemplate.update(
                "delete from leitura where origem = ?",
                "disco");
        
        // SQL injection
        String origemHacker = "'x'; drop table leitura;";
        jdbcTemplate.queryForList(
         "select * from leitura where origem = ?",
         origemHacker
        );
        
        // SQL injection, exemplo de tabela 'usuario'
        String login = "";
        String senha = "'o'; drop table usuario;";
        
        jdbcTemplate.queryForList(
        "select * from usuario where login = ? and senha = ?",
        login, senha);
        
    }
    
}



