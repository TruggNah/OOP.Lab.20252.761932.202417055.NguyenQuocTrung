package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Constructor mặc định
    public CompactDisc() {
        super();
    }

    // Constructor đầy đủ tham số
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director, 0);
        this.artist = artist;
    }

    // Hàm lấy thông tin nghệ sĩ
    public String getArtist() {
        return artist;
    }

    // Phương thức thêm bài hát (Kiểm tra xem bài hát đã tồn tại chưa)
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("The track \"" + track.getTitle() + "\" has been added successfully.");
        }
    }

    // Phương thức xóa bài hát (Kiểm tra xem bài hát có trong danh sách không)
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("The track \"" + track.getTitle() + "\" is not found in the CD.");
        }
    }

    // Ghi đè hàm lấy thời lượng: Tính tổng thời lượng của tất cả các bài hát cộng lại
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Hiện thực hóa phương thức play() để chạy toàn bộ đĩa CD
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by artist: " + this.getArtist());
        System.out.println("Total CD length: " + this.getLength() + " seconds");
        System.out.println("----------------------------------------");

        // Vòng lặp đa hình để gọi hàm play() của từng bài hát thành phần
        for (Track track : tracks) {
            track.play();
        }
    }
    // Ghi đè phương thức hiển thị thông tin đĩa CD dưới dạng chuỗi
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getDirector() + " - Artist: "
                + this.getArtist() + " - Length: "
                + this.getLength() + "s: "
                + this.getCost() + " $";
    }
}