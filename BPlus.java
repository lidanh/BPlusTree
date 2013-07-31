/*
 * BPlus Main Application- a simulation of B+ tree
 * This application was an assignment for Data Structures course, Ben Gurion University, May 2013
 * @author Lidan Hifi
 */
public class BPlus {
	
	/*
	 * create the tree based on input data, tree param and the order element we're looking for
	 * @param inputData list of keys
	 * @param treeParam tree param
	 * @param orderElement the element's key that we want to find its index
	 */
	public static String makeTree(String inputData, int treeParam, int orderElement) {
		String[] elements = inputData.split(" ");
		
		// create a new b+tree based on the elements amount
		BPlusTree<Integer> tree = new BPlusTree<Integer>(treeParam, elements.length);
		
		// insert each element to the tree
		int el;
		for (String element : elements) {
			el = Integer.parseInt(element);
			tree.insert(el, el);
		}
		
		// return the output data, the result of the insertion
		StringBuilder outputData = new StringBuilder();
		outputData.append(tree);
		outputData.append("\n");
		outputData.append(tree.getMinGap());
		outputData.append("\n");
		outputData.append(tree.order(orderElement));
		
		return outputData.toString();
	}
	
	public static void main(String[] args) {
		if (args.length < 4)
			// check arguments
			System.err.println("Oops.  Some arguments are missing. please try again");
		else {
			// read the arguments and build the tree
			String file = args[0];
			String inputFile = FilesReaderWriter.readFromFile(file).trim();
			int treeParam = Integer.parseInt(args[1]);
			int orderElement = Integer.parseInt(args[2]);
			String outputFile = args[3];
			
			String outputData = makeTree(inputFile, treeParam, orderElement);
			
			// write the output to a file
			FilesReaderWriter.writeToFile(outputFile, outputData);
		}
	}
}
