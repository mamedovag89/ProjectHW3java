package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable {
        private String fileName;
        private String fileType;
        private static FileHandler fileHandler;

        public synchronized static FileHandler getFileHandler(String fileName, String fileType) {
            if (fileHandler == null){
                fileHandler = new FileHandler(fileName, fileType);
            }
            return fileHandler;
        }
    
        private FileHandler(String fileName, String fileType){
            this.fileName = fileName;
            this.fileType = fileType;
        }
    
        public String getFileName() {
            return fileName;
        }
    
        public String getFileType() {
            return fileType;
        }

    @Override
    public void writeTreeInFile(FamilyTree object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(fileName + "." + fileType));
        out.writeObject(object);
        out.close();
    }
    @Override
    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream (
            new FileInputStream(fileName + "." + fileType));
             FamilyTree myTree = (FamilyTree) inputStream.readObject();
             inputStream.close();
             return myTree;
                
            }
        
}

