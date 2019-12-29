package com.PCorder;

import Model.ProductDAO;
import View.Test_Bench_MyFrame;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.google.gson.*;

public class App 
{
	private static String file = "C:\\04_PC_order\\PCorder\\JSON_dir\\weather.json";
    public static void main( String[] args) throws IOException{
    	//////////////////////
    	// Test Bench
    	//////////////////////
//    	ProductDAO test = new ProductDAO();
//    	test.getProduct(222222);
    	
    	//???
//    	Welcome data = Converter.fromJsonString("");
    	
    	new Test_Bench_MyFrame();
    }
}
