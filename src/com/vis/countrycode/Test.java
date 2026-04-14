/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vis.countrycode;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Set;

/**
 *
 * @author Gyana-VIS
 */
public class Test {
    
    public static void main(String[] args) {
        String format=null;
        try{
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
//            Set<Integer> supportedCallingCodes = phoneNumberUtil.getSupportedCallingCodes();
//            for(Integer code :supportedCallingCodes){
//                System.out.println(code);
//            }
            
            Set<String> supportedRegions = phoneNumberUtil.getSupportedRegions();
            
            for(String region:supportedRegions){
                System.out.println(region);
            }


            for(String region:supportedRegions){
            int countryCodeForRegion = phoneNumberUtil.getCountryCodeForRegion(region);
                
            if(countryCodeForRegion==91){
               System.out.println(region + "->"+ countryCodeForRegion);
               break;
                        
            }
               // System.out.println(region + "->"+ countryCodeForRegion);
            }
            
            
            
            
            
            
            
            
            
//        
//          Phonenumber.PhoneNumber phoenumber = phoneNumberUtil.parse("6746663928", null);
//          
//            boolean validNumber = phoneNumberUtil.isValidNumber(phoenumber);
//            
//            if(validNumber){
//             format = phoneNumberUtil.format(phoenumber, PhoneNumberUtil.PhoneNumberFormat.E164);
//            }
//            System.out.println("formateed Number:"+ format);
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
