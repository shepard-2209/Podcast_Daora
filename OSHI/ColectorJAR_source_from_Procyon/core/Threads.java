// 
// Decompiled by Procyon v0.5.36
// 

package core;

import java.sql.SQLException;
import java.util.TimerTask;
import java.util.Timer;
import Database.Query;

public class Threads
{
    Query query;
    Timer timer;
    String maquina;
    Thread todosOsComponentes;
    Thread processador;
    Thread memoriaRAM;
    Thread disco;
    
    public Threads() {
        this.query = new Query();
        this.todosOsComponentes = new Thread() {
            @Override
            public void start() {
                (Threads.this.timer = new Timer()).scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Threads.this.query.setData(Threads.this.maquina);
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 10L, 5000L);
            }
        };
        this.processador = new Thread() {
            @Override
            public void start() {
                (Threads.this.timer = new Timer()).scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Threads.this.query.setProcessador(Threads.this.maquina);
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 10L, 5000L);
            }
        };
        this.memoriaRAM = new Thread() {
            @Override
            public void start() {
                (Threads.this.timer = new Timer()).scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Threads.this.query.setRAM(Threads.this.maquina);
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 10L, 5000L);
            }
        };
        this.disco = new Thread() {
            @Override
            public void start() {
                (Threads.this.timer = new Timer()).scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Threads.this.query.setDisk(Threads.this.maquina);
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 10L, 5000L);
            }
        };
    }
    
    public String setMaquina(final String maquina) {
        return this.maquina = maquina;
    }
}
