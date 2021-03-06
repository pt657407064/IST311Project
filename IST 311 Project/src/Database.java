
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob P. Fodor
 */
public class Database implements Serializable {
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private ArrayList<Credential> credentials;
    private int credID;
    
    
    public Database(String fn, String ln, String un, String pw, String q, String a) {
        
        this.firstName = fn;
        this.lastName = ln;
        this.userName = un;
        this.password = pw;
        this.securityQuestion = q;
        this.securityAnswer = a;
        this.credentials = new ArrayList<Credential>();
        this.credID = 0;
    }
    
    //When logging into program, check username and password validity with this
    public boolean verifyLoginCredentials(String us, String pw) {
        return us.equals(userName) && pw.equals(password);
    }
    
    //First step in displaying credentials on Main Menu, use along with getCredential calls in for loop.
    public ArrayList<Credential> getCredentials() {
        return credentials;
    }
    
    //Call this when adding a created credential to the active database in App
    public void addNewCredential(Credential toAdd) {
        credentials.add(toAdd);
    }
    
    //Previous existence check
    public boolean accountExisted(String userName)
    {
        if(new File(userName+".ser").exists())
        {
            return true;
        }
        else 
            return false;
    }
    
    //Send count to Credential constructor to be primary key
    public int getCredID() {
        credID++;
        return credID - 1;
    }



}
