// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

import java.util.List;
import java.sql.SQLException;
import oshi.software.os.OSProcess;
import java.util.Arrays;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;
import Database.Query;

public class Processos extends Oshi
{
    Query query;
    String maquina;
    
    public Processos() {
        this.query = new Query();
    }
    
    public void nomeProcessos(final OperatingSystem os, final GlobalMemory memory) {
        final List<OSProcess> procs = Arrays.asList(os.getProcesses(5, OperatingSystem.ProcessSort.CPU));
        for (int i = 0; i <= 4; ++i) {
            final OSProcess p = procs.get(i);
            final String processName = p.getName();
            final int pid = p.getProcessID();
            final double memoria = 100.0 * p.getResidentSetSize() / memory.getTotal();
            final String processo1 = processName + "          " + pid + "          " + memoria;
            try {
                this.query.nomeProcessos(processo1, "maquinaCBLOL");
                Thread.sleep(5000L);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
}
