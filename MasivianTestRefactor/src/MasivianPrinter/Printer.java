package MasivianPrinter;

import static java.lang.System.out;
import java.util.Arrays;

public class Printer {

    
    public static void main(String[] args) {
        
            printerPrimes();
    } 
    
    static void printerPrimes(){
               
        final int PrimesQuantity = 1000;
        final int RowSize = 50;
        final int ColSize = 4;
        final int PageItemPerPage = RowSize * ColSize;                
        final int totalPages = PrimesQuantity / PageItemPerPage;
        int Offset = 0;
        int PageNumber = 1;                           
        int[] Primes = getPrimes(PrimesQuantity);
        
        while (PageNumber <= totalPages) {                        
            
            var page = Arrays.copyOfRange(Primes, Offset, Offset + PageItemPerPage);                                    
            printPage(page, PageNumber, 4, 50);            
            
            Offset += PageItemPerPage;
            PageNumber++;
        }
    }
    static void printRow(int[] primes) {
        
        for (int i = 0; i < primes.length; i++) {
            out.printf("%10d", primes[i]);
        }        
        out.println();
    }
   
    static void printPage(int[] primes, int pageNumer, int cols, int rows) {       

        System.out.println("The First 1000 Prime Numbers === Page " + pageNumer + "\n");               
        
        for (int i = 0; i < rows; i++) {       
            var offset = i * cols;                                                            
            printRow(Arrays.copyOfRange(
                            primes, 
                            offset, 
                            offset + cols
                    ));
        }
        
        System.out.println("\f");
    }
    
    static int[] getPrimes(int size) {
        
        final int ORDMAX = 30;
        int primes[] = new int[size + 1];        
        int Candidate = 1;
        int Kth = 1;        
        int ORD = 2;
        int Square = 9;
        int N;        
        boolean IsPrime;      
        int MULT[] = new int[ORDMAX + 1];
        primes[0] = 2;
        
        while (Kth < size) {
            
            do {               
                N = 2;
                Candidate += 2;                
                IsPrime = true;              
                if (Candidate == Square) {
                    
                    ORD++;
                    Square = primes[ORD] * primes[ORD];
                    MULT[ORD - 1] = Candidate;                    
                }                                                              
                while (N < ORD && IsPrime) {
                                        
                    MULT[N] += primes[N] + primes[N];
                    IsPrime = MULT[N] != Candidate;
                    N++;
                }
                
            } while (!IsPrime);
                        
            primes[Kth++] = Candidate;
        }
        
        return primes;
    }        
    
    
    
}
