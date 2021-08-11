package com.sentiment.dataretrieval.dummy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sentiment.dataretrieval.external.DataRetrievalService;

import java.io.*;

import org.springframework.core.io.ClassPathResource;

public class DummyDataRetrievalService implements DataRetrievalService {

	@Override
	public String fetchData() {
		try {
			InputStream input = new ClassPathResource("original_rt_snippets.txt").getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line;
			int index = 0;
			ObjectMapper map = new ObjectMapper();
			ObjectNode root = map.createObjectNode();
			while((line = br.readLine()) != null) {
				line.trim();
				ObjectNode child = map.createObjectNode();
				child.put("fullText", line);
				root.set(String.valueOf(index), child);
				index++;
			}
			return map.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		} catch(Exception e) {
			System.out.println("YOU DONE MESSED UP");
			System.out.println(e.getMessage());
		}
		return null;
	}


}
