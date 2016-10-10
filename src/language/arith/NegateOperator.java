package language.arith;

import language.Operand;
import language.Operator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single integer
 * @author jcollard
 *
 */
public class NegateOperator implements Operator<Integer> {

	private Operand<Integer> op0;
	//You will notice that it extends the abstract class BinaryOperator
	// You should take a moment and review that class before trying to
	// implement this one. Although it is not required, 
	// it might be a good idea to first write
	// an abstract class called UnaryOperator that abstracts out
	// all the bits for UnaryOperators.
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumberOfArguments() {
		//You will notice that it extends the abstract class BinaryOperator
		// You should take a moment and review that class before trying to
		// implement this one. Although it is not required, 
		// it might be a good idea to first write
		// an abstract class called UnaryOperator that abstracts out
		// all the bits for UnaryOperators.
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operand<Integer> performOperation() {
		//TODO Have you taken a look at the PlusOperator yet?
		//You will notice that it extends the abstract class BinaryOperator
		// You should take a moment and review that class before trying to
		// implement this one. Although it is not required, 
		// it might be a good idea to first write
		// an abstract class called UnaryOperator that abstracts out
		// all the bits for UnaryOperators.
		if(op0 == null)
			throw new IllegalStateException("Could not perform operation prior to operands being set.");
		Integer result=op0.getValue()*-1;
		return new Operand<Integer>(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<Integer> operand) {
		//You will notice that it extends the abstract class BinaryOperator
		// You should take a moment and review that class before trying to
		// implement this one. Although it is not required, 
		// it might be a good idea to first write
		// an abstract class called UnaryOperator that abstracts out
		// all the bits for UnaryOperators.
		
		//So the negation of some int value i is -i.
		

		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i >= 1)
			throw new IllegalArgumentException("Binary operator only accepts operands 0 and 1 but recieved " + i + ".");
		else{
			if(op0 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op0 = operand;
		
		}
	}
}
