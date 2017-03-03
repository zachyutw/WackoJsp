/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author po-yingyu
 */
public class LineItem {
     private String[] selectedProductId;
    private String[] selectedProductQty;   
    
    public void clearLineItem()
    {
        this.selectedProductId=null;
        this.selectedProductQty=null;
    }

    public String[] getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(String[] selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public String[] getSelectedProductQty() {
        return selectedProductQty;
    }

    public void setSelectedProductQty(String[] selectedProductQty) {
        this.selectedProductQty = selectedProductQty;
    }
    
}
