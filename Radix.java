public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList<Integer>[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    int digits = 0;
    for (int n = 0; n < data.length; n++){
      int count = 0;
      int num = data[n];
      while (num != 0){
        num = num / 10;
        count += 1;
      }
    }
  }
}
