package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.DividendCannotBeZeroException;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.utils.NumericConvert;

@RestController
public class MathController {

	
	@GetMapping("/{operation}/{numberOne}/{numberTwo}")
	public Double resultCalc (
			@PathVariable("operation") String operation,
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			) throws Exception  {
		
		if (!NumericConvert.isNumeric(numberOne) || !NumericConvert.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		Double result = 0D;
		
		switch(operation) {
		case "sum":
			result = NumericConvert.convertToDouble(numberOne) + NumericConvert.convertToDouble(numberTwo);
			break;
		case "subtract":
			result = NumericConvert.convertToDouble(numberOne) - NumericConvert.convertToDouble(numberTwo);
			break;
		case "multiply":
			result = NumericConvert.convertToDouble(numberOne) * NumericConvert.convertToDouble(numberTwo);
			break;
		case "divide":
			if (NumericConvert.convertToDouble(numberTwo) == 0) {
				throw new DividendCannotBeZeroException("Dividend cannot be zero");
			}
			result = NumericConvert.convertToDouble(numberOne) / NumericConvert.convertToDouble(numberTwo);
			break;
		default:
			result = 0D;
		}
		
		return result;
		
	}
	
	
}
