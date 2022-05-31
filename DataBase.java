package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Song;
public class DataBase {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    static final String USER = "postgres";
    static final String PASS = "Pavan@123";
    private Connection conn = null;
    private Statement stmt = null;
    public ArrayList<String> songs = null;
    public ArrayList<Song>songInfo=null;
    protected Connection getConnection() {
    	try {
    	conn = DriverManager.getConnection(DB_URL, USER,PASS);}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return conn;
    }
    public void createTable(){
        /*try{
            System.out.println("Connection to Database");
            conn = getConnection();
            System.out.println("Executing SQL Query");
            stmt = conn.createStatement();
            String sql = "create table songs(title varchar(50), album varchar(50), " +
                    "artist varchar(50), track varchar(50), version varchar(4), year varchar(20));" ;
            stmt.executeUpdate(sql);
            System.out.println("Table Creater Successfully");
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }*/
    }
    public void insert(ArrayList<String> arr){
        try {
            System.out.println("Connection to DataBase");
            conn = getConnection();
            System.out.println("Executing SQL Query");
            String sql = "insert into songs(title, album, artist, track,version,year) Values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (String str : arr) {
                String[] entries = str.split("\t");
                stmt.setString(1, entries[0]);
                stmt.setString(2, entries[1]);
                stmt.setString(3, entries[2]);
                stmt.setString(4, entries[3]);
                stmt.setString(5, entries[4]);
                stmt.setString(6, entries[5]);
                stmt.executeUpdate();
            }
            stmt.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<String> getSongs() {
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement("Select title from songs");){
    			ResultSet rs = preparedStatement.executeQuery();
    			while(rs.next()) {
    				songs.add(rs.getString("title"));
    			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return songs;
    }
    public ArrayList<Song> getSong(String title) {
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement("Select title,album,artist,track,version,year from songs where title=?");){
    			preparedStatement.setString(1,title);
    			ResultSet rs = preparedStatement.executeQuery();
    			while(rs.next()) {
    				String album = rs.getString("album");
    				String artist = rs.getString("artist");
    				String track = rs.getString("track");
    				String version = rs.getString("version");
    				String year = rs.getString("year");
    				Song temp = new Song(title,album,artist,track,version,year);
    				songInfo.add(temp);
    			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return songInfo;
    }
}
