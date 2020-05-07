public class Solution {
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }

    int i = 0;
    int j = 0;
    int k = array.length - 1;
    // [0,i) -1
    // [i,j) 0
    // [j,k) discover
    // (k,end] 1 
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i++, j++);
      } else if (array[j] == 0) {
        j++;
      } else {
        swap(array, j, k--);
      }
    }

    return array;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
