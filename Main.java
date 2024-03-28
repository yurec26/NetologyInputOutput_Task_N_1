

import java.io.*;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        //
        File src = new File("C:/Users/Юрий/Desktop/GamesNetology/src");
        File res = new File("C:/Users/Юрий/Desktop/GamesNetology/res");
        File savegames = new File("C:/Users/Юрий/Desktop/GamesNetology/savegames");
        File temp = new File("C:/Users/Юрий/Desktop/GamesNetology/temp");
        //
        File main = new File("C:/Users/Юрий/Desktop/GamesNetology/src/main");
        File test = new File("C:/Users/Юрий/Desktop/GamesNetology/src/test");
        //
        File main_java = new File("C:/Users/Юрий/Desktop/GamesNetology/src/main/Main.java");
        File utils_java = new File("C:/Users/Юрий/Desktop/GamesNetology/src/main/Utils.java");
        //
        File drawables = new File("C:/Users/Юрий/Desktop/GamesNetology/res/drawables");
        File vectors = new File("C:/Users/Юрий/Desktop/GamesNetology/res/vectors");
        File icons = new File("C:/Users/Юрий/Desktop/GamesNetology/res/icons");
        //
        File temp_txt = new File("C:/Users/Юрий/Desktop/GamesNetology/temp/temp.txt");
        //
        StringBuilder sb = new StringBuilder("");
        //
        Consumer<File> cs = (f -> sb.append((sb.isEmpty() ? "1" : sb.toString().split("\n").length + 1)
                + ". " + f.getName() + (f.mkdir() ? " Created" : " Not/Already Created") + "\n"));
        //
        Consumer<File> cs1 = (f -> {
            try {
                sb.append(sb.toString().split("\n").length + 1 + ". " + f.getName()
                        + (f.createNewFile() ? " Created" : " Not/Already Created") + "\n");
            } catch (IOException ex) {

            }
        });
        //
        cs.accept(src);
        cs.accept(res);
        cs.accept(savegames);
        cs.accept(temp);
        cs.accept(main);
        cs.accept(test);
        //
        cs1.accept(main_java);
        cs1.accept(utils_java);
        //
        cs.accept(drawables);
        cs.accept(vectors);
        cs.accept(icons);
        //
        cs1.accept(temp_txt);
        //
        System.out.println(sb);
        //
        try (Writer fos = new FileWriter(temp_txt)) {
            fos.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
