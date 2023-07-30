package br.com.erudio.utils;

import java.util.logging.Logger;

public class NumericConvert {

	private static Logger logger = Logger.getLogger(NumericConvert.class.getName());
	
	public static Boolean isNumeric(String strNumber) {
		
		if (strNumber == null) return false;
		
		String number = replaceCommaInDot(strNumber);
		Boolean matche = number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
		logger.info(String.format("): Replace number: %s - %s", number, matche));

		return replaceCommaInDot(strNumber).matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	

	public static Double convertToDouble(String strNumber) {
		
		if (strNumber ==  null) return 0D;
		
		String number = replaceCommaInDot(strNumber);
					
		if (isNumeric(number)) return  Double.parseDouble(number);
		
		return 0D;
		
	}
	
	private static String replaceCommaInDot(String strNumber) {
		return strNumber.replaceAll(",", ".");
	}

}
