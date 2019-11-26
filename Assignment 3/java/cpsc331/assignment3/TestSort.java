package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import cpsc331.assignment3.BetterMergeSort;
import java.util.Random;

public class TestSort {

  // Utility to construct a sorted integer ArrayList by inserting one
  // element at a time
  //
  // NOTE: This is, deliberately, written using programming techniques
  // that should NOT be used when completing Assignment #3
  
  private void insert(ArrayList<Integer> A, Integer v) {
  
    int len = A.size();
    int i = 0;
    Integer x = v;
    while ((i < len) && (A.get(i) <= x)) {
      i = i + 1;
    };
    while (i < len){
      Integer tmp = A.get(i);
      A.set(i, x);
      x = tmp;
      i = i + 1;
    };
    A.add(x);
  
  }
  
  // Test with an array with length one
  
  @Test
  public void TestLengthOne() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    A.add(7);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 1);
    assertTrue(B.get(0) == 7);
  
  }
  
  // Test with a small array whose entries are the same; default choice
  // of threshold
  
  @Test
  public void TestSmallSame1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 20) {
      A.add(5);
      i = i + 1;
    };
  
    BetterMergeSort<Integer> Tester  = new BetterMergeSort<Integer>();
    ArrayList<Integer> B = Tester.sort(A);
  
    assertTrue(B.size() == 20);
    if (B.size() == 20) {
      i = 0;
      while (i < 20) {
        assertTrue(B.get(i) == 5);
        i = i + 1;
      }
    };
    
  }
  
  // Test with a small array whose entries are the same; smaller choice
  // of threshold
  
  @Test
  public void TestSmallSame2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 20) {
      A.add(5);
      i = i + 1;
    };
  
    BetterMergeSort<Integer> Tester  = new BetterMergeSort<Integer>(2);
    ArrayList<Integer> B = Tester.sort(A);
  
    assertTrue(B.size() == 20);
    if (B.size() == 20) {
      i = 0;
      while (i < 20) {
        assertTrue(B.get(i) == 5);
        i = i + 1;
      }
    };
    
  }
    
  // Test with a small array whose entries are the same; intermediate choice
  // of threshold
  
  @Test
  public void TestSmallSame3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 20) {
      A.add(5);
      i = i + 1;
    };
  
    BetterMergeSort<Integer> Tester  = new BetterMergeSort<Integer>(8);
    ArrayList<Integer> B = Tester.sort(A);
  
    assertTrue(B.size() == 20);
    if (B.size() == 20) {
      i = 0;
      while (i < 20) {
        assertTrue(B.get(i) == 5);
        i = i + 1;
      }
    };
    
  }

  // Test with a small array whose entries are the same; larger choice
  // of threshold
  
  @Test
  public void TestSmallSame4() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 20) {
      A.add(5);
      i = i + 1;
    };
  
    BetterMergeSort<Integer> Tester  = new BetterMergeSort<Integer>(25);
    ArrayList<Integer> B = Tester.sort(A);
  
    assertTrue(B.size() == 20);
    if (B.size() == 20) {
      i = 0;
      while (i < 20) {
        assertTrue(B.get(i) == 5);
        i = i + 1;
      }
    };
    
  }
  
  // Test with a small array whose entries are increasing, default choice
  // of threshold
  
  @Test
  public void TestSmallIncreasing1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 25) {
      A.add(i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 25);
    if (B.size() == 25) {
      i = 0;
      while (i < 25) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    
    }
    
  }
    
  // Test with a small array whose entries are increasing, smaller choice
  // of threshold
  
  @Test
  public void TestSmallIncreasing2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 25) {
      A.add(i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(3);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 25);
    if (B.size() == 25) {
      i = 0;
      while (i < 25) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    
    }
    
  }
    
  // Test with a small array whose entries are increasing, intermediate choice
  // of threshold
  
  @Test
  public void TestSmallIncreasing3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 25) {
      A.add(i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(9);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 25);
    if (B.size() == 25) {
      i = 0;
      while (i < 25) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    
    }
    
  }
    
  // Test with a small array whose entries are increasing, larger choice
  // of threshold
  
  @Test
  public void TestSmallIncreasing4() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 25) {
      A.add(i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(30);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 25);
    if (B.size() == 25) {
      i = 0;
      while (i < 25) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    
    }
  
  }
  
  // Test with a small array whose entries are decreasing; default choice
  // of threshold
  
  @Test
  public void TestSmallDecreasing1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 30) {
      A.add(29 - i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 30);
    if (B.size() == 30) {
      i = 0;
      while (i < 30) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    };
  
  }

  // Test with a small array whose entries are decreasing; smaller choice
  // of threshold
  
  @Test
  public void TestSmallDecreasing2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 30) {
      A.add(29 - i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(1);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 30);
    if (B.size() == 30) {
      i = 0;
      while (i < 30) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    };
  
  }

  // Test with a small array whose entries are decreasing; intermediate choice
  // of threshold
  
  @Test
  public void TestSmallDecreasing3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 30) {
      A.add(29 - i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(10);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 30);

    if (B.size() == 30) {
      i = 0;
      while (i < 30) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    };
  
  }

  // Test with a small array whose entries are decreasing; larger choice
  // of threshold
  
  @Test
  public void TestSmallDecreasing4() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    int i = 0;
    while (i < 30) {
      A.add(29 - i);
      i = i + 1;
    };
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(40);
    ArrayList<Integer> B = Tester.sort(A);
    
    assertTrue(B.size() == 30);

    if (B.size() == 30) {
      i = 0;
      while (i < 30) {
        assertTrue(B.get(i) == i);
        i = i + 1;
      };
    };
  
  }
  
  // Utility to construct two arrays with a given length. The first array
  // has entries selected from within a specified range, while the second
  // includes the same values, with the same multiplicities, sorted in
  // nondecreasing order. Both arrays are assumed to exist and have size
  // zero when this method is called.
  
  private void buildArrays(int length,
                           int maxValue,
                           ArrayList<Integer> randomA,
                           ArrayList<Integer> sortedA
                          ) {
  
    Random random = new Random(System.nanoTime());
    
    int i = 0;
    while (i < length) {
      int v = random.nextInt(maxValue);
      randomA.add(v);
      insert(sortedA, v);
      i = i + 1;
    };
    
  
  }
  
  // Test with a small array whose entries are randomly selected; default
  // choice of threshold
  
  @Test
  public void TestSmallRandom1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(25, 20, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> C = Tester.sort(A);
    
    assertTrue(C.size() == 25);
    
    if (C.size() == 25) {
      int i = 0;
      while (i < 25) {
        assertTrue(B.get(i) == C.get(i));
        i = i + 1;
      };
    }
  
  }
  
  // Test with a large array whose entries are randomly selected; from
  // a small set; default choice of threshold
  
  @Test
  public void TestLargeRandomSmallSet1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> C = Tester.sort(A);
    
    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) == C.get(i));
        i = i + 1;
      };
    }
  
  }

  // Test with a large array whose entries are randomly selected; from
  // a small set; small choice of threshold
  
  @Test
  public void TestLargeRandomSmallSet2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(1);
    ArrayList<Integer> C = Tester.sort(A);
    
    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) == C.get(i));
        i = i + 1;
      };
    }
  
  }

  // Test with a large array whose entries are randomly selected; from
  // a small set; moderate choice of threshold
  
  @Test
  public void TestLargeRandomSmallSet3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(100);
    ArrayList<Integer> C = Tester.sort(A);
    
    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) == C.get(i));
        i = i + 1;
      };
    }
  
  }

  // Test with a large array whose entries are randomly selected; from
  // a small set; large choice of threshold
  
  @Test
  public void TestLargeRandomSmallSet4() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(2000);
    ArrayList<Integer> C = Tester.sort(A);
    
    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) == C.get(i));
        i = i + 1;
      };
    }
  
  }
  
  // Test with a large array whose entries are randomly selected; from
  // a small set with size equal to the array length; small choice of threshold
  
  @Test
  public void TestLargeRandomModerateSet2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 1000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(1);
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }
  
  }

  // Test with a large array whose entries are randomly selected; from
  // a small set with size equal to the array length; moderate choice of threshold
  
  @Test
  public void TestLargeRandomModerateSet3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 1000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(50);
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }

  }
  
  // Test with a large array whose entries are randomly selected; from
  // a small set with size equal to the array length; large choice of threshold
  
  @Test
  public void TestLargeRandomModerateSet4() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 1000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(10000);
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }
  
  }

  // Test with a large array whose entries are randomly selected; from
  // a small set with size equal to the array length; default choice of threshold
  
  @Test
  public void TestLargeRandomModerateSet1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 1000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }
  
  }
  
  // Test with a large array whose entries are randomly selected; from
  // a set with size considerably larger than the array length; default choice
  // of threshold
  
  @Test
  public void TestLargeRandomLargerSet1() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }

  }
  
  // Test with a large array whose entries are randomly selected; from
  // a set with size considerably larger than the array length; moderate choice
  // of threshold
  
  @Test
  public void TestLargeRandomLargerSet2() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(200);
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }

  }
  
  // Test with a large array whose entries are randomly selected; from
  // a set with size considerably larger than the array length; large choice
  // of threshold
  
  @Test
  public void TestLargeRandomLargerSet3() {
  
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> B = new ArrayList<Integer>();
    
    buildArrays(1000, 10000, A, B);
    
    BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>(2000);
    ArrayList<Integer> C = Tester.sort(A);

    assertTrue(C.size() == 1000);
    
    if (C.size() == 1000) {
      int i = 0;
      while (i < 1000) {
        assertTrue(B.get(i) >= C.get(i));
        assertTrue(B.get(i) <= C.get(i));
        i = i + 1;
      };
    }

  }
  
}