package junit.testing.ch6.functionalpractice.threestep;

import junit.testing.ch6.functionalpractice.threestep.persister.FileUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class AuditManagerTest {

    @Test
    void A_new_file_is_created_when_the_current_file_overflows(){
        AuditManager sut = new AuditManager(3);
        File file = new File("audit1.txt");
        File file1 = new File("audit2.txt");
        File file2 = new File("audit3.txt");
        List<File> list = new ArrayList<>();
        list.add(file);
        list.add(file1);
        list.add(file2);

        FileUpdate update = sut.AddRecord("hamster", LocalDateTime.now(), list);

        Assertions.assertEquals("audit4.txt",update.getFileName());
        Assertions.assertEquals("hamster;2019-04-06T18:00:00",update.getNewContent());
    }

}