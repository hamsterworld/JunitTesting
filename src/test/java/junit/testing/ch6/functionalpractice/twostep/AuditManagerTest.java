package junit.testing.ch6.functionalpractice.twostep;

import junit.testing.ch6.functionalpractice.twostep.outtersystem.FileSystem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;


class AuditManagerTest {

    @Test
    void A_new_file_is_created_when_the_current_file_overflows(){
        FileSystem mock = Mockito.mock(FileSystem.class);
        AuditManager sut = new AuditManager(3, "audits", mock);

        sut.AddRecord("Alice", LocalDateTime.now());

        mock.setFile(new File("auties2.txt"));
    }

}