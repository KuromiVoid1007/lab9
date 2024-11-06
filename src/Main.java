import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {



        try{
            File file = new File("source.txt");
            if (file.createNewFile()){
                System.out.println("Файл 1 создан!");
            }
            else System.out.println("Файл 1 существует!");

            FileWriter fw = new FileWriter("source.txt");
            fw.write("D");
            fw.close();

        } catch (Exception e){
            System.out.println(e);
        }

        try{
            BufferedReader in = new BufferedReader(new FileReader("source.txt"));
            String line = in.readLine();
            while(line != null)
            {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();

            File file = new File("copy.txt");
            if (file.createNewFile()){
                System.out.println("Файл 2 создан!");
            }
            else System.out.println("Файл 2 существует!");

        } catch (Exception e){
            System.out.println(e);
        }

        try {
            FileWriter fw = new FileWriter("copy.txt");
            FileReader fr = new FileReader("source.txt");

            int check = fr.read();
            while (check != -1){
                fw.write(check);
                check = fr.read();
            }

            fw.close();
            fr.close();

            File newDir = new File("newDir");
            if (!newDir.exists() && newDir.mkdir()) {
                System.out.println("Директория newDir создана.");
            } else if (newDir.exists()) {
                System.out.println("Директория newDir уже существует.");
            } else {
                System.out.println("Не удалось создать директорию newDir.");
            }

            File myFile = new File("source.txt");
            if (new File("newDir", "source.txt").exists()) System.out.println("Файл уже создан");
            else {
                Path temp = Files.move
                        (Paths.get("source.txt"),
                                Paths.get("newDir/source.txt"));
                if (temp != null) {
                    System.out.println("Файл перемещен");
                } else System.out.println("Error!!!");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }
}