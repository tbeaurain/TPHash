import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Leaf {

	private final byte[] hashOfLogSingleEvent;

	public Leaf(String logSingleEvent) {
		hashOfLogSingleEvent = hash(logSingleEvent);
	}

	private byte[] hash(String string) {
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

	public byte[] getHashOfLogSingleEvent() {
		return hashOfLogSingleEvent;
	}

}
