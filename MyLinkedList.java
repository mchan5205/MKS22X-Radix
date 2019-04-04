public class MyLinkedList<E>{
  private Node<E> start;
  private Node<E> end;
  public MyLinkedList(){
  }
  public void clear(){
    start = null;
    end = null;
  }
  public boolean add(Node<E> n){
    if (start == null){
      start = n;
      return true;
    }
    if (end != null){
      end.setNext(n);
    }
    end = n;
    return true;
  }
  public void extend(MyLinkedList<E> other){
    end.setNext(other.start);
    end = other.end;
  }
  public E removeFront(){
    start = start.getNext();
    return start.getData();
  }
  public String toString(){
    String y = "";
    Node<E> current = start;
    while(current != end){
      y += current.getData() + " ";
      current = start.getNext();
    }
    y += current.getData();
    return y;
  }
}
