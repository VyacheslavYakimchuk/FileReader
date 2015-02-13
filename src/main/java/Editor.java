import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TeSla on 12.02.2015.
 */
public class Editor {

    private BufferedReader bufferedReader;

    public static void filePutContents(String path, String content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printwritter = new PrintWriter(path, "windows-1251");
        printwritter.println(content);
        printwritter.close();
    }

    public static void filePutContents(String path, String content, boolean append) throws IOException {
        if (append) {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.append(content);
            fileWriter.close();
        } else {
            filePutContents(path, content);
        }
    }

    private void fillBuffer(String path) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fstream = new FileInputStream(path);
        DataInputStream in = new DataInputStream(fstream);
        InputStreamReader inStr = new InputStreamReader(in, "windows-1251");
        bufferedReader = new BufferedReader(inStr);
    }


    public String fileGetContents(String path) throws IOException {
        fillBuffer(path);
        StringBuilder stringBuilder = new StringBuilder();
        String currentString = bufferedReader.readLine();
        while (currentString != null) {
            stringBuilder.append(currentString);
            stringBuilder.append(System.getProperty("line.separator"));
            currentString = bufferedReader.readLine();
        }

        return stringBuilder.toString();
    }

    public List<String> fileGetContents(String path, boolean arrayReturn) throws IOException {
        if (arrayReturn) {
            fillBuffer(path);
            List stringList = new ArrayList<String>();
            String currentString = bufferedReader.readLine();
            while (currentString != null) {
                stringList.add(currentString);
                currentString = bufferedReader.readLine();
            }
            return stringList;
        } else {
            return null;
        }
    }

}
