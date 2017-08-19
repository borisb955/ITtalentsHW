package homework;

public class Demo {

	public static void main(String[] args) {
		Task task1 = () -> System.out.println("Taq rabota se pravi bavnichko");;
		Task task2 = () -> System.out.println("Mnogo burzo bachkat tuk");
		Task task3 = () -> System.out.println("Ne si davat mn zor na toq Task");
		Task task4 = () -> System.out.println("Stroi se");
		
		Scheduler sc = new Scheduler();
		sc.push(task1);
		sc.push(task2);
		sc.push(task3);
		sc.push(task4);
		sc.main();
	}

}
