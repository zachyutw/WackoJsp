/**
 * The Customer bean to save the customer information
 */
package model;

public class Customer {
    
    String id;
    String fname;
    String lname;
    String email;
    String address;
    String phone;
    
    public void setFname( String value )
    {
        fname = value;
    }
    public void setLname( String value )
    {
        lname = value;
    }
    public void setEmail( String value )
    {
        email = value;
    }
    public void setAddress( String value )
    {
        address = value;
    }
    public void setPhone( String value )
    {
        phone = value;
    }
    public void setId(String value)
    {
        id=value;
    }

    public String getFname() { return fname; }
    public String getLname() { return lname; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getId(){return id;}
    
}
