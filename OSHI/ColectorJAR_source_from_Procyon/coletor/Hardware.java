// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

import oshi.util.FormatUtil;
import oshi.hardware.GlobalMemory;
import oshi.hardware.ComputerSystem;
import oshi.hardware.CentralProcessor;

public class Hardware extends Oshi
{
    public String nomeProcessador(final CentralProcessor processor) {
        final String processador = String.valueOf(processor);
        return processador;
    }
    
    public String fabricante(final ComputerSystem computerSystem) {
        final String fabricante = computerSystem.getManufacturer();
        return fabricante;
    }
    
    public String processadoresLogicos(final CentralProcessor processor) {
        final String logicos = String.valueOf(processor.getLogicalProcessorCount());
        return logicos;
    }
    
    public String processadoresFisicos(final CentralProcessor processor) {
        final String fisicos = String.valueOf(processor.getPhysicalProcessorCount());
        return fisicos;
    }
    
    public String fabricanteProcessador(final CentralProcessor processor) {
        final String processador = processor.getIdentifier();
        return processador;
    }
    
    public String sistemaOperacional() {
        final String sistema = String.valueOf(Hardware.si.getOperatingSystem());
        return sistema;
    }
    
    public String memoriaTotal(final GlobalMemory memory) {
        final String memoria = FormatUtil.formatBytes(memory.getTotal());
        return memoria;
    }
    
    public String placaDeVideo() {
        final String placa = "Intel(R) HD Graphics";
        return placa;
    }
}
