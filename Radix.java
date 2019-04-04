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
      if (count > digits){
        digits = count;
      }
    }
    for (int q = 0; q < digits; q++){
      for (int w = 0; w < data.length; w++){
        if (data[w] >= 0){
          buckets[10 + (data[w] / ((int) Math.pow(10, q)) % 10)].add(new Node<Integer>(data[w]));
        }
        else{
          buckets[9 - Math.abs(data[w] / ((int) Math.pow(10, q)) % 10)].add(new Node<Integer>(data[w]));
        }
      }
      int d = 0;
      for (int y = 0; y < buckets.length; y++){
        while(buckets[y].hasNext()){
          data[d] = buckets[y].removeFront();
          d += 1;
        }
      }
    }
  }
}
