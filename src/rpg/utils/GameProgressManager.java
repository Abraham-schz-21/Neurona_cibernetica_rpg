package rpg.utils; // Asegúrate de que esta sea la ruta correcta

import java.io.*;

public class GameProgressManager {
    private static final String SAVE_DIRECTORY = "saves/";

    public static void saveProgress(int fileIndex, String progressData) {
        try {
            File dir = new File(SAVE_DIRECTORY);
            if (!dir.exists()) {
                dir.mkdirs(); // Crea el directorio si no existe
            }
            FileWriter writer = new FileWriter(SAVE_DIRECTORY + "save" + fileIndex + ".txt");
            writer.write(progressData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadProgress(int fileIndex) {
        StringBuilder progressData = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(SAVE_DIRECTORY + "save" + fileIndex + ".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                progressData.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return progressData.toString();
    }
}
