package com.example.webjson.parsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.webjson.data.ResultData;
import com.example.webjson.data.ResultArray;
import com.fasterxml.jackson.jr.ob.JSON;
import com.fasterxml.jackson.jr.ob.JSONObjectException;

public class JacksonJsonParser implements IJsonParser {

	public static void main(String[] args) {
		IJsonParser parser = new JacksonJsonParser();
		try (FileInputStream in = new FileInputStream("JSON Example.js")) {
			List<ResultData> results = parser.parseJson(in);
			for (ResultData result : results) {
				System.out.println(result.getTitle());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<ResultData> parseJson(InputStream in) throws IOException {
		ResultArray items = JSON.std.beanFrom(ResultArray.class, in);
		return items.getItems();
	}

}
