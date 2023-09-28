package junit.testing.ch6.functionalpractice.threestep.persister;

import junit.testing.ch6.functionalpractice.threestep.File;
import junit.testing.ch6.functionalpractice.threestep.MyComputer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Persister {

    public List<File> ReadDirectory(String directoryName){
        Map<String, File> fileList = MyComputer.getFileList();
        return new ArrayList<>(fileList.values());
    }

    public void ApplyUpdate(String directoryName,FileUpdate update){
        //대충뭐 업데이트한다.
    }

}
