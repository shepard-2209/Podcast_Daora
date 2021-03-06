/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prototipo.aplicacao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class PrototipoLog extends CapturaDadosOshi {

    List<String> lista = new ArrayList<>();

    LogManager lgmngr = LogManager.getLogManager();
    Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void gerarLog() throws IOException {

        File arquivo = new File("log_OSHI.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();

        }
        
        lista.add("----------------------------------------");
        lista.add("\n" + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        lista.add("----------------------------------------");
        lista.add(String.format("Hostname: %s", getHostname()));
        lista.add(String.format("Fabricante: %s", getFabricante()));
        lista.add(String.format("Modelo: %s", getModelo()));
        lista.add(String.format("Processador: %s", getProcessador()));
        lista.add(String.format("RAM Total: %s", getMemoriaTotal()));
        lista.add(String.format("RAM Disponível: %s", getMemoriaDisp()));
        lista.add(String.format("SO: %s", getSistemaOperacional()));
        lista.add("----------------------------------------");
        lista.add("");

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);

        log.log(Level.INFO, "LOG_Info_PC_Usuario: \n ");
        System.out.println(getLista());
        System.out.println(arquivo.getAbsolutePath());

    }

    public List<String> getLista() {
        return lista;
    }

}
