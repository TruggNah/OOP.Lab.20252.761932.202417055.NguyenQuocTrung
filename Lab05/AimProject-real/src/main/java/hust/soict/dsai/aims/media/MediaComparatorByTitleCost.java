package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh tiêu đề theo thứ tự bảng chữ cái (alphabetical)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());

        // Nếu tiêu đề khác nhau thì trả về kết quả luôn
        if (titleCompare != 0) {
            return titleCompare;
        }

        // Nếu trùng tiêu đề, sắp xếp theo giá giảm dần (higher cost first)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}