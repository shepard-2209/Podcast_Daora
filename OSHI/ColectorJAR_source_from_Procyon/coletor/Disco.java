// 
// Decompiled by Procyon v0.5.36
// 

package coletor;

public class Disco extends Oshi
{
    public int getPorcentagemDeDisco() {
        final long espacoUsado = this.root[0].getTotalSpace() - this.root[0].getFreeSpace();
        final long porcentagem = espacoUsado * 100L / this.root[0].getTotalSpace();
        return (int)porcentagem;
    }
    
    public int getPorcentagemDeDiscoLivre() {
        final int disponivel = 100 - this.getPorcentagemDeDisco();
        return disponivel;
    }
}
