public class BSTcount {
  long[] memo;

  public long howMany(int[] values) {
    int size = values.length;
    memo = new long[size+1];

    return countComb(size);
  }

  public long countComb(int size) {
    if (size <= 1) {
      memo[size] = 1;
      return 1;
    }
    if (memo[size] != 0) {
      return memo[size];
    }
    long count=0;
    for (int left=0; left<size; left++) {
      int right = size-1-left;
      count += countComb(left)*countComb(right);
    }
    memo[size] = count;
    return count;
  }
}

/*
countComb(0)*countComb(2); 2
countComb(1)*countComb(1); 1
countComb(2)*countComb(0); 2 = 5
*/
