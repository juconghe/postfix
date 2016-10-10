package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.StackInterface;
import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;
import stack.LinkedStack;
/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostFixEvaluator}
	 */
	public ArithPostFixEvaluator(){
		this.stack = new LinkedStack<Operand<Integer>>();//TODO Initialize to your LinkedStack
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) {
		// TODO Use all of the things they've built so far to 
		// create the algorithm to do post fix evaluation
		ArithPostFixParser parser = new ArithPostFixParser(expr);
		while(parser.hasNext()){
			switch(parser.nextType()){ 
			case OPERAND:
			{
				//TODO What do we do when we see an operand?
				stack.push(parser.nextOperand());
			}
				break;
			case OPERATOR:
				{  
					Operator<Integer> operator= parser.nextOperator();
					int temp=operator.getNumberOfArguments()-1;
					while(!stack.isEmpty()&&temp>=0)
					{						
						operator.setOperand(temp, stack.pop());
						temp-=1;
					}
					Operand<Integer> result=operator.performOperation();
					stack.push(result);
				}
			}
		}
	      if(stack.size()==1)
			return stack.pop().getValue();
		else	
	  throw new IllegalPostFixExpressionException("Not a Legal Operator");
	}

}
