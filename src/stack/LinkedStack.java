package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

	protected LLNode<T> top;
	protected int MySize=0;
	
	public LinkedStack()
	{
		top=null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		LLNode<T> newNode;
		if(isEmpty())
		{
			throw new StackUnderflowException("Stack should be empty after being constructed.");
		}
		else
		{
			newNode=new LLNode<T>((T) top.getInfo());
			top=top.getLink();
			MySize-=1;
		}
		
		return (T)(newNode.getInfo());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
	
		if(top==null)
			throw new StackUnderflowException("Stack should be empty after being constructed.");
		else
		{
		return (T)(top.getInfo());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		if(top==null)
			return true;
		else
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return MySize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		LLNode<T> newNode = new LLNode<T>(elem);
		newNode.setLink(top);
		top=newNode;
		MySize+=1;
	}

}
