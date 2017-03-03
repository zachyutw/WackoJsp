<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 10:59 AM
  Display the final OrderInfo: Confirm: Save Order and LineItem Info to DB, Refill: Go back to refill the order form, Cancel: Destory session go back to index
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String[] qty;%>
<%! String[] productIds;%>
<%! int i=0;%>
<%! double orderTotal=0;%>
<jsp:useBean id="order" class="model.OrderBean" scope="session"/>
<jsp:useBean id="lineItem" class="model.LineItem" scope="session"/>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<FORM method="Post" Action="ConfirmOrderInfo.jsp" >
    <table id="orderQty" border="1">
        <% qty= lineItem.getSelectedProductQty();%>
        <% productIds= lineItem.getSelectedProductId();%>        
        <%=db.getOrderInfo(productIds,qty)%>
    </table>
<% 
   if(productIds!=null)
   {
       orderTotal=0;
       for(i=0;i<productIds.length;i++){orderTotal+=Double.parseDouble(db.getData("productCatalog","productId",productIds[i],"price"))* Double.parseDouble(qty[i]);}
   }
   else
   {
       out.println("the array is empty");
   }
%>
<% order.setOrderTotal(""+orderTotal);%>
<p> The Order Total: $ <%=orderTotal%></p>
<p> Time is <%=db.getCurrentDate()%> </p>
</FORM>
<P>
    <a href="ConfirmOrderInfo.jsp"><BUTTON>Confirm</BUTTON></a>
    <a href="RefillOrderInfo.jsp"><button>Refill</BUTTON></a>
    <a href="CancelOrderInfo.jsp"><button>Cancel</BUTTON></a>
</P>
