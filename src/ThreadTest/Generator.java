package ThreadTest;

public interface Generator<T>{
	public T next();
	public boolean hasNext();
}
