package junit.testing.ch6.functionalpractice.threestep;

import junit.testing.ch6.functionalpractice.threestep.persister.FileUpdate;
import junit.testing.ch6.functionalpractice.threestep.persister.Persister;

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
        List<File> files = persister.ReadDirectory(directoryName);
        FileUpdate fileUpdate = auditManager.AddRecord(visitorName, localDateTime, files);
        persister.ApplyUpdate(directoryName,fileUpdate);
    }
}
