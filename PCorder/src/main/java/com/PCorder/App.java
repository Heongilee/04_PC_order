package com.PCorder;

import Model.ProductDAO;
import View.MyFrame;


public class App 
{
    public static void main( String[] args )
    {
    	ProductDAO test = new ProductDAO();
    	test.getProduct(222222);
    	
    	new MyFrame();
    }
}
