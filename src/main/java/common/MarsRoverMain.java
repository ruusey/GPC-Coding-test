package common;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;

import barcode.BarCodeUtil;

public class MarsRoverMain {
	public static void main(String[] args) throws IOException {
		// READ INPUT TEXT FROM input.txt in src/main/resources
		ClassLoader classLoader = MarsRoverMain.class.getClassLoader();
		File file = new File(classLoader.getResource("test3.JPG").getFile());
//		InputStream inputStream = new FileInputStream(file);
//		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//		BufferedReader reader = new BufferedReader(streamReader);
//		List<String> roverCommands = new ArrayList<String>();
//		for (String line; (line = reader.readLine()) != null;) {
//			roverCommands.add(line);
//		}
//
//		// Construct plateau and rover;
//		Plateau p = new Plateau(roverCommands.remove(0));
//		List<List<String>> roverInstructions = Partition.ofSize(roverCommands, 2);
//		for (List<String> instructionSet : roverInstructions) {
//			MarsRover rover = new MarsRover(instructionSet.get(0));
//			rover.navigate(instructionSet.get(1), p.getUpperBound());
//			rover.print();
//		}
//		reader.close();

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
		// String tmpRetString = BarCodeUtil.decode(tmpFile, null);
		System.out.println(barcodeText);
	}

}
