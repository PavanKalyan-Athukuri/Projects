package model;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.*;
import java.util.ArrayList;
import dao.DataBase;
public class Mp3 {
    public static void main(String args[]) throws IOException, InvalidDataException, UnsupportedTagException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Folder Path");
        String path = br.readLine();
        GetSongs songs = new GetSongs(path);
        File[] listofsongs = songs.getSongs();
        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        for (File listofsong : listofsongs) {
            SongInfo info = new SongInfo(listofsong);
            info.assignValues();
            str = info.getTitle()+"\t"+info.getAlbum()+"\t"+info.getArtist()+"\t"+info.getTrack()+"\t"+info.getVersion()+"\t"+info.getYear();
            arr.add(str);
        }
        DataBase db = new DataBase();
        db.createTable();
        db.insert(arr);
    }
}
