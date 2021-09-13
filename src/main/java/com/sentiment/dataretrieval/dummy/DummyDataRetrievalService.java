package com.sentiment.dataretrieval.dummy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sentiment.dataretrieval.common.DataRetrievalService;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Random;

@Service(value="dummy")
public class DummyDataRetrievalService implements DataRetrievalService {

	@Override
	public String fetchData() {
		try {
			InputStream input = new ClassPathResource("small_dummy_with_timestamps.txt").getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line;
			int index = 0;
			ObjectMapper map = new ObjectMapper();
			ObjectNode root = map.createObjectNode();
			while((line = br.readLine()) != null) {
				ObjectNode child = map.createObjectNode();
				try {
					Long.parseLong(line);
					child.put("timestamp", line);
					line = br.readLine();
				} catch(NumberFormatException notLong) {
					//No timestamp so only need to add content field
				} catch(IOException lineAfterTimeIsNull) {
					//Improper formatting - no text after timestamp
					System.out.println(lineAfterTimeIsNull.getMessage());
				}

				child.put("content", line);
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
