package com.sentiment.dataretrieval.dummy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sentiment.dataretrieval.common.DataRetrievalService;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service(value="dummy")
public class DummyDataRetrievalService implements DataRetrievalService {

	@Override
	public String fetchData() {
		try {
			InputStream input = new ClassPathResource("small_rt_snippets.txt").getInputStream();
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
			System.out.println(e.getMessage());
		}
		return null;
	}


}
