
// labb 3 DD1380
// beräknar ett aritmetiskt uttryck

import java.util.Scanner; 
import java.util.Stack;

public class Formell {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String rad = sc.nextLine();
        //System.out.println(rad);

		sc.close();
		
        System.out.println(evaluate(rad));
        
    }

	// algoritm som utvärderar uttrycket med hjälp av två stackar
	public static long evaluate(String expression) {

		// sparar raden som en lista, som vi sedan ittererar över
		char[] tokens = expression.toCharArray();

		// Stack for siffror: 'values'
		Stack<Long> values = new Stack<Long>();

		// Stack for operatorer: 'ops'
		Stack<Character> ops = new Stack<Character>();

		// läser ett steg i taget och hanterar alla fall:
		// space, siffror, operatorer, parenteser
		for (int i = 0; i < tokens.length; i++) {
			
			// om space, hoppa över
			if (tokens[i] == ' ')
				continue;

			// om tal, lägg på värdes stacken
			if (tokens[i] >= '0' && tokens[i] <= '9') {

				// anänder en StringBuffer för att omvandla och lägga på stacken
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')

					sbuf.append(tokens[i++]);

					// omvandlar till ints och lägger till på stacken
				    values.push(Long.parseLong(sbuf.toString()));

				i--; // korrigerar for loopen
			}

			// om startparentes, lägg på operator stacken
			else if (tokens[i] == '(')

				ops.push(tokens[i]);

			// slutparentes, lös
			else if (tokens[i] == ')') {

				// så länge första värdet på ops stacken inte är en startparentes
				while (ops.peek() != '(')

					// beräknar och lägg på värdes stacken
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.pop(); // tar bort startparentesen
			}

			// om operator, beräkna eller lägg på stacken
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

				// om giltig operation
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))

					// beräknar och lägg på värdes stacken
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				// annars lägger vi på stacken
				ops.push(tokens[i]);
			}
		}

		// när vi har läst in allt, sista stegt
		while (!ops.empty()) 

			// lägg på värdes stacken
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			
		// sista värdes på värdes stacken är svaret
		return values.pop();

	}

	// testar företräde och giltig operation
	public static boolean hasPrecedence(char op1, char op2) {

		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true; 
	}

	// beräknar värdet
	public static long applyOp(char op, long b, long a) {

		switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                // behöver vi hantera if (b == 0)?
                return a / b;
		}

		return 0;

	}
}
  