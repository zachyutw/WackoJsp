<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 3:23 PM
  Confirm the Order Info and LineItem Info, save Order Info to Order Database, save LineItem Info to Database
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="order" class="model.OrderBean" scope="session"/>
<jsp:useBean id="customer" class="model.Customer" scope="session"/>
<jsp:useBean id="lineItem" class="model.LineItem" scope="session" />
<%@ page import="database.Database"%>
<%! Database db = new Database();%>
<%! String[] qty;%>
<%! String[] productIds;%>
<%!int i;%>
<%! String orderId;%>
<%=db.getToday()%>
<% qty= lineItem.getSelectedProductQty();%>
<% productIds= lineItem.getSelectedProductId();%> 
<%=db.saveOrder(order.getOrderTotal(),customer.getId())%>
<%=db.getLastDataId("OrderInfo")%>
<%orderId=db.getLastDataId("OrderInfo");%>
<% 
    if(productIds!=null)
   {
       for(i=0;i<productIds.length;i++){db.saveLineItem(qty[i],productIds[i],orderId);}
   }
   else
   {
       out.println("the array is empty");
   }
%>
<% session.invalidate();%>
<jsp:forward page="index.jsp"/>
 