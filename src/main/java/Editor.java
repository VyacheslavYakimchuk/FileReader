import java.io.*;

/**
 * Created by TeSla on 12.02.2015.
 */
public class Editor {

    public static void filePutContents(String path, String content) {
        try {
            PrintWriter printwritter = new PrintWriter(path, "windows-1251");
            printwritter.println(content);
            printwritter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void filePutContents(String path, String content, boolean append) {
        if (append) {
            try {
                FileWriter fileWriter = new FileWriter(path, true);
                fileWriter.append("\n "+content);
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            filePutContents(path, content);
        }

    }

    public static String fileGetContents(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            InputStreamReader inStr = new InputStreamReader(in, "windows-1251");
            BufferedReader br1 = new BufferedReader(inStr);
            try {
                String currentString = br1.readLine();
                while (currentString != null) {
                    stringBuilder.append(currentString);
                    stringBuilder.append(System.getProperty("line.separator"));
                    currentString = br1.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
