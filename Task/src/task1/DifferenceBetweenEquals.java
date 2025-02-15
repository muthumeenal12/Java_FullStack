package task1;

import java.util.*;

public class DifferenceBetweenEquals {
	public static void main(String[] args) {
		//tokenIDS and receivedTokens are exact same.
		String[] [] tokenIDs = {{"e92f1a8b-4c37-45d9-bb16-a2f3b6d91c70",
				"7a6c2d19-85e0-4b4f-8d23-dc9a1e5f072b"}, {"f48d3b7a-1c92-4efb-92d5-e8f714b8c635 ",
				"c17f5e3d-98ab-4a42-bd71-09e5f3217fa0", "b3d8c9e4-27f1-41d8-994c-6f25a8d37b2c"}};
		String[][] receivedTokens = {{"e92f1a8b-4c37-45d9-bb16-a2f3b6d91c70",
			"7a6c2d19-85e0-4b4f-8d23-dc9a1e5f072b"}, {"f48d3b7a-1c92-4efb-92d5-e8f714b8c635 ",
			"c17f5e3d-98ab-4a42-bd71-09e5f3217fa0", "b3d8c9e4-27f1-41d8-994c-6f25a8d37b2c"}};
		String[][] userTokens = {{"a3f6c9d2-7b81-44e6-913f-2d8b5a17c4e9",
				"f12b7d83-5e69-41ab-a246-8d3e9a1c7f50 "},{ "9c27d5e4-8f63-4ba9-b12d-6e5a3c89f7b0",
				"e7a15d3b-42f9-4c86-b71d-d8c2f4a09e65 ", "4b92f1d7-a36e-4c85-9d2a-5e7c8b31f04b"}};
		
		// Arrays.equals() to compare non-nested Array and Arrays.deepEquals() to compare nested Array.
	
		//equals() goes to default java.lang.Object equals(), which compares reference of two Object and does
		//not perform deep comparison and fails logical comparison in case of nested Array.
		
		//between tokenIDs and userTokens
		System.out.println("DeepEquals {tokenIDs and userTokens}: "+Arrays.deepEquals(tokenIDs, userTokens));
		System.out.println("Equals: "+Arrays.equals(tokenIDs, userTokens));

		//tokenIDs vs receivedTokens
		System.out.println("\nDeepEquals {tokenIDs vs receivedTokens}: "+Arrays.deepEquals(tokenIDs, receivedTokens));
		System.out.println("Equals: "+Arrays.equals(tokenIDs, receivedTokens));
		
		//receivedTokens vs userTokns
		System.out.println("\nDeepEquals {receivedTokens vs userTokens}: "+Arrays.deepEquals(receivedTokens, userTokens));
		System.out.println("Equals: "+Arrays.equals(receivedTokens, userTokens));
		
		
	}

}
