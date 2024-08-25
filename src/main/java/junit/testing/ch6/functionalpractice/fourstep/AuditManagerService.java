package junit.testing.ch6.functionalpractice.fourstep;

import junit.testing.ch6.functionalpractice.fourstep.persister.FileUpdate;
import junit.testing.ch6.functionalpractice.fourstep.persister.Persister;

import java.time.LocalDateTime;
import java.util.List;

public class AuditManagerService {

    private String directoryName;
    private AuditManager auditManager;
    private Persister persister;

    public AuditManagerService(String directoryName,int maxEntriesPerFile) {
        this.directoryName = directoryName;
        this.auditManager = new AuditManager(maxEntriesPerFile);
        this.persister = new Persister();
    }

    public void AddRecord(String visitorName, LocalDateTime localDateTime){
        List<File> files = persister.ReadDirectory(directoryName); // persister 가 사실상 repository 로 볼수있다.
        FileUpdate fileUpdate = auditManager.AddRecord(visitorName, localDateTime, files);
        persister.ApplyUpdate(directoryName,fileUpdate);
    }
}
