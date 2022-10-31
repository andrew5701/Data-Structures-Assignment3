//Andrew Krasuski
public class Hw3main {

	public static void main(String args[]) {
	
				String expression = "A * B + ( C - D / E ) #";

				InfPos method = new InfPos();

				QueueADT iQueue = new QueueADT();
				QueueADT pQueue = new QueueADT();
				StackADT oStack = new StackADT();


				method.createInfixQueue(expression, iQueue);

				System.out.print("Infix: ");
				iQueue.printQueue(iQueue);

				method.toPostfix(iQueue, pQueue, oStack);

				System.out.print("\n" + "\n" + "Postfix: ");
				pQueue.printQueue(pQueue);

				//Part 2
				
				

				StackADT vStack = new StackADT();
				StackADT testStack = new StackADT();
				StackADT qStack = new StackADT();
				
				pQueue.toStack(pQueue, testStack);
				
				while(testStack.onTop() != null) {
					qStack.push(testStack.pop());
				}
			
				
				method.valueStackMethod(vStack, qStack);

				System.out.print("\n" + "\n" + "Value stack evaluation: ");
				vStack.printStack(vStack);

	}
}
