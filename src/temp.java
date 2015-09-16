import java.util.Stack;
import java.util.StringTokenizer;

public class temp {
	
	public static void main(String args[])
	{
		Stack<String> operatorStack = new Stack<String>();
		Stack<Double> valueStack = new Stack<Double>();
		String s = "8.4 / 3.2";
		StringTokenizer tokens = new StringTokenizer(s);
		while(tokens.hasMoreTokens())
		{
			String current = tokens.nextToken();
			Double number = null;
			try
			{
				number = Double.parseDouble(current);
			}
			catch(NumberFormatException nfe)
			{
				number=null;
			}
			if(number!=null)
				valueStack.push(number);
			else if(current.equals("^"))
			{
				operatorStack.push(current);
			}
			else if(current.equals("("))
			{
				operatorStack.push(current);
			}
			else if(current.equals("+")||current.equals("-")||current.equals("*")||current.equals("/"))
			{
				while(!operatorStack.isEmpty()&&precedence(current)<precedence(operatorStack.peek()))
				{
					Double a = valueStack.pop();
					Double b = valueStack.pop();
					Double result=0.0;
					String operator = operatorStack.pop();
					switch(operator)
					{
						case "+": result= b+a;
									break;
						case "-": result= b-a;
									break;
						case "*": result = b*a;
									break;
						case "/": result = b/a;
									break;
					}
					valueStack.push(result);
				}
				operatorStack.push(current);
			}
			else if(current.equals(")"))
			{
				while(!operatorStack.peek().equals("("))
				{
					Double a = valueStack.pop();
					Double b = valueStack.pop();
					Double result=0.0;
					String operator = operatorStack.pop();
					switch(operator)
					{
						case "+": result= b+a;
									break;
						case "-": result= b-a;
									break;
						case "*": result = b*a;
									break;
						case "/": result = b/a;
									break;
					}
					valueStack.push(result);
				}
				operatorStack.pop();
			}
					
		}
		while(!operatorStack.isEmpty())
		{
			Double a = valueStack.pop();
			Double b = valueStack.pop();
			Double result=0.0;
			String operator = operatorStack.pop();
			switch(operator)
			{
				case "+": result= b+a;
							break;
				case "-": result= b-a;
							break;
				case "*": result = b*a;
							break;
				case "/": result = b/a;
							break;
			}
			valueStack.push(result);
		}
		System.out.println(valueStack.peek());
	}
	private static int precedence(String operator)
	{
		switch(operator)
		{
        	case "(": return 0;
        	case ")": return 0;
        	case "+": return 1;
        	case "-": return 1;
        	case "*": return 2;
        	case "/": return 2;
        	case "^": return 3;
		}
		return -1;
	}
}
