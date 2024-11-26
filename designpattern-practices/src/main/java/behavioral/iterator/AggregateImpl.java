package behavioral.iterator;

public class AggregateImpl<E> implements Aggregate<E> {
	private E[] datas;

	public AggregateImpl(E[] datas) {
		this.datas = datas;
	}

	@Override
	public Iterator<E> createIterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<E> {  //<E> 쓰면 앞에랑 충돌나서 헷갈림, <T>하면 갠춘, 근데 T로 참조하는 애가 없으니,,,
		private int index = 0;

		@Override
		public E next() {
			return index < datas.length ? datas[index++] : null;
		}

		@Override
		public boolean hasNext() {
			return index < datas.length;
		}

	}

}
