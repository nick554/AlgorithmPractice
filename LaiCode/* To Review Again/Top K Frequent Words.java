/*
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [¡°b¡±, ¡°c¡±]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]

*/

/*
  Time:  O() 
  Space: O()
*/

public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // count freq.
    Map<String, Integer> Freq = new HashMap<String, Integer>();
    for (String word : combo) {
      if ( Freq.containsKey( word ) ) {
        Freq.put(word, Freq.get( word ) + 1);
      } else {
        Freq.put(word, 1);
      }
    }

    // corner case if Freq.size() < k
    if (Freq.size() < k) {
      k = Freq.size();
    }
    
    // add to a heap (heapify)
    PQ< Map.Entry<String, Integer> > MaxHeap = new PQ( Freq.entrySet(), 
                new Comparator< Map.Entry<String, Integer> >() {
                  public int compare( Map.Entry<String, Integer> o1,
                          Map.Entry<String, Integer> o2 ) {
                    return -o1.getValue().compareTo( o2.getValue() );
                  }
                });
    
    // pop to get result klogw
    String[] result = new String[k];
    for (int i = 0; i < k; i++) {
      Map.Entry<String, Integer> current = MaxHeap.poll();
      result[i] = current.getKey();
    }
    
    return result;
  }
  class PQ< T > {
    private Object[] array;
    private int size;
    private Comparator<T> comparator;
    public PQ( Set<T> entryset, Comparator<T> comparator ) {
      // initialize array
      array = new Object[ entryset.size() ];
      size = 0;
      for(T element : entryset) {
        array[size++] = element;
      }
      this.comparator = comparator;
      heapify();
    }

    private void heapify() {
      // heapify the array
      for (int i = (size >>> 1) - 1; i >= 0; i--) {
        percolateDown(i, (T)array[ i ]);
      }
    }

    private void percolateDown(int i, T e) {
      int half = size >>> 1;

      while ( i < half ) {
        int child = (i << 1) + 1;
        T temp = (T)array[child];
        if (child + 1 < size && 
              0 < comparator.compare( temp, (T) array[child + 1]) ) {
          child++;
          temp = (T) array[child];
        }
        if (comparator.compare(e, temp) > 0) {
          array[child] = e;
          array[i] = temp;
          i = child;
        } else {
          break;
        }
      }
    }
    public T poll() {
      if (size == 0) return null;
      T top = (T)array[0];
      size--;
      array[0] = array[size];
      array[size] = null;
      if (size != 0) {
        percolateDown(0,(T)array[0]);
      }
        return top;
      }
    }
  }
}
/*
  class MyEntry<K,V> implements Map.Entry<K,V>, Comparable< MyEntry<K,V> >{
    private K key;
    private V value;

    public MyEntry(Map.Entry<K,V> e){
      key = e.getKey();
      value = e.getValue();
    }
			
    @Override
    public K getKey() {
      return key;
    }
    public V getValue() {
      return value;
    }
    public int hashCode() {
      return key.hashCode();
    }
    public V setValue(V v) {
      return value = v;
    }
    @SuppressWarnings("unchecked")
    public int compareTo(MyEntry<K, V> o) {
      return ( (Comparable<V>)( this.getValue() ) ).compareTo( o.getValue() );
    }
  }

*/