package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
        super();
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " seconds");
    }
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem có trỏ cùng ô nhớ không
        if (this == obj) {
            return true;
        }

        // Kiểm tra null và kiểm tra kiểu dữ liệu có phải là Track hay không
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        // Ép kiểu Object về kiểu Track
        Track other = (Track) obj;

        // So sánh đồng thời cả thời lượng (length) và tiêu đề (title)
        boolean isLengthEqual = (this.length == other.length);
        boolean isTitleEqual = false;

        if (this.title == null) {
            isTitleEqual = (other.title == null);
        } else {
            isTitleEqual = this.title.equalsIgnoreCase(other.title);
        }

        // Cả 2 điều kiện phải đồng thời đúng
        return isLengthEqual && isTitleEqual;
    }
}