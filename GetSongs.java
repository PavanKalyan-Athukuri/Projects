package model;
import java.io.File;
import java.io.FilenameFilter;

public class GetSongs {
    File folder;
    public GetSongs(String path){
        this.folder = new File(path);
    }
    public File[] getSongs(){
        File folder = new File("D:/folder");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };
        File[] listofsongs = folder.listFiles(filter);
        return listofsongs;
    }
}
