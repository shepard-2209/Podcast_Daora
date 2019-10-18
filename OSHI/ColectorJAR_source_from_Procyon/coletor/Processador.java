// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

import java.util.Iterator;
import java.util.List;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.JSensors;

public class Processador extends Oshi
{
    private static double porcentagemDeUso;
    
    public int getPorcentagemDeUso() {
        double percentage = this.processor.getSystemCpuLoad() * 100.0;
        percentage = (Processador.porcentagemDeUso = (double)Math.round(percentage));
        return (int)Processador.porcentagemDeUso;
    }
    
    public int getPorcentagemDisponivel() {
        final double disponivel = 100.0 - this.getPorcentagemDeUso();
        return (int)disponivel;
    }
    
    public String getCPUTemperature() {
        final List<Cpu> cpus = JSensors.get.components().cpus;
        if (cpus.isEmpty()) {
            return "Not Available";
        }
        Double totalTemp = 0.0;
        Double quantCPU = 0.0;
        for (final Cpu cpu : cpus) {
            if (cpu.sensors != null) {
                final List<Temperature> temps = cpu.sensors.temperatures;
                for (final Temperature temp : temps) {
                    totalTemp += temp.value;
                    ++quantCPU;
                }
            }
        }
        totalTemp /= quantCPU;
        return String.valueOf(totalTemp);
    }
}
