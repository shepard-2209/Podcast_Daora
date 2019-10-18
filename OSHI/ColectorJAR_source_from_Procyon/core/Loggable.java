// 
// Decompiled by Procyon v0.5.36
// 

package core;

import java.text.DateFormat;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loggable
{
    public void createLogs(final String error, final String caminhoPasta, final String arquivoLog) {
        final String strDateFormat = "yyyy-MM-dd";
        final String strHourFormat = "HH.mm.ss";
        final Date date = new Date();
        final DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        final DateFormat hourFormat = new SimpleDateFormat(strHourFormat);
        final String dateFinal = dateFormat.format(date) + " " + hourFormat.format(date);
        try {
            new File(caminhoPasta).mkdir();
            final FileWriter newFile = new FileWriter(caminhoPasta + arquivoLog + dateFinal + ".txt");
            final File arquivo = new File(caminhoPasta + arquivoLog + dateFinal + ".txt");
            final FileReader fileReader = new FileReader(arquivo);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            final BufferedWriter bufferedWriter = new BufferedWriter(newFile);
            bufferedWriter.write("INFO " + error);
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (Exception e) {
            new Loggable().createLogs(e.toString(), "Logs/", "Log");
            System.out.println(e);
        }
    }
}
