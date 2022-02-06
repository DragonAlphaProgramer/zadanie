/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lufthansa;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author PatrykK
 */
public class Lufthansa {

    private static String autor="",tytul="",opis="";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner zrodlo = new Scanner(System.in);
        System.out.println("Z jakiej strony mam zapisać artykuł");
        String url = zrodlo.toString();
        try {
            Connection connect = Jsoup.connect(url);
            Document document = connect.get();
            Elements dane = document.getElementsByTag("meta");
            autor = dane.attr("Author");
            tytul = document.select("title").toString();
            opis = dane.attr("Description");
            Artykul a = new Artykul(autor, tytul, opis);
            
            JFileChooser wyborP = new JFileChooser();
        wyborP.setDialogType(JFileChooser.SAVE_DIALOG);
        wyborP.setFileFilter(new FileNameExtensionFilter("txt file", "txt"));
    int returnVal = wyborP.showOpenDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file;

            file = wyborP.getSelectedFile();
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.toString() + ".txt");
            }

            try (PrintWriter fileWriter = new PrintWriter(file.getPath())) {
                fileWriter.println(a.getTytul()+"|"+a.getAutor()+"|"+a.getOpis());
                fileWriter.close();

            } catch (IOException e) {

            }
        }
        } catch (IOException e) {
            System.out.print("błąd zapisu");
        }
    }

}
