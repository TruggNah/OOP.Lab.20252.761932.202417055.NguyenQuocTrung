package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh giá giảm dần (decreasing cost order)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());

        // Nếu giá khác nhau thì trả về kết quả luôn
        if (costCompare != 0) {
            return costCompare;
        }

        // Nếu trùng giá, sắp xếp theo tiêu đề tăng dần (alphabetical)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}