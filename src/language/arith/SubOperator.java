package language.arith;
import language.Operand;
import language.Operator;

/**
 * The {@code SubOperator} is an operator that performs subtraction on two
 * integers.
 * @author jcollard
 *
 */
public class SubOperator implements Operator<Integer> {

	private Operand<Integer> op0;
	private Operand<Integer> op1;
	
	//TODO Before you get started, have you looked at the
	// PlusOperator class? You'll notice that it is taking advantage
	// of the abstract BinaryOperator class. Take a moment to
	// also look at that class. Finally, you should implement
	// this class.

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNumberOfArguments() {
	     
	     return 2;
		//TODO Before you get started, have you looked at the
		// PlusOperator class? You'll notice that it is taking advantage
		// of the abstract BinaryOperator class. Take a moment to
		// also look at that class. Finally, you should implement
		// this class.

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operand<Integer> performOperation() {
		// PlusOperator class? You'll notice that it is taking advantage
		// of the abstract BinaryOperator class. Take a moment to
		// also look at that class. Finally, you should implement
		// this class.
		if(op0 == null || op1 == null)
			throw new IllegalStateException("Could not perform operation prior to operands being set.");
		Integer result=op0.getValue()-op1.getValue();
		return new Operand<Integer>(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<Integer> operand) {
		// PlusOperator class? You'll notice that it is taking advantage
		// of the abstract BinaryOperator class. Take a moment to
		// also look at that class. Finally, you should implement
		// this class.
		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i > 1)
			throw new IllegalArgumentException("Binary operator only accepts operands 0 and 1 but recieved " + i + ".");
		if(i == 0){
			if(op0 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op0 = operand;
		} else {
			if(op1 != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			op1 = operand;
		}
		
	}

}
