import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    static JPEGLoader jpegLoader = new JPEGLoader();
    static PPM3Loader ppm3Loader = new PPM3Loader();
    static PPM6Loader ppm6Loader = new PPM6Loader();

    public static void main(String[] args) {



        JFrame f = new JFrame();


        f.setSize(1000,100);
        f.setTitle("Grafika Komputerowa Rysowanie Prymitywów");




        JPanel toolsPanel = new JPanel();

        toolsPanel.setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        toolsPanel.add(toolBar, BorderLayout.CENTER);

        JButton toolbarButton1 = new JButton("Wczytaj PPM3");
        JButton toolbarButton2 = new JButton("Wczytaj PPM6");
        JButton toolbarButton3 = new JButton("Wczytaj JPG");
        JButton toolbarButton4 = new JButton("Zapisz PPM3");
        JButton toolbarButton5 = new JButton("Zapisz PPM6");
        JButton toolbarButton6 = new JButton("Zapisz JPG");


        toolBar.add(toolbarButton1);
        toolBar.add(toolbarButton2);
        toolBar.add(toolbarButton3);
        toolBar.add(toolbarButton4);
        toolBar.add(toolbarButton5);
        toolBar.add(toolbarButton6);

        JLabel nazwaPlikuLabel = new JLabel(" Nazwa Pliku: ");
        JTextField nazwaPlikuField = new JTextField("ppm-test-01-p3.ppm");

        toolbarButton1.addActionListener(e -> ButtonPressed(1, nazwaPlikuField));
        toolbarButton2.addActionListener(e -> ButtonPressed(2, nazwaPlikuField));
        toolbarButton3.addActionListener(e -> ButtonPressed(3, nazwaPlikuField));
        toolbarButton4.addActionListener(e -> ButtonPressed(4, nazwaPlikuField));
        toolbarButton5.addActionListener(e -> ButtonPressed(5, nazwaPlikuField));
        toolbarButton6.addActionListener(e -> ButtonPressed(6, nazwaPlikuField));


        toolBar.add(nazwaPlikuLabel);
        toolBar.add(nazwaPlikuField);

        Container content = f.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(toolsPanel, BorderLayout.CENTER);
        f.setVisible(true);



    }

    static void ButtonPressed(int buttonNr, JTextField nazwaPlikuField) {

        int fieldNameType=0; //1=PPM, 2=JPEG
        String nazwaP= nazwaPlikuField.getText();

        File f = new File(nazwaP);
        char c1=nazwaP.charAt(nazwaP.length()-4);
        char c2=nazwaP.charAt(nazwaP.length()-3);
        char c3=nazwaP.charAt(nazwaP.length()-2);
        char c4=nazwaP.charAt(nazwaP.length()-1);

        if(buttonNr==1||buttonNr==2||buttonNr==3) {
            if (c1=='.'&& c2 == 'p' && c3 == 'p' && c4 == 'm') {
                fieldNameType = 1;
                System.out.println("Nazwa Pliku PPM");


            } else if (c1 == '.' && c2 == 'j' && c3 == 'p' && c4 == 'g') {
                fieldNameType = 2;
                System.out.println("Nazwa Pliku JPEG");

            }


            if(buttonNr==3&&fieldNameType==1){


                System.out.println("Wczytując JPEG nie kończ nazwy pliku na PPM :C");
                ErrorFrame errorFrame = new ErrorFrame("Wczytując JPEG nie kończ nazwy pliku na .ppm :C");

                return;
            }

            if((buttonNr==1||buttonNr==2)&&fieldNameType==2){
                System.out.println("Wczytując PPM nie kończ nazwy pliku na JPEG :C");
                ErrorFrame errorFrame = new ErrorFrame("Wczytując PPM nie kończ nazwy pliku na .jpg :C");
                return;
            }

            if (fieldNameType == 0) {
                //NIEPOPRAWNA NAZWA PLIKU ERROR -> brakuje rozszerzenia .ppm lub .jpeg
                System.out.println("Zakończ nazwę pliku nazwą rozszerzenia - nazwa.ppm lub nazwa.jpg ");
                ErrorFrame errorFrame = new ErrorFrame("Zakończ nazwę pliku nazwą rozszerzenia - nazwa.ppm lub nazwa.jpg ");
                return;
            }

            if(!(f.exists() && !f.isDirectory())){
                System.out.println("Nie istnieje Taki Plik!");
                ErrorFrame errorFrame = new ErrorFrame("Nie istnieje plik o podanej nazwie :C");
                return;
            }


            System.out.println("Istnieje Taki Plik!");
            //
            switch(buttonNr){
                case 1:
                  ppm3Loader.loadFile(nazwaP);
                    break;
                case 2:
                   ppm6Loader.loadFile(nazwaP);
                    break;
                case 3:
                    jpegLoader.loadFile(nazwaP);
                    break;
            }

            return;
        }




        System.out.println("Zapisywanie do pliku!");



    }
}