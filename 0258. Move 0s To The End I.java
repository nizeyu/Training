public class Solution {
  public int[] moveZero(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }

    int i = 0;// non-zero
    int j = array.length - 1; //zero
    while (i <= j) {
      if (array[i] == 0) {
        swap(array, i, j--);
      } else {
        i++;
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
