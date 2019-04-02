public class MyLinkedList<E>{
  private Node start;
  private Node end;
  public MyLinkedList(){
  }
  public void clear(){
    start = null;
    end = null;
  }
  public boolean add(Node n){
    if (start == null){
      start = n;
      return true;
    }
    end.setNext(n);
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
}
