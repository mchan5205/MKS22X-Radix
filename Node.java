public class Node<E>{
  private E data;
  private Node<E> next;
  public Node(E da, Node<E> ne){
    data = da;
    next = ne;
  }
  public void setNext(Node<E> ne){
    next = ne;
  }
  public Node<E> getNext(){
    return next;
  }
  public E getData(){
    return data;
  }
  public void setData(E da){
    data = da;
  }
}
