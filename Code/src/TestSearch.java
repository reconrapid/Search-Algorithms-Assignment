import java.io.*;

public class TestSearch
{
   public static void main(String[] args) 
   {
         
       Search A = new Search(100, 151);
       Search B = new Search(1000, 1499);
       
       /** Comparison data **/
       int s = A.compSeq;
       int b = A.compBin;
       int h = A.compHash;
       
       int s1 = A.compSeq;
       int b1 = A.compBin;
       int h1 = A.compHash;
      
       /** Read in test data **/
       A.readFileIn("data1.txt");
       B.readFileIn("data2.txt");
       
       /** Display data array **/
       A.displayData(10, "Data Array 1");
       B.displayData(10, "Data Array 2");
      
       /** Sequential Search**/
       /** Data 1**/
       A.seqSearch(18);
       A.seqSearch(69);
       A.seqSearch(201);
       A.seqSearch(331);
       A.seqSearch(492);
       A.seqSearch(17);
       A.seqSearch(67);
       A.seqSearch(209);
       A.seqSearch(372);
       A.seqSearch(498);
       s += A.compSeq;
       System.out.println("\n" + "Average comparisons for sequential search on data 1 = " + s/10);
       /** Data 2**/
       B.seqSearch(20);
       B.seqSearch(832);
       B.seqSearch(1452);
       B.seqSearch(1937);
       B.seqSearch(2615);
       B.seqSearch(87);
       B.seqSearch(851);
       B.seqSearch(1350);
       B.seqSearch(1990);
       B.seqSearch(2631);
       s1 += B.compSeq;
       System.out.println("Average comparisons for sequential search  on data 2 = " + s1/10);

       /** Binary Search **/
       /** Data 1**/
       A.binsearch(18, 0, 99);
       A.binsearch(69, 0, 99);
       A.binsearch(201, 0, 99);
       A.binsearch(331, 0, 99);
       A.binsearch(492, 0, 99);
       A.binsearch(17, 0, 99);
       A.binsearch(67, 0, 99);
       A.binsearch(209, 0, 99);
       A.binsearch(372, 0, 99);
       A.binsearch(498, 0, 99);
       b += A.compBin;
       System.out.println("Average comparisons for binary search on data 1 = " + b/10);
       /** Data 2**/
       B.binsearch(20, 0, 999);
       B.binsearch(832, 0, 999);
       B.binsearch(1452, 0, 999);
       B.binsearch(1937, 0, 999);
       B.binsearch(2615, 0, 999);
       B.binsearch(87, 0, 999);
       B.binsearch(851, 0, 999);
       B.binsearch(1350, 0, 999);
       B.binsearch(1990, 0, 999);
       B.binsearch(2631, 0, 999);
       b1 += B.compBin;
       System.out.println("Average comparisons for binary search on data 2 = " + b1/10);
       
       /** Hashing **/
       /** Data 1**/
       A.readIntoHash("data1.txt");
       A.hashSearch(18);
       A.hashSearch(69);
       A.hashSearch(201);
       A.hashSearch(331);
       A.hashSearch(492);
       A.hashSearch(17);
       A.hashSearch(67);
       A.hashSearch(209);
       A.hashSearch(372);
       A.hashSearch(498);
       h += A.compHash;
       System.out.println("Average comparisons for hashing search on data 1 = " + h/10);
       /** Data 2**/
       B.readIntoHash("data2.txt");
       B.hashSearch(20);
       B.hashSearch(832);
       B.hashSearch(1452);
       B.hashSearch(1937);
       B.hashSearch(2615);
       B.hashSearch(87);
       B.hashSearch(851);
       B.hashSearch(1350);
       B.hashSearch(1990);
       B.hashSearch(2631);
       h1 += B.compHash;
       System.out.println("Average comparisons for hashing search on data 2 = " + h1/10);
       
       /** Display hash array  **/
       A.displayHash(20);   
       B.displayHash(20);
   }
   
}