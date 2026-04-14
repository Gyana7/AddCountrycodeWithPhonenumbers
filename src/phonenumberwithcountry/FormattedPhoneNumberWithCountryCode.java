/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonenumberwithcountry;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Scanner;

/**
 *
 * @author Gyana-VIS
 */
public class FormattedPhoneNumberWithCountryCode {
    
    
    
    
    
      public  static String formattedNumber()throws Exception{
           
        
        Scanner sc = new Scanner(System.in);
        
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        Phonenumber.PhoneNumber number=null;
        boolean validNumber;
        String formatNumber=null;
        String lastformattedNumber="";
        
       while(true){ 
       
        System.out.println("Enter phone number (For Exit Type exit )");
        String inputnumber = sc.next();
        String region = "IN";
       // String us_region = "US";
        // String at_region = "AT";
        
        
        if(inputnumber.equalsIgnoreCase("exit")){
            System.out.println("program exit ");
            break;
        }
       
        String phonenumber = inputnumber.replaceAll("[^0-9+]","");
        
         // validate too long numbers if Number Length > 15
       
        if(phonenumber.length() > 15){
          
            System.out.println("sorry number length is too long .Plz enter Correct digit Number"); 
            continue;
        }
        
        if(phonenumber.isEmpty()){
            System.out.println("Plz Enter's digits Only");
            continue;
        }
        
       

        // seniario for if user give input "+91" with Number

        if(phonenumber.startsWith("+91") && phonenumber.length()==13) {
            number = phoneNumberUtil.parse(phonenumber, region);
            validNumber  = phoneNumberUtil.isValidNumber(number);

            if(validNumber==true){
                formatNumber  = phoneNumberUtil.format(number, PhoneNumberUtil.PhoneNumberFormat.E164);
                System.out.println("FomatedNumber :- "+formatNumber);      
                lastformattedNumber= formatNumber;
                continue;
                        
            }
        }

        // if user put only number "6372919931"

        if(phonenumber.length() == 10 && (phonenumber.startsWith("6")||phonenumber.startsWith("7")||phonenumber.startsWith("8")||phonenumber.startsWith("9"))){

            number = phoneNumberUtil.parse(phonenumber, region);
            validNumber  = phoneNumberUtil.isValidNumber(number);

            if(validNumber==true){
                formatNumber = phoneNumberUtil.format(number, PhoneNumberUtil.PhoneNumberFormat.E164);
                System.out.println("FomatedNumber :- "+formatNumber); 
                lastformattedNumber= formatNumber;
                continue;
            }

        }

        // if user put "916372919931" but not put + symbol

        if(phonenumber.length() == 12 && phonenumber.startsWith("91")){

            number = phoneNumberUtil.parse(phonenumber, region);
            validNumber  = phoneNumberUtil.isValidNumber(number);

            if(validNumber==true){
                formatNumber = phoneNumberUtil.format(number, PhoneNumberUtil.PhoneNumberFormat.E164);
                 System.out.println("FomatedNumber :- "+formatNumber); 
                lastformattedNumber= formatNumber;
                continue;
            }

        }
        
          System.out.println("invalid PhoneNumber Format plz Put a valid PhoneNumber");
            
      } // whileloop close
       
       
             return lastformattedNumber;
    }
    
    
}
