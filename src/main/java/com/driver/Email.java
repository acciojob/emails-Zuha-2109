package com.driver;

import java.util.regex.*;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {

        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(this.password.equals(oldPassword))
        {
            if(newPassword.length()>=8 && UpperCase(newPassword) && LowerCase(newPassword) && OneNumber(newPassword) && SpecialCharacter(newPassword))
            {
                this.password=newPassword;
            }
        }
    }
    public boolean UpperCase(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='A' && str.charAt(i)<='Z')
            {
                return true;
            }
        }
        return false;
    }
    public boolean LowerCase(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='a' && str.charAt(i)<='z')
            {
                return true;
            }
        }
        return false;
    }
    public boolean OneNumber(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
            {
                return true;
            }
        }
        return false;
    }

    public boolean SpecialCharacter(String str)
    {
        boolean flag=false;
        for (int i = 0; i < str.length(); i++) {

            // Checking the character for not being a
            // letter,digit or space
            if (!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i)))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
}
