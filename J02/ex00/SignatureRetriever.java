import java.util.* ;

//le signatures sono sempre all'inizio del file, al byte 0;


public class SignatureRetriever {

	private static int maxBytes = 12;
	private static HashMap <String, List<Byte>> map = new HashMap<>();

	static {
		map.put("class", Arrays.asList(
			(byte) 	0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE));
		map.put("dmg", Arrays.asList(
			(byte) 0x78, (byte) 0x01, (byte) 0x73, (byte) 0x0D, (byte) 0x62, (byte) 0x62, (byte) 0x60));
		map.put("gif", Arrays.asList(
			(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38, (byte) 0x39, (byte) 0x61));
		map.put("heic", Arrays.asList(
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x18, (byte) 0x66, (byte) 0x74, (byte) 0x79,
			(byte) 0x70, (byte) 0x68, (byte) 0x65, (byte) 0x69, (byte) 0x63));
		map.put("jpg", Arrays.asList(
			(byte) 0xFF, (byte) 0xD8, (byte) 0xFF));
		map.put("mp3", Arrays.asList(
			(byte) 0x49, (byte) 0x44, (byte) 0x33));
		map.put("png", Arrays.asList(
			(byte) 0x89, (byte) 0x50, (byte) 0x4E, (byte) 0x47, (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A));
		map.put("rar", Arrays.asList(
			(byte) 0x52, (byte) 0x61, (byte) 0x72, (byte) 0x21, (byte) 0x1A, (byte) 0x07, (byte) 0x01, (byte) 0x00));
		map.put("xml", Arrays.asList(
			(byte) 0x3C, (byte) 0x3F, (byte) 0x78, (byte) 0x6D, (byte) 0x6C, (byte) 0x20));
		map.put("pdf", Arrays.asList(
			(byte) 0x25, (byte) 0x50, (byte) 0x44, (byte) 0x46, (byte) 0x2D));
	}
	
	public static int getMaxBytes() {
		return maxBytes;
	}

	public static HashMap <String, List<Byte>> getSignatureMap() {
		return map;
	}
}


