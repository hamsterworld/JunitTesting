package junit.testing.ch6.functionalpractice.onestep;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 1. 4가지요소를 한번 스스로 평가해볼것.
 * 2. 테스트를 해도 단위테스트가 될수없는 이유를 설명해볼것.
 */
public class AuditManager {

    private int maxEntriesPerFile;
    private String directoryName;

    public AuditManager(int maxEntriesPerFile, String directoryName) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
    }

    public void AddRecord(String visitorName, LocalDateTime timeOfVisit){

        // 외부 의존성
        // 만약에 이코드가 I/O라고 생각해보자. 어쨋든 외부시스템임.
        File file = MyComputer.getFile(directoryName);

        String newRecord = visitorName + ";" + timeOfVisit;

        if(file == null){
            // I/O 파일생성
            File newFile = new File("audit_1.txt");
            newFile.setContent(newRecord);
            MyComputer.setFile(newFile);
            return;
        }

        Map<String, File> fileList = MyComputer.getFileList();
        // 마지막파일을 얻어냇다고 가정하자.
        File LastFile = fileList.get("last_1.txt");
        String content = LastFile.getContent();


        if(content.length() < maxEntriesPerFile){
            MyComputer.writeFileContent("last_1.txt",newRecord);
        } else {
            // I/O 파일생성 및 쓰기
            File newFile = new File("last_2.txt");
            newFile.setContent(newRecord);
        }

    }
}
