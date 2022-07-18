package apple.design;

import java.util.LinkedList;
import java.util.Queue;

class HitCounter {

    Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
        while(!queue.isEmpty() && queue.peek() <= (timestamp - 300)){
            queue.poll();
        }
        return queue.size();
    }
}
