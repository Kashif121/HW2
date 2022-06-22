/*
 * This program intents to calculate various calculations for an accounting 
*department verifying if bookeeping is correct. We are bookeeping so we must import
*the Scanner class and File, because we will need to declare a new scanner, being the 
*input txt file containing different items. We are going to be printing the results 
*to an output file so we will need the PrintStream class. Next we are going to declare variables 
*needed to calculated the total sum of the items after discount and tax. 
*In addition, we are going to find which items in the input file have the maximum
*and minimum values of price. After ths, we are going to utilize a while loop bc 
*we need to read in the information from the input. Discountpi represents discount 
*per item and discount represents total discount from the input. The total variable
*represents the difference between price and discount, while totalsum shows 
*the added up cost of all the items after discount. The tax shows the 8.875% tax
*being applied to the full cost of all the items after the discount. Then to 
*represent the maximum and the minimum values we need to use a counter, which 
*is simply like a finger in this case. It was inialized to 0, but I use an if
*statement representing that, if the counter equals 1, we will use objects of 
*the math class that can find maximum and minimum values within the scope of 
*min and max respectively and the total, which is the difference between price
*and discount. Then outside of the while loop, we print out to the output txt 
*file all our results and numbers from the program being, price after discount,
*tax price, and the minimum and maximum value item in the file. When the code is 
*compiled and run, it works with no errors.
*  Occasionally, there were parts of the program I found hard, such as 
* finding the maximum and minimum values in the input file. Also,
*uploading the files using gitbash instead of directly gave me a hard time and I 
*had to upload them directly.
 */
package hw2;

/**
 *
 * @author kashif
 **/


import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) throws Exception {

        File file= new File("C:\\Users\\kashi\\Desktop\\input.txt");
        Scanner sc= new Scanner(file);
        PrintStream ps = new PrintStream("output.txt");
		
		double total;
		double tax;
		double discount;
		String date;
		double sku;
		double price;
                double discountpi;
		double totalsum;
                double max;
                double min;
                int i;
                i=0;
                totalsum=0;
                tax=0;
                max=0;
                min=0;
               
		
		ps.println("Report from 02-10 to 02-14");
		
        while (sc.hasNext()) {
            date = sc.next();
            sku= sc.nextDouble();
            price= sc.nextDouble();
            discountpi= sc.nextDouble();
            discountpi=discountpi/100;
            discount= (discountpi*price);
            total= (price-discount);
            totalsum=totalsum+total;
            tax=totalsum*.08875;
            
            i++;
            if(i==1) {
               max=(int)(total);
               min=(int)(total);
            }
            max= Math.max(max,(int)(total));
            min= Math.min(min, (int)(total));
			
		    
			
		}
        ps.println("The total is $"+totalsum);
        ps.printf("The tax is $%.2f%n",tax);
        ps.println("The highest price item is #316 at $"+max);
        ps.println("The highest price item is #130 at $"+min);
    }
}