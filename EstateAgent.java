/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progthe_q1;
//https://github.com/fb-shaik/PROG6112-Group3-2023/tree/main/Zoo_Application_Interface - code was adapated from github 
 interface IEstateAgent {
    double estateAgentSales(double[] propertySales);
    double estateAgentCommission(double totalSales);
    int topEstateAgent(double[] totalSales);
}

  class EstateAgent implements IEstateAgent{
    
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }
    
     @Override
    public int topEstateAgent(double[] totalSales) {
        int topAgentIndex = 0;
        double maxSales = totalSales[0];
//https://www.youtube.com/watch?v=aaKBJ7OAieA 
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgentIndex = i;
            }
        }

        return topAgentIndex;
    }
    
     @Override
    public double estateAgentCommission(double totalSales) {
        
        return totalSales * 2/100;
    }
    
    public double[] CalculateTotalSales_ReturnsTotalSales(double[][] PropertySales_Arr ){
        
        double [] totalSales = new double[PropertySales_Arr.length];
        
        for (int i = 0; i < PropertySales_Arr.length; i++) {
            totalSales[i] = estateAgentSales(PropertySales_Arr[i]);
        }
        return totalSales;
    }
    
}
