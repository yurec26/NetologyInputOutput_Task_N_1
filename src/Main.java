import java.io.*; 
import java.util.Arrays;
import java.util.List;

public class Main {
    public static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) {
        List<String> list = Arrays.asList("src", "res", "savegames", "temp", "/src/main",
                "/src/test", "/res/drawables", "/res/vectors", "/res/icons", "src/main/Main.java",
                "src/main/Utils.java", "/temp/temp.txt");

        list.stream().forEach(s -> {
            if (s.contains(".")) createFile("C:/Users/Юрий/Desktop/GamesNetology/", s);
            else createDirectory("C:/Users/Юрий/Desktop/GamesNetology/", s);
        });

        try (Writer fos = new FileWriter("C:/Users/Юрий/Desktop/GamesNetology/temp/temp.txt")) {
            fos.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDirectory(String path, String name) {
        File file = new File(path + name);
        sb.append(file.getName() + (file.mkdir() ? " Created" : " Not Created") + "\n");
    }

    public static void createFile(String path, String name) {
        File file = new File(path + name);
        try {
            sb.append(file.getName() + (file.createNewFile() ? " Created" : " Not Created") + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


