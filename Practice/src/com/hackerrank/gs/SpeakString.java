package com.hackerrank.gs;

public class SpeakString {

	public static void main(String[] args) {
		int i = 100345;

		String str = convertToSpeakableString(i);
		System.out.println(str);
	}

	private static String convertToSpeakableString(int i) {
		NumberToString ntos = new NumberToString10(new NumberToString100(new NumberToString1000(null)));
		String str = ntos.convert(i);


		return str;
	}

}

interface NumberToString {
	
	String convert(int i);
}

abstract class AbstractNumberToString implements NumberToString {
	NumberToString next;

	AbstractNumberToString(NumberToString next) {
		this.next = next;
	}
	public String convertBase20(int i) {
		switch (i) {
		case 1: return " one";
		case 2: return " two";
		case 3: return " three";
		case 4: return " four";
		case 5: return " five";
		case 6: return " six";
		case 7: return " seven";
		case 8: return " eight";
		case 9: return " nine";
		case 0: return "";
		case 11: return " eleven";
		case 12: return " twelve";
		case 13: return " thirteen";
		case 14: return " fourteen";
		case 15: return " fifteen";
		case 16: return " sixteen";
		case 17: return " seventeen";
		case 18: return " eighteen";
		case 19: return " nineteen";
		}
		return null;
	}
	public String convertOneHundred(int i) {
		String str = "";
		if (i<20) {
			str=convertBase20(i);
		} else { 
			switch (i/10){
			case 2: str= " twenty"  + convertBase20(i%10); break;
			case 3: str= " thirty" + convertBase20(i%10); break;
			case 4: str= " forty" + convertBase20(i%10); break;
			case 5: str= " fifty" + convertBase20(i%10); break;
			case 6: str= " sixty" + convertBase20(i%10); break;
			case 7: str= " seventy" + convertBase20(i%10); break;
			case 8: str= " eighty" + convertBase20(i%10); break;
			case 9: str= " ninty" + convertBase20(i%10); break;
			case 0: str= "";break;
			}
		}
		return str;
	}
	public String convertHundreds(int i){
		if (i>99){
			return convertBase20(i/100)+ " hundred"+ convertOneHundred(i%100);
		}
		else {
			return convertOneHundred(i%100);
		}
	}
}

class NumberToString10 extends AbstractNumberToString {

	NumberToString10(NumberToString next) {
		super(next);
	}

	@Override
	public String convert(int i) {
		return next.convert(i/100)+convertOneHundred(i%100);
	}
}

class NumberToString100 extends AbstractNumberToString {

	NumberToString100(NumberToString next) {
		super(next);
	}

	@Override
	public String convert(int i) {
		return next.convert(i/10) + convertOneHundred(i%10)+ " hundred"  ;
	}
}
class NumberToString1000 extends AbstractNumberToString {

	NumberToString1000(NumberToString next) {
		super(next);
	}

	@Override
	public String convert(int i) {
		if (null!=next){
			return next.convert(i/10000) + convertOneHundred(i%1000)+ " thousand"  ;
		}
		else {
			return convertHundreds(i%1000)+ " thousand"  ;
		}
	}
}