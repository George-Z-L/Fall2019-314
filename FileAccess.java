// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class FileAccess {
  
  public static boolean loadPrimes(Primes primes, String filename) {
	  try {
          FileReader reader = new FileReader(filename);
          BufferedReader bufferedReader = new BufferedReader(reader);

          String line;
          primes.clearPrimes();

          while ((line = bufferedReader.readLine()) != null) {
        	  if(line.length()>0)
              primes.addPrime(new BigInteger(line));
          }
          reader.close();
          return true;

      } catch (IOException e) {
          return false;
      }

  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
	  try {
          FileReader reader = new FileReader(filename);
          BufferedReader bufferedReader = new BufferedReader(reader);

          String line;
          primes.clearCrosses();

          while ((line = bufferedReader.readLine()) != null) {
        	  if(line.length()>0)
        	  {
        		  BigInteger b1,b2;
        
        		  b1=new BigInteger(line.substring(0,line.indexOf(",")));
        		  b2=new BigInteger(line.substring(line.indexOf(",")+1));        		  
        		  
              primes.addCross(new Pair<BigInteger>(b1,b2));
        	  }
          }
          reader.close();
          return true;

      } catch (IOException e) {
          return false;
      }
	}
  
  public static boolean savePrimes(Primes primes, String filename)
  {
	  try {
		  Files.deleteIfExists(Paths.get(filename));
          FileWriter writer = new FileWriter(filename, true);
          BufferedWriter bufferedWriter = new BufferedWriter(writer);

          for(BigInteger bi:primes.iteratePrimes())
          {
        	  bufferedWriter.write(bi.toString());
              bufferedWriter.newLine();      	  
        	  
          }         

          bufferedWriter.close();
          return true;
      } catch (IOException e) {
          return false;
      }


  }
  
  public static boolean saveCrosses(Primes primes, String filename)
  {
	  try {
		  Files.deleteIfExists(Paths.get(filename));
          FileWriter writer = new FileWriter(filename, true);
          BufferedWriter bufferedWriter = new BufferedWriter(writer);

          for(BigInteger bi:primes.iterateCrosses())
          {
        	  bufferedWriter.write(bi.toString() +","+bi.multiply(BigInteger.valueOf(2)).toString());
              bufferedWriter.newLine();      	  
        	  
          }         

          bufferedWriter.close();
          return true;
      } catch (IOException e) {
          return false;
      }
  }
}
