
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Fix the following code so the the map.get() call
 * retrieves the expected value.
 * Do not change the main method.
 */
public class StudentTest {
    public static final class Student {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public Student(String name ) {
            this.name = name;
        }
        private String name;
    }

    public static void main(final String[] args ) {
        Map<Student, String> map = new HashMap<>();
        map.put( new Student( "john"), "present" );
        System.out.println( map.get( new Student( "john" ) ) );
    }
}