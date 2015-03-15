/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_summ;

/**
 *
 * @author Lipa
 */


public class Csv_summ {

    
    public  Integer figureOutSumm (String csv){
        
        
        if (csv == null){
            return null;
        }
        
        Integer summ = 0;
        
        String[] values = csv.split(",");
        
        for (int i = 0; i < values.length; i++) {
            
            System.out.println("i = " + i + ", value = " + values[i]);
        }
        
        for (String value : values) {
            
            value = value.trim();
            if (value.equals("") || !(isNumeric(value))){
            
                summ = null;
                break;
            }
            
            summ += Integer.valueOf(value);
        }
          
        System.out.println("returning value = " + summ);
        return summ;
    }
    
    
    public boolean isNumeric(String str){
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
