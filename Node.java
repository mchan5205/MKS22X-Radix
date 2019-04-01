public class Node<E>{
  private E data;
  private Node next;
  public Node(E da, Node ne){
    data = da;
    next = ne;
  }
  public void setNext(Node ne){
    next = ne;
  }
  public Node getNext(){
    return next;
  }
}
