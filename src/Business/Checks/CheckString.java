/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Checks;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gauri
 */
public class CheckString {

    public static boolean stringValidation(String validate){
             String regularExpression="[a-zA-Z]*";
             if(validate.isEmpty()){
                 JOptionPane.showMessageDialog(null, "Field cannot be Empty !", "Warning", JOptionPane.WARNING_MESSAGE);
                 return false;
             }
             else{
                 if(validate.matches(regularExpression)){
                    return true;
             }
                else{
                     JOptionPane.showMessageDialog(null, "Field should only contain only Alphabetical Values !", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                    }
                 }
           }
    
    public static boolean stringNumericValidation(String validate){
             String regularExpression="[a-zA-Z0-9]*";
             if(validate.isEmpty()){
                 JOptionPane.showMessageDialog(null, "Field cannot be Empty !", "Warning", JOptionPane.WARNING_MESSAGE);
                 return false;
             }
             else{
                 if(validate.matches(regularExpression)){
                    return true;
             }
                else{
                     JOptionPane.showMessageDialog(null, "Field should contain only Alphabetical or Numeric Values !", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                    }
                 }
           }
    
    public static boolean DoubleValidation(Double validate){
         String regularExpression="[0-9]*(.[0-9]*)?";
         if(String.valueOf(validate).isEmpty()){
             JOptionPane.showMessageDialog(null, "Field cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
             return false;
         }
         else{
             if(String.valueOf(validate).matches(regularExpression)){
                return true;
         }
            else{
                 JOptionPane.showMessageDialog(null, "Field should only contain only numeric Values", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
         }
       }
    public static boolean IntValidation(int validate){
         String regularExpression="[0-9]*";
         if(String.valueOf(validate).isEmpty()){
             JOptionPane.showMessageDialog(null, "Field cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
             return false;
         }
         else{
             if(String.valueOf(validate).matches(regularExpression)){
                return true;
         }
            else{
                 JOptionPane.showMessageDialog(null, "Field should only contain only numeric Values", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
         }
       }

}
