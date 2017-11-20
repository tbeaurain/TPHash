import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		File file = new File("./DS1-trace.txt"); //emplacement du fhichier qu'on souhaite lire
		buildMerkleTree(file);
		
		// test de la class leaf pour verifier que ca hash bien
		
		//Leaf leaf = new Leaf ("toto");
		//System.out.println(leaf);
		
	}

	// Fonction qui permet de creer l'arbre
	private static void buildMerkleTree(File file) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		List<MerkleTree> listOfTree = new ArrayList<>();
		MerkleTree leftMerkleTree = new MerkleTree();
		MerkleTree tree = new MerkleTree();
		try {
			while ((line = bufferedReader.readLine()) != null) {
				Leaf leaf = new Leaf(line);
				
				tree = new MerkleTree(leftMerkleTree ,leaf);
				
				leftMerkleTree.setRightMerkleTree(tree);
				leftMerkleTree = tree;
				
				listOfTree.add(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listOfTree);
	}
	
	//lire une liste de byte
	public static void printByte (List<byte[]> liste){
		for (int i = 0; i < liste.size(); i++)
			System.out.println(liste.get(i));
	}
}
