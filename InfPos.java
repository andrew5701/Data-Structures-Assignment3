//Andrew Krasuski
public class InfPos {
	
	

	public void createInfixQueue(String expression, QueueADT queue) {
		String delimiter = " ";
		String[] variables = expression.split(delimiter);

		for(int i = 0; i < variables.length; i++) {
			queue.enqueue(variables[i]); 
		}
	}

	public int priorityValue(String operand) {

		switch(operand) {
		case "(":
			return 3;

		case "*":
			return 2;

		case "/":
			return 2;

		case "+":
			return 1;

		case "-":
			return 1;

		case ")":
			return 0;

		case "#":
			return 0;



		}

		return -1;
	}

	public void toPostfix(QueueADT infixQueue, QueueADT postfixQueue, StackADT operatorStack) {

		boolean parenCheck = false;

		operatorStack.push("#");

		while(!infixQueue.front().equals("#") || infixQueue.front() != null) {

			if(infixQueue.front().equals("#")) {
				break;
			}


			if(operatorStack.onTop().equals("(")) {
				parenCheck = true;

				if (priorityValue(infixQueue.front()) == -1) {

					postfixQueue.enqueue(infixQueue.dequeue());

				}


			}




			if(parenCheck == false) {

				if (priorityValue(infixQueue.front()) == -1) {

					postfixQueue.enqueue(infixQueue.dequeue());

				}

				else if(priorityValue(operatorStack.onTop()) >= priorityValue(infixQueue.front()) && !"(".equals(infixQueue.front()) && !"#".equals(operatorStack.onTop())) {
					postfixQueue.enqueue(operatorStack.pop());
					operatorStack.push(infixQueue.dequeue());
				}

				else {
					operatorStack.push(infixQueue.dequeue());
				}
			}

			if(infixQueue.front().equals("#")) {
				break;
			}


			if(parenCheck == true) {

				if(infixQueue.front().equals(")")) {
					while(!"(".equals(operatorStack.onTop())) {
						postfixQueue.enqueue(operatorStack.pop());
					}
					operatorStack.pop();
					infixQueue.dequeue();
					parenCheck = false;
				}

				else {
					if (priorityValue(infixQueue.front()) == -1) {

						postfixQueue.enqueue(infixQueue.dequeue());

					}
					else {
						operatorStack.push(infixQueue.dequeue());
					}


				}
			}



		}





		while(operatorStack.onTop() != null) {
			postfixQueue.enqueue(operatorStack.pop());
		}

	}

	//Part 2

	public int operandValuesP2(String data) {

		switch(data) {
		case "A":
			return 5;

		case "B":
			return 3;

		case "C":
			return 6;

		case "D":
			return 8;

		case "E":
			return 2;
		}

		return 0;

	}

	public int operatorValuesP2(int var1, int var2, String data) {

		switch(data) {
		case "*":
			return var2 * var1;

		case "+":
			return var2 + var1;

		case "/":
			return var2 / var1;

		case "-":
			return var2 - var1;


		}

		return 0;

	}

	public int operatorChecker(String data) {

		switch(data) {
		case "*":
			return 1;

		case "+":
			return 1;

		case "/":
			return 1;

		case "-":
			return 1;


		}

		return 0;

	}

	

	public void valueStackMethod(StackADT valueStack, StackADT source) {

		int val = 0;
		int checker = 0;

		while(source.onTop() != null) {
			val = operandValuesP2(source.onTop());
			if(val == 0) {
				if(operatorChecker(source.onTop()) == 0) {
					break;
				}
				valueStack.push(String.valueOf(operatorValuesP2(Integer.valueOf(valueStack.pop()), Integer.valueOf(valueStack.pop()), source.onTop())));
				source.pop();
			}
			else {
				valueStack.push(String.valueOf(val));
				source.pop();
			}
		}
	}


		 
}
