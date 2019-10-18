// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

public class MemoriaRAM extends Oshi
{
    public int getPorcentagemDeMemoria() {
        final long totalMemoria = MemoriaRAM.si.getHardware().getMemory().getTotal();
        final long memoriaDisponivel = MemoriaRAM.si.getHardware().getMemory().getAvailable();
        final long memoriaUsada = totalMemoria - memoriaDisponivel;
        final long temp = memoriaUsada * 100L / totalMemoria;
        return (int)temp;
    }
    
    public int getPorcentagemDeMemoriaDisponivel() {
        final int disponivel = 100 - this.getPorcentagemDeMemoria();
        return disponivel;
    }
}
