package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (this.length <= 0) {
            System.out.println("Lỗi: Track '" + this.title + "' có độ dài hợp lệ <= 0 và không thể phát!");
            return;
        }
        System.out.println("Đang phát Track: " + this.getTitle());
        System.out.println("Độ dài Track: " + this.getLength() + " giây");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return this.title != null && this.title.equalsIgnoreCase(track.getTitle()) && this.length == track.getLength();
    }
}