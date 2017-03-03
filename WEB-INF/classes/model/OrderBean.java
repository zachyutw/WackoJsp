/**
 * OrderBean save the order information and selected Products in the order.
 */
package model;


public class OrderBean{
    public OrderBean(){}

    private String orderId="";
    private String orderDate="";
    private String orderTotal="";
    private String customerId="";
    
    
    public void OrderBean(){
       
        this.orderId="";
        this.orderDate="";
        this.orderTotal="";
        this.customerId="";
        
    }
   
     

    public void setOrderId(String orderId){this.orderId=orderId;}
    public void setOrderDate(String orderDate){this.orderDate=orderDate;}
    public void setOrderTotal(String orderTotal){this.orderTotal=orderTotal;}
    public void setCustomerId(String customerId){this.customerId=customerId;}

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderTotal() {
        return orderTotal;
    }
}