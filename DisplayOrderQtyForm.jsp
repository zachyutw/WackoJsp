<%--
  Created by IntelliJ IDEA.
  User: po-yingyu
  Date: 2017-02-01
  Time: 10:59 AM
  Display the form which allow user to choice the quantity on ordered products.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String[] productIds;%>
<%! int i=0;%>
<jsp:useBean id="lineItem" class="model.LineItem" scope="session"/>
<%@ page import="database.Database"%>
<%! Database db = new Database();%>

<FORM method="Post" Action="SaveSelectedProductQtyController.jsp" >
   
   <table id="orderQty" border="1">
        <% productIds= lineItem.getSelectedProductId();%>
        <%=db.getProductInfo(productIds)%>
    </table>
    <P><a href="SaveSelectedProductQtyController.jsp"><INPUT TYPE="SUBMIT" value="Order"></a></P>
</form>
<!--
<% productIds= lineItem.getSelectedProductId(); 
   if(productIds!=null)
   {
   for(i=0;i<productIds.length;i++)
   {
       out.println(productIds[i]);
   }
   }
   else
   {
       out.println("the array is empty");
   }
%>
-->
