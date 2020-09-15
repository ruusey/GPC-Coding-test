package testing;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import common.MarsRover;
import common.MarsRoverMain;
import common.Partition;
import common.Plateau;

public class MarsRoverTests {

	@Test
	public void testBaseCase() throws IOException {
		System.out.println("Testing base case");
		List<String> roverCommands = loadInputFile("input.txt");
		Plateau p = new Plateau(roverCommands.remove(0));
		List<List<String>> roverInstructions = Partition.ofSize(roverCommands, 2);
		MarsRover rover0 = new MarsRover(roverInstructions.get(0).get(0));
		rover0.navigate(roverInstructions.get(0).get(1), p.getUpperBound());
		assertEquals(rover0.printStr(), "1 3 N", "Rover 0 Was expected to be at location 1 3 N");
		MarsRover rover1 = new MarsRover(roverInstructions.get(0).get(0));
		rover1.navigate(roverInstructions.get(0).get(1), p.getUpperBound());
		assertEquals(rover1.printStr(), "5 1 E", "Rover 1 Was expected to be at location 5 1 E");

	}

	@Test
	public void testEdgeCase() throws IOException {
		System.out.println("Testing edge case");
		List<String> roverCommands = loadInputFile("input1.txt");
		Plateau p = new Plateau(roverCommands.remove(0));
		List<List<String>> roverInstructions = Partition.ofSize(roverCommands, 2);
		MarsRover rover0 = new MarsRover(roverInstructions.get(0).get(0));
		rover0.navigate(roverInstructions.get(0).get(1), p.getUpperBound());
		assertEquals(rover0.printStr(), "0 2 W", "Rover 0 Was expected to be at location 0 2 W");


	}

	public static List<String> loadInputFile(String fileName) throws IOException {
		ClassLoader classLoader = MarsRoverMain.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		List<String> roverCommands = new ArrayList<String>();
		for (String line; (line = reader.readLine()) != null;) {
			roverCommands.add(line);
		}
		reader.close();
		return roverCommands;
	}
}
