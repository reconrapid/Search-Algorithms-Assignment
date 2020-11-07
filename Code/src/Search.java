import java.io.*;
import java.text.*;
import java.util.*;

public class Search {

	/** Global variables for counting comparisons **/
	public int compSeq = 0;
	public int compBin = 0;
	public int compHash = 0;

	/** Array of values to be searched and size **/
	private int[] A;
	private int size;

	/** Hash array and size **/
	private int[] H;
	private int hSize;

	/** Constructor **/
	Search(int n, int hn) {
		/** set size of array **/
		size = n;
		hSize = hn;

		/** Create arrays **/
		A = new int[size];
		H = new int[hSize];

		/** Initialize hash array **/
		/** Assume -1 indicates a location is empty **/
		for (int i = 0; i < hSize; i++) {
			H[i] = -1;
		}
	}

	/********************************************/
	/*** Read a file of numbers into an array ***/
	/********************************************/
	public void readFileIn(String file) {
		try {
			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data **/
			for (int i = 0; i < size; i++) {
				/** Get next value **/
				A[i] = in.nextInt();
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/*********************/
	/*** Hash Function ***/
	/*********************/
	public int hash(int key) {
		return key % hSize;
	}

	/*****************************/
	/*** Display array of data ***/
	/*****************************/
	public void displayData(int line, String header) {
		/* ** Integer Formatter ** */
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\n" + header);

		/** Display array data **/
		for (int i = 0; i < size; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	/**************************/
	/*** Display hash array ***/
	/**************************/
	public void displayHash(int line) {
		/** Integer Formatter **/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\nHash Array of size " + hSize);

		/** Display array data **/
		for (int i = 0; i < hSize; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(H[i]) + " ");
		}
	}

	/**************************/
	/*** Sequential Search ***/
	/**************************/
	public int seqSearch(int key) {
		// Int to keep track of position, start at beginning of array at 0
		// element.
		int pos = 0;
		// While loop that increments through the array.
		while (pos < A.length) {
			// Comparison to check if pos is less than the length of the array
			// A.
			compSeq++;
			// Comparison to check if key is equal to the current element within
			// A.
			compSeq++;
			// If we found the key then return the position we found it at.
			if (key == A[pos]) {
				return pos;
			}
			// Comparison to check if the current element within A is larger
			// than the key.
			compSeq++;
			// If the current element is larger than the key then we know that
			// the key is not in the sorted array & we can return -1.
			if (A[pos] > key) {
				return -1;
			}
			// If we didn't find the key & the current element is not larger
			// than the key then increment pos & go through the while loop once
			// more.
			else {
				pos = pos + 1;
			}
		}
		// Comparison in case pos exceeds length of A.length.
		compSeq++;
		// assuming the key is larger then every element in the array then
		// eventually the while loop will break & we will know the key is not in
		// the sorted array so we return -1.
		return -1;

	}

	/**************************/
	/*** Binary Search ***/
	/**************************/
	public int binsearch(int key, int L, int R) {
		// If the right pointer crosses the left then we know the key is not in
		// the array & return -1.
		if (R < L) {
			return -1;
		}
		// finding the middle element.
		int middle = (R+L) / 2;
		// Comparison to check if the middle element of A is the key.
		compBin++;
		// If we find the key then return middle.
		if (key == A[middle]) {
			return middle;
		}
		// Comparison to check if the key we are looking for is greater than the
		// middle element.
		compBin++;
		// If the key is greater than the middle element then we know it must be
		// at the right side of the sorted array.
		if (key > A[middle]) {
			return binsearch(key, middle + 1, R);
		}
		// Else the key must be less than the middle element so we search the
		// left side of the array.
		else {
			return binsearch(key, L, middle - 1);
		}
	}

	/**************************/
	/*** Hashing with Linear Probing ***/
	/**************************/
	private void addToHash(int value) {
		// hash the value we want to insert & store that value in key.
		int key = hash(value);
		// While loop that starts at position using hash function & searches
		// from here upwards for empty location.
		while (H[key] != -1) {
			key++;
			key %= H.length;
		}
		// Insert value at empty location.
		H[key] = value;
	}

	public void readIntoHash(String file) {
		try {
			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data **/
			for (int i = 0; i < hSize; i++) {
				if (in.hasNextInt()) {
					this.addToHash(in.nextInt());
				}
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	public int hashSearch(int key) {
		int hash = hash(key);
		// While loop that starts at position using hash function & searches
		// through so long as the current element isn't empty.
		while (H[hash] != -1) {
			// Comparison to check whether current element of H is not empty.
			compHash++;
			// Comparison to check whether current element of H is equal to the
			// key we are looking for.
			compHash++;
			// If the current element is equal to the key we are looking for
			// then return the current element.
			if (H[hash] == key) {
				return H[hash];
			}
			// Increment hash to check next cell.
			hash++;
			// used to ensure we go through the entire array.
			hash %= H.length;
		}
		// Comparison in case current element of H is empty.
		compHash++;
		// Assuming we found an empty cell then we know the item we are looking
		// for is not in the array & return -1
		return -1;
	}

} /*** End of class Search ***/