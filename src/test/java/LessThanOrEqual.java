import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {
    private final Comparable<T> expect;

    public LessThanOrEqual(Comparable<T> expect) {
        this.expect = expect;
    }

    public boolean matches(Object o) {
        int compareTo = expect.compareTo((T)o);
        return compareTo > -1;
    }

    public void describeTo(Description description) {
        description.appendText(" less than or equal(<=) expect");
    }
}
