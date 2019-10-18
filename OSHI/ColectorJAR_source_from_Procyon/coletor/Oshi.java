// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

import oshi.software.os.OperatingSystem;
import java.io.File;
import oshi.hardware.HWDiskStore;
import oshi.hardware.CentralProcessor;
import core.Loggable;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.SystemInfo;

public class Oshi
{
    static SystemInfo si;
    static HardwareAbstractionLayer hal;
    private static Loggable loggable;
    CentralProcessor processor;
    HWDiskStore[] hd;
    File[] root;
    static OperatingSystem os;
    
    public Oshi() {
        this.processor = Oshi.hal.getProcessor();
        this.hd = Oshi.hal.getDiskStores();
        this.root = File.listRoots();
    }
    
    public static void main(final String[] args) {
        final Processos processos = new Processos();
        processos.nomeProcessos(Oshi.os, Oshi.hal.getMemory());
    }
    
    static {
        Oshi.si = new SystemInfo();
        Oshi.hal = Oshi.si.getHardware();
        Oshi.os = Oshi.si.getOperatingSystem();
    }
}
