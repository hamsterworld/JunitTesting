package junit.testing.ch6.functionalpractice.threestep;

import junit.testing.ch6.functionalpractice.threestep.outtersystem.FileSystem;
import junit.testing.ch6.functionalpractice.threestep.persister.FileUpdate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class AuditManager {

    private int maxEntriesPerFile;
    private String directoryName;

    public AuditManager(int maxEntriesPerFile) {
        this.maxEntriesPerFile = maxEntriesPerFile;
    }

    // 숨은 출력이 숨어있다.
    // 함수형 아키텍처는 아니다.
    public FileUpdate AddRecord(String visitorName, LocalDateTime timeOfVisit, List<File> file){

        String newRecord = visitorName + ";" + timeOfVisit;

        if(file.size() == 0){
            return new FileUpdate("audit1.txt",newRecord);
        }

        Map<String, File> fileList = MyComputer.getFileList();
        File LastFile = fileList.get("last_1.txt");
        String content = LastFile.getContent();


        if(content.length() < maxEntriesPerFile){
            return new FileUpdate(LastFile.getFileName(),newRecord);
        } else {
            File newFile = new File("last_2.txt");
            return new FileUpdate(newFile.getFileName(),newRecord);
        }

    }

}
