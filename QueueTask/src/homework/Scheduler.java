package homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
	private Queue<Task> opashka = new LinkedList<>();
	
	public void push(Task t){
		this.opashka.offer(t);
	}
	
	public void main(){
		for(Task task : this.opashka){
			task.doWork();
		}
	}
}
