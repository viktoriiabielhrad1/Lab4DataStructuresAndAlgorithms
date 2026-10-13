import java.util.Scanner;
public class PrintServer {
	
 public static void displayMenu() {
	 System.out.println("Welcome to PrintServer! Please select a number from the list.");
	 System.out.println("1. Enqueue a job (User enters job details).");
	 System.out.println("2. Dequeue a job.");
	 System.out.println("3. Peek at the job at front of the queue.");
	 System.out.println("4. Empty the queue.");
	 System.out.println("5. Display all jobs.");
	 System.out.println("6. Quit the program.");
 }//end of displaymenu
 
	public static void main(String[] args) {
		QueueArrayBased queue = new QueueArrayBased();
		Scanner scanner = new Scanner(System.in);
		int response;
		do {
			displayMenu();
			response = scanner.nextInt();
			switch(response) {
				case 1: {
					System.out.println("Enter the PrintJob details!");
					System.out.print("Enter the job ID: ");
					int id = scanner.nextInt();
					scanner.nextLine();   
					System.out.print("Enter the document name: ");
					String doc_name = scanner.nextLine();
					System.out.print("Enter the number of pages: ");
					int num_pages = scanner.nextInt();
					PrintJob job = new PrintJob(id, doc_name, num_pages);
					queue.enqueue(job);
					System.out.println("Job added!");
					break;
				}//case1
				case 2:{
					try {
					System.out.println("Removed - " + queue.dequeue());
					}catch (QueueException e) {
						System.out.println(e.getMessage());
					}
					break;
				}//case2
				case 3:{
					try {
					System.out.println("Job at the front: " + queue.peek());
					}catch(QueueException e) {
						System.out.println(e.getMessage());
					}
					break;
				}//case3
				case 4:{
					queue.dequeueAll();
					System.out.println("Queue emptied.");
					break;
				}//case4
				case 5:{
					System.out.println("Displaying all jobs: ");
					queue.displayQueue();
					break;
				}//case5
				case 6:{
					System.out.println("Quitting the program...");
					break;
				}//case6
				default:{
					System.out.println("Invalid choice.");
					break;
				}//default
			}//switch
		}while(response != 6);
}//end of main
}//end of class
