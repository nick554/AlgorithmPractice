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
    
    // add to a heap (heapify)
    PQ< Map.Entry<String, Integer> > MaxHeap = heapify( Freq.entrySet() );
    
    // pop to get result klogw
    String[] result = new String[k];
    for (int i = 0; i < k; i++) {
      Map.Entry<String, Integer> current = MaxHeap.poll();
      result[i] = current.getKey();
    }
    
    return result;
  }
}