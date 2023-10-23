import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PPM3Loader implements Loader{

    int fileLine=0;
    boolean foundWidth = false;
    boolean foundHeight=false;
    boolean foundNumber=false;
    int width=0;
    int height=0;



    @Override
    public void loadFile(String ppm3Name) {
        StringBuilder strBuilderNumber = new StringBuilder();

        try {
            File f = new File(ppm3Name);
            Scanner myReader = new Scanner(f);

            //pierwsza linia zawiera typ ppm3 lub ppm6
            String data = myReader.nextLine();
            fileLine++;

            //obsługa wszystkich kolejnych linii. Pierwsza niezakomentowana liczba -> Width, druga -> Height,
            // trzecia -> Maksymalna wartość, każda kolejna -> RGB;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();



            }


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("błąd pliku!");

        }
        //najpierw wczytaj nazwę podaną w pierwszej linii

        //później wczytaj liczbę kolumn i wierszy

        //później wczytaj maksymalną wartość koloru

        //później wczytuj kolejne wiersze zawierające 3 x Wartość (RGB)

        //później wyświetl
    }




}
