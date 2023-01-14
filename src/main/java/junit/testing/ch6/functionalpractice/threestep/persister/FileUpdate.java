package junit.testing.ch6.functionalpractice.threestep.persister;

public class FileUpdate {

    private String fileName;
    private String NewContent;

    public FileUpdate(String fileName, String newContent) {
        this.fileName = fileName;
        this.NewContent = newContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getNewContent() {
        return NewContent;
    }
}
