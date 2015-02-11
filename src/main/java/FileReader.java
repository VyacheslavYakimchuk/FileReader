import java.io.*;

/**
 * Created by TeSla on 11.02.2015.
 */
public class FileReader {

    public static void main(String[] args) {
        System.out.print(fileGetContents("D:\\Docs\\Notes.txt"));
    }

    public static String fileGetContents(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            InputStreamReader inStr = new InputStreamReader(in,"windows-1251");
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
