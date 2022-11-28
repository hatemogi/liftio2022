package liftio2022;

import io.vavr.collection.List;
import io.vavr.test.Arbitrary;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;
import static liftio2022.ListFunctions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFunctionsTest {

    @Test
    public void testLength() {
        assertEquals(0, length(List.empty()));
        assertEquals(3, length(List.of(1, 2, 3)));
    }

    @Test
    public void testReplicate() {
        assertEquals(List.empty(), replicate(0, 1));
        assertEquals(List.of(1, 1, 1), replicate(3, 1));
    }

    @Test
    public void testReplicatedLength() {
        assertEquals(0, length(replicate(0, 'a')));
        assertEquals(100, length(replicate(100, 'x')));
    }

    @Test
    public void propertyLengthIsPositive() {
        Arbitrary<Integer> ints = Arbitrary.integer();
        Arbitrary<List<Integer>> xss = Arbitrary.list(ints);
        Property.def("length(xs) >= 0")
                .forAll(xss)
                .suchThat(xs -> length(xs) >= 0)
                .check()
                .assertIsSatisfied();
    }

    @Test
    public void propertyReplicatedLength() {
        Arbitrary<Integer> nonNegativeInt = Arbitrary.integer().map(Math::abs);
        Arbitrary<Character> xs = Arbitrary.of('a', 'b', 'c', 'd' , 'e');
        Property.def("length(replicate(n, x)) == n")
                .forAll(nonNegativeInt, xs)
                .suchThat((n, x) -> length(replicate(n, x)) == n)
                .check()
                .assertIsSatisfied();
    }
}
