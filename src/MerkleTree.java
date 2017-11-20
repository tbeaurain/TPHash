import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MerkleTree {

	private MerkleTree leftMerkleTree = null;
	private MerkleTree rightMerkleTree = null;
	private Leaf leftLeaf = null;
	private Leaf rightLeaf = null;
	private byte[] hashValue;
	private final MessageDigest messageDigest=null;

	
	public MerkleTree(){
		
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
	
	
	private byte[] setAndUpdateMessageDigest(Leaf leaf) {
		setMessageDigest(messageDigest);
		final byte[] hashOfLogSingleEvent = leaf.getHashOfLogSingleEvent();
		for (int i = 0; i < hashOfLogSingleEvent.length; i++) {
			messageDigest.update(hashOfLogSingleEvent[i]);
		}
		hashValue = messageDigest.digest(hashOfLogSingleEvent);
		return hashValue;
	}

	private void addChildSubTrees(final MerkleTree leftMerkleTree, final MerkleTree rightMerkleTree) {
		setMessageDigest(messageDigest);
		this.leftMerkleTree = leftMerkleTree;
		this.rightMerkleTree = rightMerkleTree;

		messageDigest.update(leftMerkleTree.getHashValue());
		hashValue = messageDigest.digest(rightMerkleTree.getHashValue());
	}

	private void addChildLeafs(final Leaf leftLeaf, final Leaf rightLeaf) {
		setMessageDigest(messageDigest);
		this.leftLeaf = leftLeaf;
		this.rightLeaf = rightLeaf;
		messageDigest.update(setAndUpdateMessageDigest(leftLeaf));
		hashValue = messageDigest.digest(setAndUpdateMessageDigest(rightLeaf));
	}

	public byte[] getHashValue() {
		return hashValue;
	}

	public MerkleTree getLeftTree() {
		return leftMerkleTree;
	}
	
	public MerkleTree getRightTree() {
		return rightMerkleTree;
	}
	
	public Leaf getLeftLeaf() {
		return leftLeaf;
	}
	
	public Leaf getRightLeaf() {
		return rightLeaf;
	}

}