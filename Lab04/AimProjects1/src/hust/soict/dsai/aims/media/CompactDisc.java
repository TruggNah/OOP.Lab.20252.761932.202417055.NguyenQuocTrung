package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director); // length ban đầu truyền tạm là 0, sẽ tính qua getLength()
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' đã tồn tại trên CD này.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy track '" + track.getTitle() + "' để xóa.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track t : tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Lỗi: CD '" + this.getTitle() + "' không thể phát do không có track nào hoặc tổng độ dài <= 0!");
            return;
        }
        System.out.println("Đang phát CD: " + this.getTitle() + " (Nghệ sĩ: " + this.getArtist() + ")");
        System.out.println("Tổng thời lượng CD: " + this.getLength() + " giây");
        System.out.println("---------------------------------");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - Nghệ sĩ: " + artist + " - Số bài hát: " + tracks.size() + " - Tổng thời lượng: " + getLength() + " giây - Giá: " + getCost() + "$";
    }
}