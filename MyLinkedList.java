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
    E temp = start.getData();
    start = start.getNext();
    return temp;
  }
  public boolean same(){
    if (start == end && start != null){
      return true;
    }
    return false;
  }
  public boolean hasNext(){
    if (start == end || start == null){
      return false;
    }
    else{
      return true;
    }
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
