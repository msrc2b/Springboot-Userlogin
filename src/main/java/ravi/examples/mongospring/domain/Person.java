package ravi.examples.mongospring.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Person
{
	
    @Field(value = "username")
    private String username;
    @Field(value = "password")
    private String password;
    

    public Person() {}

   

    public Person(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

 
   

    /**
     * @return Returns the username.
     */
    public String getusername()
    {
        return username;
    }

    /**
     * @param username The username to set.
     */
    public void setusername(String username)
    {
        this.username = username;
    }

    /**
     * @return Returns the password.
     */
    public String getpassword()
    {
        return password;
    }

    /**
     * @param password The password to set.
     */
    public void setpassword(String password)
    {
        this.password = password;
    }

    
   

}
