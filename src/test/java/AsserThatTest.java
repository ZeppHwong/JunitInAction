import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AsserThatTest {
    @Test
    public void testMatchBehavior() {
        int myAge = 30;
        assertThat(myAge, equalTo(30));
        assertThat(myAge, is(30));
        assertThat(myAge,not(equalTo(33)));
        assertThat(myAge, is(not(33)));
    }

    @Test
    public void testMultipleValues(){
        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(90.9)));
        assertThat(marks, both(not(99.99)).and(not(60.00)));
        assertThat(marks, anyOf(is(100.00), is(1.00), is(90.0)));
        assertThat(marks, not(anyOf(is(1.00), is(200.00))));
        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.0))));
    }

    @Test
    public void verifyCollection(){
        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);
        assertThat(salary, hasItem(500.0));
        assertThat(salary,hasItems(50.0, 200.0));
        assertThat(salary,not(hasItem(10.0)));
    }

    @Test
    public void verifyString(){
        String string = "John Jr Dale";
        assertThat(string, startsWith("John"));
        assertThat(string, endsWith("Dale"));
        assertThat(string, containsString("Jr"));
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t){
        return new LessThanOrEqual(t);
    }

    @Test
    public void testLessThanOrEqual(){
        int actual = 2;
        int expect = 4;
        assertThat(actual, lessThanOrEqual(expect));

        double actualDouble = 2.22;
        double expectDouble = 3.33;
        assertThat(actualDouble, lessThanOrEqual(expectDouble));

        String actualString = "Sua";
        String expectStirng = "Su";
        assertThat(actualString, lessThanOrEqual(expectStirng));

    }
}
