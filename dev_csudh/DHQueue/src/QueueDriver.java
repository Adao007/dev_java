// Testing the Queue and its methods
public class QueueDriver {

	public static void main(String[] args) {
		// Create a queue object
		CircularQueue<Integer> queue = new CircularQueue<>(); 	//Using default constructor
		queue.offer(10); System.out.println(queue); 
		queue.offer(100); System.out.println(queue);
		queue.offer(1000); System.out.println(queue);
		queue.offer(100000); System.out.println(queue);
		queue.poll(); System.out.println(queue); 
		queue.offer(1); System.out.println(queue); 
		queue.offer(2); System.out.println(queue);
		queue.offer(3); System.out.println(queue);
		queue.offer(4); System.out.println(queue); 
		queue.offer(5); System.out.println(queue);
		queue.offer(6); System.out.println(queue);
		queue.offer(7); System.out.println(queue);
		queue.offer(8); System.out.println(queue);
		queue.offer(9); System.out.println(queue);
		queue.poll(); queue.poll(); queue.poll();
		queue.offer(10);
		System.out.println(queue);
	}

}
