package junit.testing.ch6.functionalpractice.twostep;

import junit.testing.ch6.functionalpractice.twostep.outtersystem.FileSystem;

import java.time.LocalDateTime;
import java.util.Map;


public class AuditManager {

    private int maxEntriesPerFile;
    private String directoryName;
    private FileSystem fileSystem;

    public AuditManager(int maxEntriesPerFile, String directoryName, FileSystem fileSystem) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
        this.fileSystem = fileSystem;
    }

    // 숨은 출력이 숨어있다.
    // 함수형 아키텍처는 아니다.
    public void AddRecord(String visitorName, LocalDateTime timeOfVisit){

        File file = fileSystem.getFile(directoryName);

        String newRecord = visitorName + ";" + timeOfVisit;

        if(file == null){
            File newFile = new File("audit_1.txt");
            fileSystem.setFile(newFile);
            newFile.setContent(newRecord);
            return;
        }

        Map<String, File> fileList = MyComputer.getFileList();
        File LastFile = fileList.get("last_1.txt");
        String content = LastFile.getContent();


        if(content.length() < maxEntriesPerFile){
            LastFile.setContent(newRecord);
        } else {
            File newFile = new File("last_2.txt");
            newFile.setContent(newRecord);
        }

    }
}
