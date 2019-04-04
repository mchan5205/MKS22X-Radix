import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = (MyLinkedList<Integer>[])new MyLinkedList[20];
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
        if (buckets[y].same()){
          data[d] = buckets[y].removeFront();
          d += 1;
        }
      }
      for (int h = 0 ; h < buckets.length; h++){
        buckets[h].clear();
      }
    }
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
