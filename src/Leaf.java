import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Leaf {

	public byte[] hashOfLogSingleEvent = null;
	public MessageDigest digest = null;
	  
	public Leaf(String logSingleEvent) {
		byte[] stringToBytes = logSingleEvent.getBytes(StandardCharsets.UTF_8);
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		hashOfLogSingleEvent = null;
		if (digest != null) {
			hashOfLogSingleEvent = digest.digest(stringToBytes);
		}
	}

	public String toString() {
		return "Leaf [hashOfLogSingleEvent=" + Arrays.toString(hashOfLogSingleEvent) + ", digest=" + digest + "]";
	}

	public byte[] getHashOfLogSingleEvent() {
		return hashOfLogSingleEvent;
	}

	public void setHashOfLogSingleEvent(byte[] hashOfLogSingleEvent) {
		this.hashOfLogSingleEvent = hashOfLogSingleEvent;
	}
	
	public MessageDigest getDigest() {
		return digest;
	}

	public void setDigest(MessageDigest digest) {
		this.digest = digest;
	}

}
