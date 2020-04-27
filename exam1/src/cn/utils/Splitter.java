package cn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	
	public static int[] splitToInt( String line ){
		String regex = "\\S+";
		Pattern pat = Pattern.compile( regex );
		Matcher mat = pat.matcher( line );
		int[] numbers = new int[60];
		int i = 0;
		while( mat.find() ){
			String num_str = mat.group(0);
			if(!num_str.equals("null")) {
				numbers[i] = new Integer(num_str);
			}
			i++;
		}
		return numbers;
	}
	
	public static String[] splitToString( String line ){
		String regex = "\\S+";
		Pattern pat = Pattern.compile( regex );
		Matcher mat = pat.matcher( line );
		String[] characters = new String[60];
		int i = 0;
		while( mat.find() ){
			String num_str = mat.group(0);
			if(!num_str.equals("null")) {
				characters[i] = num_str;
			}
			i++;
		}
		return characters;
	}

}
