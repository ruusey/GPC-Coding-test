package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    public static String changeFormat(String paragraph) {
		String pattern = "(.*)(\\d{3}\\-\\d{2}\\-\\d{4})(.*)";
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(paragraph);
		if (m.find()) {
			String match = m.group(2);
			String[] split = match.split("-");
			m.replaceFirst(split[0] + "/" + split[2] + "/" + split[1]);
			System.out.println("Found value: " + m.group(2));

		} else {
			System.out.println("NO MATCH");
		}
		String in = paragraph.substring(paragraph.length() - 12, paragraph.length());
		in = in.replaceAll("\\.", "");
		String[] split = in.split("-");
		String newNum = split[0] + "/" + split[2] + "/" + split[1];
		return "Please quote your policy number: " + newNum + ".";
	}

	public static void main(String[] args) {
		System.out.println(changeFormat("Please quote your policy number: 112-39-8552."));
	}
}