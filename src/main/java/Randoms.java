import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        random = new Random();
    }

    public int getRandom() {
        return min + random.nextInt(max - min + 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomIterator(this);
    }

    protected static class RandomIterator implements Iterator<Integer> {
        protected Randoms target;

        public RandomIterator(Randoms target) {
            this.target = target;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return target.getRandom();
        }
    }
}
