import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// todo: créer une méthode qui divise un fichier de texte en feuilles
		// etc
		// pour le moment les feuilles ne prennent en compte qu'une seule ligne
		// du fichier de texte

		File file = new File(
				"C:/Users/Juliette/Documents/A3/Semestre 1/Architecture distribuée/tp/tp4/test.txt");
		buildMerkleTree(file);
	}

	private static void buildMerkleTree(File file) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		List<byte[]> listOfHashes = new ArrayList<>();
		List<String> listOfLines = new ArrayList<>();
		try {
			while ((line = bufferedReader.readLine()) != null) {
				final Leaf leaf = new Leaf(line);
				byte[] hashOfLine = leaf.getHashOfLogSingleEvent();
				listOfHashes.add(hashOfLine);
				listOfLines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listOfHashes);
		List<byte[]> newListHash=new ArrayList<>();
		while(listOfHashes.size()!=1){
			for (int i = 0; i < listOfHashes.size(); i++) {
				if ((i + 1) < listOfHashes.size()) {
					for(int j=0;j<listOfHashes.get(i).length;j++){
//						newListHash.add(hash(listOfHashes.get(i).get(j)*listOfHashes.get(i + 1)));
//						newListHash.add((listOfHashes.get(i).hashCode()+listOfHashes.get(i + 1).hashCode())
					}
					
				}
			}
			System.out.println(listOfHashes);
		}
//		while(listOfHashes.size()!=1){
//			long result = 17;
//			for (byte[] hash:listOfHashes) result = 37*result + hash;
//		}
		
		
	}

	private static byte[] hash(String string) {
		byte[] stringToBytes = string.getBytes(StandardCharsets.UTF_8);
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash = null;
		if (digest != null) {
			hash = digest.digest(stringToBytes);
		}
		return hash;
	}

}
