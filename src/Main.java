import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) {
        //
        List<String> listD = Arrays.asList("src", "res", "savegames", "temp", "/src/main",
                "/src/test", "/res/drawables", "/res/vectors", "/res/icons");
        //
        listD.stream().forEach(s -> createDirectory("C:/Users/Юрий/Desktop/GamesNetology/", s));
        //
        List<String> listF = Arrays.asList("src/main/Main.java", "src/main/Utils.java", "/temp/temp.txt");
        //
        listF.stream().forEach(s -> createFile("C:/Users/Юрий/Desktop/GamesNetology/", s));
        //
        try (Writer fos = new FileWriter("C:/Users/Юрий/Desktop/GamesNetology/temp/temp.txt")) {
            fos.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDirectory(String path, String name) {
        File file = new File(path + name);
        Consumer<File> cs = (f -> sb.append((sb.isEmpty() ? "1" : sb.toString().split("\n").length + 1)
                + ". " + f.getName() + (f.mkdir() ? " Created" : " Not/Already Created") + "\n"));
        cs.accept(file);
    }

    public static void createFile(String path, String name) {
        File file = new File(path + name);
        Consumer<File> cs1 = (f -> {
            try {
                sb.append(sb.toString().split("\n").length + 1 + ". " + f.getName()
                        + (f.createNewFile() ? " Created" : " Not/Already Created") + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        cs1.accept(file);
    }
}
