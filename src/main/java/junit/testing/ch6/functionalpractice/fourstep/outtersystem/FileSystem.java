package junit.testing.ch6.functionalpractice.fourstep.outtersystem;


import junit.testing.ch6.functionalpractice.threestep.File;
import junit.testing.ch6.functionalpractice.threestep.MyComputer;

// 추상화 한것이다. => 이게왜 추상화지?
public class FileSystem {

    public File getFile(String fileName){
        return MyComputer.getFile(fileName);
    }

    public void setFile(File file) {
        MyComputer.setFile(file);
    }

}
