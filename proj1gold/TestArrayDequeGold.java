import org.junit.Test;
import static org.junit.Assert.*;


public class TestArrayDequeGold {
    @Test
    public void testStudentArray() {
        StudentArrayDeque<Integer> bad = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> good = new ArrayDequeSolution<Integer>();

        String output = "";
        Integer expect;
        Integer actual;

        while (true) {
            double randNum = StdRandom.uniform();
            int tmp = StdRandom.uniform(10);
            if (randNum < 0.25) {
                bad.addFirst(tmp);
                good.addFirst(tmp);
                System.out.printf("addFirst(%d)\n", tmp);
            } else if (randNum >= 0.5 && randNum < 0.75) {
                bad.addLast(tmp);
                good.addLast(tmp);
                System.out.printf("addLast(%d)\n",tmp);
            } else if (randNum < 0.5 && randNum >= 0.25
                    && !bad.isEmpty() && !good.isEmpty()) {
                actual = bad.removeFirst();
                expect = good.removeFirst();
                System.out.printf("removeFirst()\n");
                assertEquals(expect, actual);
            } else if (randNum >= 0 && randNum < 0.25
                    && !bad.isEmpty() && !good.isEmpty()) {
                actual = bad.removeLast();
                expect = good.removeLast();
                System.out.printf("removeLast()\n");
                assertEquals(expect, actual);
            } else {
                assertEquals(good.isEmpty(), bad.isEmpty());
            }
        }
    }
}