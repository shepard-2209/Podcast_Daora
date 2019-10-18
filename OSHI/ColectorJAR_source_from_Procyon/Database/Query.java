// 
// Decompiled by Procyon v0.5.36
// 

package Database;

import core.Loggable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.SystemInfo;
import coletor.Hardware;
import coletor.Disco;
import coletor.MemoriaRAM;
import coletor.Processador;

public class Query extends Conexao
{
    private Processador processador;
    private MemoriaRAM ram;
    private Disco disk;
    private Conexao conexao;
    private Hardware hardware;
    private SystemInfo si;
    private HardwareAbstractionLayer hal;
    private CentralProcessor processor;
    
    public Query() {
        this.processador = new Processador();
        this.ram = new MemoriaRAM();
        this.disk = new Disco();
        this.conexao = new Conexao();
        this.hardware = new Hardware();
        this.si = new SystemInfo();
        this.hal = this.si.getHardware();
        this.processor = this.hal.getProcessor();
    }
    
    public String getUser(final String username) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        final String userQuery = "'" + username + "'";
        final String selectTableSQL = "SELECT usuario FROM userSeven WHERE usuario =" + userQuery;
        try {
            dbConnection = Conexao.getDBConnection();
            statement = dbConnection.createStatement();
            final ResultSet rs = statement.executeQuery(selectTableSQL);
            if (rs.next()) {
                final String Usuario = rs.getString("usuario");
                System.out.println("Usuario encontrado");
                return username;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String getPassword(final String username) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        final String userQuery = "'" + username + "'";
        final String selectSQL = "SELECT senha FROM userSeven WHERE usuario=" + userQuery;
        try {
            dbConnection = Conexao.getDBConnection();
            statement = dbConnection.createStatement();
            final ResultSet rs = statement.executeQuery(selectSQL);
            if (rs.next()) {
                final String pass = rs.getString("senha");
                System.out.println("Senha confirmada");
                return pass;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String setData(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String insertTableSQL = "INSERT INTO desempenho(cpu_disponivel, cpu_em_uso, temperatura_cpu, memoria_ram_disponivel, memoria_ram_em_uso_cpu, disco_em_uso_hd, disco_livre_hd, temperatura_gpu, fk_idSoft) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, this.processador.getPorcentagemDisponivel());
            preparedStatement.setDouble(2, this.processador.getPorcentagemDeUso());
            preparedStatement.setDouble(3, Double.parseDouble(this.processador.getCPUTemperature()));
            preparedStatement.setDouble(4, this.ram.getPorcentagemDeMemoriaDisponivel());
            preparedStatement.setDouble(5, this.ram.getPorcentagemDeMemoria());
            preparedStatement.setDouble(6, this.disk.getPorcentagemDeDisco());
            preparedStatement.setDouble(7, this.disk.getPorcentagemDeDiscoLivre());
            preparedStatement.setDouble(8, 0.0);
            preparedStatement.setString(9, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String setProcessador(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String insertTableSQL = "INSERT INTO desempenho(cpu_disponivel, cpu_em_uso, temperatura_cpu, fk_idSoft) VALUES(?,?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, this.processador.getPorcentagemDisponivel());
            preparedStatement.setDouble(2, this.processador.getPorcentagemDeUso());
            preparedStatement.setDouble(3, Double.parseDouble(this.processador.getCPUTemperature()));
            preparedStatement.setString(4, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            new Loggable().createLogs(e.toString(), "Logs/", "Log");
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String setRAM(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String insertTableSQL = "INSERT INTO desempenho(memoria_ram_disponivel, memoria_ram_em_uso_cpu, fk_idSoft) VALUES(?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, this.ram.getPorcentagemDeMemoriaDisponivel());
            preparedStatement.setDouble(2, this.ram.getPorcentagemDeMemoria());
            preparedStatement.setString(3, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String setDisk(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String insertTableSQL = "INSERT INTO desempenho(disco_em_uso_hd, disco_livre_hd, fk_idSoft) VALUES(?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, this.disk.getPorcentagemDeDisco());
            preparedStatement.setDouble(2, this.disk.getPorcentagemDeDiscoLivre());
            preparedStatement.setString(3, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String hardware(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String insertTableSQL = "INSERT INTO hardware(nome_processador, modelo_processador, fabricante, sistema_operacional, processadores_logico, processadores_fisico, memoria_total, placa_video, fk_idSoft) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, this.hardware.nomeProcessador(this.hal.getProcessor()));
            preparedStatement.setString(2, this.hardware.fabricanteProcessador(this.hal.getProcessor()));
            preparedStatement.setString(3, this.hardware.fabricante(this.hal.getComputerSystem()));
            preparedStatement.setString(4, this.hardware.sistemaOperacional());
            preparedStatement.setString(5, this.hardware.processadoresLogicos(this.hal.getProcessor()));
            preparedStatement.setString(6, this.hardware.processadoresFisicos(this.hal.getProcessor()));
            preparedStatement.setString(7, this.hardware.memoriaTotal(this.hal.getMemory()));
            preparedStatement.setString(8, this.hardware.placaDeVideo());
            preparedStatement.setString(9, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String nomeProcessos(final String processos, final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String tamanho = String.valueOf(processos.length());
        final String nomeProcesso = processos.substring(0, 13);
        final String PID = processos.substring(14, 20);
        final String memoria = String.valueOf(Double.parseDouble(processos.substring(24, Integer.parseInt(tamanho))));
        final String insertTableSQL = "INSERT INTO processo(nome_processo, pid, memoria, fk_idSoft) VALUES(?,?,?,?)";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, nomeProcesso);
            preparedStatement.setString(2, PID);
            preparedStatement.setString(3, memoria);
            preparedStatement.setString(4, this.autenticaMaquina(maquina));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
    
    public String autenticaMaquina(final String maquina) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        final String selectSQL = "SELECT id_soft FROM maquina where nome_soft = ?";
        try {
            dbConnection = Conexao.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, maquina);
            preparedStatement.setString(1, maquina);
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                final String id = rs.getString("id_soft");
                System.out.println("Nome encontrado");
                return id;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return null;
    }
}
