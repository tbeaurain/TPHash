import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MerkleTree {

	public MerkleTree leftMerkleTree = null;
	public MerkleTree rightMerkleTree = null;
	public Leaf leaf = null;

	
	public MerkleTree(){
	}
	
	public MerkleTree(Leaf leaf){
		this.leaf = leaf;
	}
	
	public MerkleTree( MerkleTree leftMerkleTree, Leaf leaf){
		this.leaf = leaf;
		this.leftMerkleTree = leftMerkleTree;
	}
	
	public MerkleTree( MerkleTree leftMerkleTree, MerkleTree rightMerkleTree, Leaf leaf){
		this.leaf = leaf;
		this.leftMerkleTree = leftMerkleTree;
		this.rightMerkleTree = rightMerkleTree;
	}
	
	private void setMessageDigest(MessageDigest messageDigest){
		if(messageDigest==null){
			try {
				messageDigest=MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}

	public MerkleTree getLeftMerkleTree() {
		return leftMerkleTree;
	}

	public void setLeftMerkleTree(MerkleTree leftMerkleTree) {
		this.leftMerkleTree = leftMerkleTree;
	}

	public MerkleTree getRightMerkleTree() {
		return rightMerkleTree;
	}

	public void setRightMerkleTree(MerkleTree rightMerkleTree) {
		this.rightMerkleTree = rightMerkleTree;
	}

	public Leaf getLeaf() {
		return leaf;
	}

	public void setLeaf(Leaf leaf) {
		this.leaf = leaf;
	}

}