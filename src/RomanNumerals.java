public class RomanNumerals {
	
	public int convertToInteger(String romanNum) throws RomanNumeralsException {

		int sum = 0;
		
		if(checkInput(romanNum)) {
			
			if(check_IXCM_3_times(romanNum)) {
			
				if(check_VLD_Once(romanNum)) {
					
					if(check_substraction_rule(romanNum)) {
						
						if(check_one_substraction(romanNum)) {
							
							for(int i = romanNum.length() - 1; i >= 0; i--) {
								
								if(i != 0 && letterValue(romanNum.charAt(i)) > letterValue(romanNum.charAt(i - 1))) {
									
									sum = sum + letterValue(romanNum.charAt(i)) - 2 * letterValue(romanNum.charAt(i - 1));
									
								}
								
								else {
									
									sum += letterValue(romanNum.charAt(i));
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		return sum;
		
	}
	
	public int letterValue(char letter) throws RomanNumeralsException {
		
		int value = -1;
		
		switch(letter) {
		
		case 'I':
			
			value = 1;
			break;
			
		case 'V':
			
			value = 5;
			break;
			
		case 'X':
		
			value = 10;
			break;
			
		case 'L':
			
			value = 50;
			break;
			
		case 'C':
			
			value = 100;
			break;
			
		case 'D':
			
			value = 500;
			break;
			
		case 'M':
			
			value = 1000;
			break;
			
		default:
			
			throw new RomanNumeralsException();
		
		
		}
		
		return value;
		
	}
	
	public boolean checkInput(String RomanNum) throws RomanNumeralsException {
		
		for(int i = 0; i < RomanNum.length(); i++) {
			
			letterValue(RomanNum.charAt(i));
			
		}
		
		return true;
		
	}
	
	public boolean check_IXCM_3_times(String RomanNum) throws RomanNumeralsException {
		
		char previousLetter = ' ';
		int count = 0;
		
		for(int i = 0; i < RomanNum.length(); i++) {
			
			if(RomanNum.charAt(i) == 'I' || RomanNum.charAt(i) == 'X' || RomanNum.charAt(i) == 'C' || RomanNum.charAt(i) == 'M') {
				
				if(RomanNum.charAt(i) == previousLetter) {
					
					count++;
					
				}
				
				else {
					
					count = 1;
					
					previousLetter = RomanNum.charAt(i);
					
				}
				
			}
			
			if(count > 3) {
				
				throw new RomanNumeralsException();
				
			}
			
		}
		
		return true;
		
		
	}
	
	public boolean check_VLD_Once(String RomanNum) throws RomanNumeralsException {
		
		char previousLetter = ' ';
		int count = 0;
		
		for(int i = 0; i < RomanNum.length(); i++) {
			
			if(RomanNum.charAt(i) == 'V' || RomanNum.charAt(i) == 'L' || RomanNum.charAt(i) == 'D') {
				
				if(RomanNum.charAt(i) == previousLetter) {
					
					count++;
					
				}
				
				else {
					
					count = 1;
					
					previousLetter = RomanNum.charAt(i);
					
				}
				
			}
			
			if(count > 1) {
				
				throw new RomanNumeralsException();
				
			}
			
		}
		
		return true;
		
		
	}
	
	public boolean check_substraction_rule(String RomanNum) throws RomanNumeralsException {
		
		for(int i = 0; i < RomanNum.length() - 1; i++) {
			
			if(letterValue(RomanNum.charAt(i)) < letterValue(RomanNum.charAt(i + 1))) {
				
				if(letterValue(RomanNum.charAt(i)) > 10 * letterValue(RomanNum.charAt(i + 1))) {
					
					throw new RomanNumeralsException();
					
				}
				
				if(RomanNum.charAt(i) == 'V' || RomanNum.charAt(i) == 'L' || RomanNum.charAt(i) == 'D') {
					
					throw new RomanNumeralsException();
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
	public boolean check_one_substraction(String RomanNum) throws RomanNumeralsException {
		
		for(int i = 0; i < RomanNum.length() - 2; i++) {
			
			if(letterValue(RomanNum.charAt(i)) == letterValue(RomanNum.charAt(i + 1))) {
				
				if(letterValue(RomanNum.charAt(i + 1)) < letterValue(RomanNum.charAt(i + 2))) {
					
					throw new RomanNumeralsException();
					
				}
				
			}
		
		}
		
		return true;
		
	}
	
}
