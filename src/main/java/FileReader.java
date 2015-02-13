import java.io.IOException;

/**
 * Created by TeSla on 11.02.2015.
 */
public class FileReader  {

    public static void main(String[] args) throws IOException {

        Editor editor = new Editor();
        System.out.print(editor.fileGetContents("D:\\test.txt", true));

    }
}
