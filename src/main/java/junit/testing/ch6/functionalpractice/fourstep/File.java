package junit.testing.ch6.functionalpractice.fourstep;

/**
 * 너는 컴퓨터 외부에 있는놈임.
 */
public class File {

    private String fileName;
    private String content;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content += content;
    }
}
