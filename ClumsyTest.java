/**
 * Assuming a threaded environment, and without knowing anything else,
 * what is the potential problem with myMethod()?
 * Fix it in the simplest way.
 */

public class ClumsyTest {
    private static final String FUBAR = "fubar";

    public boolean myMethod(final MyObject bar) {
        if (bar.getFoo() != null) {
            //potential problem is that after line 11
            //in some other thread string foo becomes null .
            return FUBAR.equals(bar.getFoo());
        } else {
            return false;
        }
    }

    public interface MyObject {
        String getFoo();
        void setFoo(String o);
    }
}
