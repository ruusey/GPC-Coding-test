package barcode;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;


public class BarCodeMain {
	public static void main(String[] args) throws IOException {
		// READ INPUT TEXT FROM input.txt in src/main/resources
		ClassLoader classLoader = BarCodeMain.class.getClassLoader();
		File file = new File(classLoader.getResource("test3.JPG").getFile());

		Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
		tmpHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
		tmpHintsMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
		tmpHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);
		String barcodeText = null;
		try {
			barcodeText = BarCodeUtil.decode(file, tmpHintsMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(barcodeText);
	}
}
