package cpsc331.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
*
* Provides a hybrid algorithm to sort the elements of an array based on
* Merge Sort.
*
*/

public class BetterMergeSort<T extends Comparable<T>> {

// Data Fields

private final int THRESHOLD;

/**
 *
* Constructs a hybrid sorting algorithm, based on Merge Sort, using
* a default value (4) for the threshold.
*
*/

public BetterMergeSort() {

THRESHOLD = 4;

}

/**
 *
* Constructs a hybrid sorting algorithm, based on Merge sort, using
* an input value for the threshold.
*
* @param threshold the value to be used as threshold
* @throws IllegalArgumentException if the input value is less than or
*   equal to zero
*
*/

public BetterMergeSort(int threshold) throws IllegalArgumentException {

if (threshold >= 1) {

    THRESHOLD = threshold;

} else {

    throw new IllegalArgumentException("The input threshold" + " must be positive.");

}

}

/**
 *
* Sorts an input ArrayList; does not copy in place.
*
* @param A the ArrayList to be sorted
* @return an ArrayList with the same type and length of A, whose elements
*   are those of&nbsp;A, reordered in non-decreasing order<br><br>
*
* Precondition:<br>
* <ol style="list-style-type: lower-alpha">
* <li> An ArrayList&nbsp;A, whose entries are non-null value of
*      type&nbsp;T, is given as input.
* </li>
* </ol>
* Postcondition:<br>
* <ol style="list-style-type: lower-alpha">
* <li> A ArrayList with the same type and length of&nbsp;A is returned as
*      output. The entries of the output ArrayList are the entries
*      of&nbsp;A, reordered (with multiplicities preserved) in
*      non-decreasing order.
* </li>
* </ol>
*
*/

public ArrayList<T> sort(ArrayList<T> A) {

if (A.size() <= THRESHOLD)
{
    ArrayList<T> B = copy(A);
    insertionSort(B);
    return B;
} else {
    ArrayList<T> B1 = new ArrayList<T>();
    ArrayList<T> B2 = new ArrayList<T>();
    split(A, B1, B2);
    ArrayList<T> C1 = sort(B1);
    ArrayList<T> C2 = sort(B2);
    return merge(C1, C2);
}

}

//
// Returns a copy of an input ArrayList
//
// Precondition:
// a) An ArrayList A with positive length, whose entries are non-null
//    values with type T, is given as input.
// Postcondition:
// a) An ArrayList with the same type, length and contents of A (so that
//    the entry in position j of this ArrayList is the same as the
//    as the entry in position j of A, for 0 <= j <= A.size()-1) is
//    returned as output.

private ArrayList<T> copy(ArrayList<T> A) {

int i = 0;
int size = A.size();
ArrayList<T> B = new ArrayList<T>();

while (i < size)
{
    B.add(i, A.get(i));
    i = i + 1;
}

return B;


}

//
// Sorts an input ArrayList in place
//
// Precondition:
// a) An ArrayList B with positive size, whose entries are non-null
//    values with type T, is given as input.
// Postcondition:
// b) The entries of B have been reordered, but otherwise unchanged,
//    so that they are listed in nondecreasing order.

private void insertionSort(ArrayList<T> B) {

    int i = 1;
    while (i < B.size())
    {
        int j = i;
        while ((j > 0) && (B.get(j-1).compareTo(B.get(j)) > 0))
        {
            T temp = B.get(j-1);
            B.set(j-1, B.get(j));
            B.set(j, temp);
            j = j-1;
        }
        i += 1;
    }

}

//
// Splits an input ArrayList into a pair with approximately the same size
//
// Precondition:
// a) An ArrayList A with size greater than or equal to two, whose
//    entries are non-null values with type T, is given as a first input.
//    A pair of ArrayLists B1 and B2, the each store values with type T
//    but that both initially have size zero, are given as the second
//    and third inputs.
// b) The input array A has not changed. If it has size "length" then
//    the sizes of B1 and B2 are the ceiling and floor of length/2,
//    respectively. For 0 <= h <= ceil(length/2)-1, the entry in
//    position h of B1 is equal to the entry in position h of A. For
//    ceil(length/2) <= h <= length-1, the entry in position
//    h - ceil(length/2) of B2 is equal to the entry in position h of A.

private void split(ArrayList<T> A, ArrayList<T> B1, ArrayList<T> B2) {

// For you to complete

    int i = 0;
    int index = 0;
    int size1 = (int) Math.ceil((double) A.size()/2);
    int size2 = (int) Math.floor((double) A.size()/2);

    for (i = 0; i < size1; i++)
    {
        B1.add(i, A.get(index));
        index = index + 1;
    }
    i = 0;
    // index = 0;
    for (i = 0; i < size2; i++)
    {
        B2.add(i, A.get(index));
        index = index + 1;
    }


}

// Merges a pair of sorted input ArrayLists.
//
// Precondition:
// a) C1 is an ArrayList with positive size storing non-null elements
//    from an ordered type T that is sorted in non-decreasing order -
//    so that for every integer h such that 0 <= h <= C1.size()-2,
//    C1.get(h) <= C1.get(h+1).
// b) C2 is an ArrayList with positive size storing non-null elements
//    from an ordered type T that is sorted in non-decreasing order - 
//    so that for every integer h such that 0 <= h <= C2.size()-2,
//    C2.get(h) <= C2.get(h+1).
// Postcondition:
// a) An ArrayList D, storing non-null values from the ordered type T,
//    such that D.zize() = C1.size() + C2.size(), is returned as output.
//    The entries stored in D are the entries stored in C1 and in C2
//    (with multiplicities preserved), rearranged in non-decreasing order
//    - so that for every integer h such that 0 <= h <= D.size()-2,
//    D.get(h) <= D.get(h+1)

private ArrayList<T> merge(ArrayList<T> C1, ArrayList<T> C2) {

// For you to complete

int n1 = C1.size();
int n2 = C2.size();

ArrayList<T> D = new ArrayList<T>(n1 + n2);
for(int i = 0; i < (n1 + n2); i++) {
    D.add(null);
}

int i1 = 0;
int i2 = 0;
int j = 0;

while ((i1 < n1) && (i2 < n2))
{
    if (C1.get(i1) != null && C2.get(i2) != null && C1.get(i1).compareTo(C2.get(i2)) <= 0)
    {
        D.set(j, C1.get(i1));
        i1++;
    } else {
        D.set(j, C2.get(i2));
        i2++;
    }
    j++;
}

while (i1 < n1) {
    D.set(j, C1.get(i1));
    i1++;
    j++;
}

while (i2 < n2) {
    D.set(j, C2.get(i2));
    i2++;
    j++;
}


return D;
}

}
