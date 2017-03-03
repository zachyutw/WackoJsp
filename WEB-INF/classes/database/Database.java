package database;

import java.sql.*;
import java.util.ArrayList;
import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Database {
    private Statement stmt = null;
    private Connection dbconn = null;
    private String result = "OK";
    private String query = "";
    private String DB_PATH="";
    //private String dburl    = "jdbc:odbc:WACKO";
    //private String dburl    = "jdbc:odbc:Driver={Mircosoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\+DB_PATH+\\Wacko.accdb;DriverID=01";
    //private String dbdriver = "sun.jdbc.odbc.JdbcOdbcDriver" ;
    /**
     * Use Mysql Database 
     */
    private String user = "root";
    private String pass = "ubizach";
    private String server = "127.0.0.1";
    private String port = "3306";
    private String db = "Wacko";
    private String dbdriver = "com.mysql.jdbc.Driver";
    private String dburl = "jdbc:mysql://" + server + ":" + port + "/" + db + "?user=" + user + "&password=" + pass;
    //private String dburl="jdbc:mysql://127.0.0.1:3306/Wacko?user=root&password=ubizach";
    private final int NORMAL = 0;
    private final int Edit = 1;
    private int connectMode = NORMAL;

    public Database() {
    }

//more methods  ...
    // You will need to add some parameters
    /**
     * Save Customer Info to Database
     *
     * @param lName
     * @param fName
     * @param address
     * @param email
     * @param phone
     * @return result
     */
    public String saveCustomer(String lName, String fName, String address, String email, String phone) {
        connectMode = Edit;
        String[] columName = {lName, fName, address, email, phone};
        result = connect();
        query = "select * from Customer where 1=2";
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            int colsIndex = 2;
            results.moveToInsertRow();
            for (int i = 0; i < columName.length; i++) {
                results.updateString(colsIndex, columName[i]);
                colsIndex++;
            }
            results.insertRow();
        } catch (SQLException e) {
            result = " Save Customer:  Error processing the SQL!";
            result += " <br/>" + e.toString();
            System.out.println(result);
        } finally {
            close();
        }
        return result;
    }

    /**
     * Save LineItemInfo to Database
     *
     * @param qty
     * @param productId
     * @param orderId
     * @return
     */
    public String saveLineItem(String qty, String productId, String orderId) {
        connectMode = Edit;
        String[] columName = {qty, productId, orderId};
        result = connect();
        query = "select * from LineItem where 1=2";
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            int colsIndex = 2;
            results.moveToInsertRow();
            for (int i = 0; i < columName.length; i++) {
                results.updateInt(colsIndex, Integer.parseInt(columName[i]));
                colsIndex++;
            }
            results.insertRow();
        } catch (SQLException e) {
            result = " Save Customer:  Error processing the SQL!";
            result += " <br/>" + e.toString();
            System.out.println(result);
        } finally {
            close();
        }
        return result;
    }

    /**
     * Save Order Info to Database
     *
     * @param orderTatol
     * @param customerId
     * @return
     */
    public String saveOrder(String orderTatol, String customerId) {
        connectMode = Edit;
        String[] columName = {orderTatol, customerId};
        java.util.Date timeRecord = new Date();
        String orderTime=timeRecord.toString();
        
        result = connect();
        query = "select * from OrderInfo where 1=2";
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            //colsIndex is the table pk id
            int colsIndex = 2;
            results.moveToInsertRow();
            results.updateString(colsIndex, orderTime);
            colsIndex++;
            for (int i = 0; i < columName.length; i++) {
                results.updateString(colsIndex, columName[i]);
                colsIndex++;
            }
            results.insertRow();
        } catch (SQLException e) {
            result = " Save Customer:  Error processing the SQL!";
            result += " <br/>" + e.toString();
            System.out.println(result);
        } finally {
            close();
        }
        return result;
    }

    /**
     * Delete Last Row Data from Table
     *
     * @param tableName
     * @return
     */
    public String deleteLastRowData(String tableName) {
        connectMode = Edit;
        result = connect();
        query = "select * from " + tableName;
        try {
            ResultSet results = stmt.executeQuery(query);
            // ResultSetMetaData metadata = results.getMetaData();
            if (results != null) {
                results.afterLast();
                results.previous();
                results.deleteRow();
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get Last Row Data Id
     * @param tableName
     * @return 
     */
    public String getLastDataId(String tableName) {
        connectMode = NORMAL;
        result = connect();
        query = "select * from " + tableName;
        try {
            ResultSet results = stmt.executeQuery(query);
            if (results != null) {
                results.afterLast();
                results.previous();
                result = results.getString(1);
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get Last Row Data
     * @param columnName which column you want to select and sort it by order
     * @param tableName 
     * @param getColumnName which data you want to get
     * @return 
     */
    public String getLastData(String columnName, String tableName, String getColumnName) {
        connectMode = NORMAL;
        result = connect();
        query = "select " + columnName + " from " + tableName + " order by " + columnName;
        try {
            ResultSet results = stmt.executeQuery(query);
            if (results != null) {
                results.afterLast();
                results.previous();
                result = results.getString(getColumnName);
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get one specific data from table 
     * @param tableName
     * @param columnName
     * @param getName
     * @param getColumnName
     * @return 
     */
    public String getData(String tableName, String columnName, String getName, String getColumnName) {
        connectMode = NORMAL;
        result = connect();
        query = "select * from " + tableName + " where " + columnName + "=" + getName;
        try {
            ResultSet results = stmt.executeQuery(query);
            if (results != null) {
                results.afterLast();
                while (results.previous()) {
                    result = results.getString(getColumnName);
                }
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get Whole Column Data 
     * @param columnName
     * @param tableName
     * @return 
     */
    public ArrayList<String> getData(String columnName, String tableName) {
        ArrayList<String> resultArrayList = new ArrayList<String>();
        connectMode = NORMAL;
        result = connect();
        query = "select " + columnName + " from " + tableName;
        try {
            ResultSet results = stmt.executeQuery(query);
            if (results != null) {
                while (results.next()) {
                    results.getRow();
                    resultArrayList.add(results.getString(columnName));
                }
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return resultArrayList;
    }
    /**
     * Get Specific row data in ProductInfo and create the form
     * @param orderProductId
     * @return 
     */
    public String getProductInfo(String[] orderProductId) {
        connectMode = NORMAL;
        result = connect();
        query = "select * from ProductCatalog";
        int productId=0;
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            if (results != null) {
                /* Use ResultSetMetaData object to determine the columns */
                int cols = metadata.getColumnCount();
                result = "<tr>";
                for (int i = 1; i <= cols; i++) {
                    if (i % cols != 1) {
                        result += "<td>" + metadata.getColumnLabel(i).toUpperCase() + "</td>";
                    }
                    if (i % cols == 0) {
                        result += "<td>Quantity</td>";
                    }
                }
                result += "</tr>";
                /* Loop through the columns and append data to table */
                while (results.next()) {
                    results.getRow();
                    result += "<tr>";
                    for (String s : orderProductId) {
                        if (s.equals(results.getString(1))) {
                            for (int i = 1; i <= cols; i++) {
                                if (i % cols != 1) {
                                    result += "<td>" + results.getString(i) + "</td>";
                                } else {
                                    productId = results.getInt(1);
                                }
                                if (i % cols == 0) {
                                    result += "<td><input id=\"selectedQty\" type=\"number\" name=\"selectedProductQty\" width=\"5\" min=\"1\" max=\"99\" value=\"1\"></td>";
                                }
                            }
                        }
                    }
                }
                result += "</tr>";
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get OrderInfo and create Form
     * @param orderProductId
     * @param orderProductQty
     * @return 
     */
    public String getOrderInfo(String[] orderProductId, String[] orderProductQty) {
        connectMode = NORMAL;
        result = connect();
        query = "select * from ProductCatalog";
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            if (results != null) {
                /* Use ResultSetMetaData object to determine the columns */
                int cols = metadata.getColumnCount();
                int productId = 0;
                result = "<tr>";
                for (int i = 1; i <= cols; i++) {
                    if (i % cols != 1) {
                        result += "<td>" + metadata.getColumnLabel(i).toUpperCase() + "</td>";
                    }
                    if (i % cols == 0) {
                        result += "<td>Quantity</td>";
                    }
                }
                result += "</tr>";
                /* Loop through the columns and append data to our table */
                int product_index = 0;
                while (results.next()) {
                    results.getRow();
                    result += "<tr>";
                    for (String s : orderProductId) {
                        if (s.equals(results.getString(1))) {
                            for (int i = 1; i <= cols; i++) {

                                if (i % cols != 1) {
                                    result += "<td>" + results.getString(i) + "</td>";
                                } else {
                                    productId = results.getInt(1);
                                }
                                if (i % cols == 0) {
                                    result += "<td>" + orderProductQty[product_index] + "</td>";
                                    product_index++;
                                }
                            }
                        }
                    }
                }
                result += "</tr>";
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get Product Info and create Form
     * @return 
     */
    public String getProductInfo() {
        connectMode = NORMAL;
        result = connect();
        query = "select * from ProductCatalog";
        try {
            stmt.execute(query);
            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            if (results != null) {
                /* Use ResultSetMetaData object to determine the columns */
                int cols = metadata.getColumnCount();
                int productId = 0;
                result = "<tr>";
                for (int i = 1; i <= cols; i++) {
                    if (i % cols != 1) {
                        result += "<td>" + metadata.getColumnLabel(i).toUpperCase() + "</td>";
                    }
                    if (i % cols == 0) {
                        result += "<td>Selected</td>";
                    }
                }
                result += "</tr>";
                /* Loop through the columns and append data to our table */
                while (results.next()) {
                    results.getRow();
                    result += "<tr>";
                    for (int i = 1; i <= cols; i++) {
                        if (i % cols != 1) {
                            result += "<td>" + results.getString(i) + "</td>";
                        } else {
                            productId = results.getInt(1);
                        }
                        if (i % cols == 0) {
                            result += "<td><input id=\"selectedItem\" type=\"checkbox\" name=\"selectedProductId\" value=\"" + productId + "\"></td>";
                        }
                    }
                    result += "</tr>";
                }
            }
        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;
    }
    /**
     * Get ProductInventary Data And Create Table
     * @return 
     */
    public String getProductInventary() {
        connectMode = NORMAL;
        result = connect();

        query = "select * from ProductCatalog";
        try {
            stmt.execute(query);

            ResultSet results = stmt.getResultSet();
            ResultSetMetaData metadata = results.getMetaData();
            if (results != null) {
                /* Use ResultSetMetaData object to determine the columns */
                int cols = metadata.getColumnCount();

                result = "<tr>";

                for (int i = 1; i <= cols; i++) {
                    if (i % cols != 1) {
                        result += "<td>" + metadata.getColumnLabel(i).toUpperCase() + "</td>";
                    }

                }
                result += "</tr>";
                /* Loop through the columns and append data to our table */

                while (results.next()) {
                    results.getRow();
                    result += "<tr>";
                    for (int i = 1; i <= cols; i++) {
                        if (i % cols != 1) {
                            result += "<td>" + results.getString(i) + "</td>";
                        }

                    }
                    result += "</tr>";
                }
            }

        } catch (SQLException e) {
            result = " DisplayProdcutInfo:  Error processing the SQL!";
            result += " <br/>" + e.toString();
        } finally {
            close();
        }
        return result;

    }
    /**
     * Get Current Date Type java.util.data for testing
     * @return 
     */
    public String getCurrentDate() {
        java.util.Date today = new Date();
        result=today.toString();
        return result;
    }
    public String getNow(){
        
        return result;
    }
    /**
     * Get Current Date Type java.sql.data for testing
     * @return 
     */
    public java.util.Date getToday() {
        java.util.Date today = new Date();
        java.sql.Date date = new java.sql.Date(today.getTime());
        return date;
    }
    //More methods  ...
    
    /*--------------------------------Private ---------------------------------------*/
    /**
     * Connection check
     * @return 
     */
    private String connect() {
        try {
            Class.forName(dbdriver);		// load DB driver

            System.out.println("connect 1");	// debug

            dbconn = DriverManager.getConnection(dburl); // create DB connection
            System.out.println("connect 2");	// debug

            /*create a SQL Statement */
            if (this.connectMode == NORMAL) {
                stmt = dbconn.createStatement();	// create a handle to the DB
            }
            if (this.connectMode == Edit) {
                stmt = dbconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);	// create a handle to the DB

            }
            System.out.println("connect 3");	// debug

        } catch (ClassNotFoundException e) {
            result = " Error creating database drive class!";
            result += " <br/>" + e.toString();
        } catch (SQLException e) {
            result = " Error processing connect!";
            result += " <br/>" + e.toString();
        }
        return result;
    }

    /**
     * Close database connection
     * @return 
     */
    private String close() {
        try {
            if (dbconn != null) {
                stmt.close();
                dbconn.close();
            }
        } catch (SQLException e) {
            result = "Error in closing connection.";
            result += " <br/>" + e.toString();
        }
        return result;
    }

}
