package com.PCorder;

import Model.ProductDAO;
import View.MyFrame;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.google.gson.*;
import JSON_Weather.Converter;
import JSON_Weather.Welcome;

public class App 
{
	private static String file = "C:\\04_PC_order\\PCorder\\JSON_dir\\weather.json";
    public static void main( String[] args) throws IOException{
    	//////////////////////
    	// Test Bench
    	//////////////////////
    	//JConnector 플러그인으로 JDBC연동 성공...
//    	ProductDAO test = new ProductDAO();
//    	test.getProduct(222222);
    	
    	//???
//    	Welcome data = Converter.fromJsonString("");
    	
    	new MyFrame();
    }
}
