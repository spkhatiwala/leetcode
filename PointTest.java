import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Fix the problem in the following code by changing the Point class only,
 * without touching the code in main(). Make only the necessary changes.
 */

public class PointTest {
    static final class Point {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        private double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(final String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 2));
        pointList.add(new Point(3, 4));
        System.out.println(pointList.size());
        // remove the second Point
        pointList.remove(new Point(3, 4));
        System.out.println(pointList.size());
        // Not removed!
    }
}