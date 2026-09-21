public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        this.songs = new String[maxSongs];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}
