package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MarsRoverMain {
	public static void main(String[] args) throws IOException {
		// READ INPUT TEXT FROM input.txt in src/main/resources
		ClassLoader classLoader = MarsRoverMain.class.getClassLoader();
		File file = new File(classLoader.getResource("input1.txt").getFile());
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		List<String> roverCommands = new ArrayList<String>();
		for (String line; (line = reader.readLine()) != null;) {
			roverCommands.add(line);
		}

		// Construct plateau and rover;
		Plateau p = new Plateau(roverCommands.remove(0));
		List<List<String>> roverInstructions = Partition.ofSize(roverCommands, 2);
		for (List<String> instructionSet : roverInstructions) {
			MarsRover rover = new MarsRover(instructionSet.get(0));

			rover.navigate(instructionSet.get(1), p.getUpperBound());
			rover.print();

		}
		reader.close();

	}
}
