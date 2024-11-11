/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progthe_q1;


public class ProgTHE_Q1 {

    
    public static void main(String[] args) {
        
        String[] EstateAgents_Arr = {"Joe Bloggs", "Jane Doe"}; // array that stores agents name 
        String[] Months_Arr = {"JAN", "FEB", "MAR"};// array that stores months 

        
        double[][] PropertySales_Arr = { //2d array that stores the amounts each agent made 
                {800000, 1500000, 2000000},//https://www.w3schools.com/java/java_arrays_multi.asp website that could was adapted from 
                {700000, 1200000, 1600000}};
        
        EstateAgent estateagent = new EstateAgent();
       
        System.out.println("ESTATE AGENT SALE REPORT");
        System.out.println("                          Jan" + 
                           "                          Feb" +
                           "                          Mar");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        // loop will iterrate through the array to print out the agents names and the amount they made 
         for (int i = 0; i < EstateAgents_Arr.length; i++) {
            System.out.print(EstateAgents_Arr[i] + "              ");
            for (int j = 0; j < PropertySales_Arr[i].length; j++) {
                System.out.print(PropertySales_Arr[i][j] + "                     ");
            }//https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html#axzz8JoRe4Ool code was adapted from this website 
            System.out.println(); // skips a lines
        }
         
         System.out.println("");//skips a line
         for (int i = 0; i < PropertySales_Arr.length; i++) { //iterrates through the loops to find how much money was made in total by agents
            double totalSales = estateagent.estateAgentSales(PropertySales_Arr[i]);
            System.out.println("Total property sales for " + (EstateAgents_Arr[i]) + ": " +"R "+ totalSales );
        }
         
         System.out.println("");// loops through array to find out who made the most money between agents 
           for (int i = 0; i <  PropertySales_Arr.length; i++) {
            double totalSales = estateagent.estateAgentSales( PropertySales_Arr[i]);
            double commission = estateagent.estateAgentCommission(totalSales);
            System.out.println("Sales commission for " + (EstateAgents_Arr[i]) + ": " +"R " + commission);
        }
           //https://www.w3schools.com/java/java_arrays_loop.asp looping through arrays. code was adapted from website. 
          System.out.println(" ");
        // shows the agent who made the most money 
        int topPerformingEstateAgent = estateagent.topEstateAgent(estateagent.CalculateTotalSales_ReturnsTotalSales(PropertySales_Arr));
        System.out.println("Top-performing estate agent: " + (EstateAgents_Arr[topPerformingEstateAgent]));
         
    }
    
}
