package junit.testing.ch6.functionalpractice.twostep;

import java.util.HashMap;
import java.util.Map;

/**
 * 외부의존성이라고 생각하자.
 */
public class MyComputer {

    private static Map<String, File> fileList = new HashMap<>();

    public static File getFile(String fileName) {
        return fileList.get(fileName);
    }

    public static Map<String, File> getFileList(){
        return fileList;
    }
    public static void setFile(File file) {
        fileList.put(file.getFileName(),file);
    }



}
