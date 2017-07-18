package com.codility.ca;

public class Third {

	public static void main(String[] args) {
		System.out.println(solution("ABBCC"));
		System.out.println(solution("A"));
		System.out.println(10%1);
		
		System.out.println(solution("AAAAABBBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCCAAAAAAAAAAAAAAAA"));
		
	}

	static public String solution(String str) {

		return applyRule(str);
	}

	private static String applyRule(String str) {
		String[] matchedRules = new String[6];
		int countRulesMatched = 0;
		if (str.contains("AB")) {
			matchedRules[countRulesMatched] = "AB";
			countRulesMatched++;
		}
		if (str.contains("BA")) {
			matchedRules[countRulesMatched] = "BA";
			countRulesMatched++;
		}
		if (str.contains("CB")) {
			matchedRules[countRulesMatched] = "CB";
			countRulesMatched++;
		}
		if (str.contains("BC")) {
			matchedRules[countRulesMatched] = "BC";
			countRulesMatched++;
		}
		if (str.contains("AA")) {
			matchedRules[countRulesMatched] = "AA";
			countRulesMatched++;
		}
		if (str.contains("CC")) {
			matchedRules[countRulesMatched] = "CC";
			countRulesMatched++;
		}
		if (countRulesMatched == 0)
			return str;
		int pickRule = (int) (Math.random() % countRulesMatched);
		String ruleID = matchedRules[pickRule];
		switch (ruleID) {
		case "AB":
			str = str.replaceFirst("AB", "AA");
			break;
		case "BA":
			str = str.replaceFirst("BA", "AA");
			break;
		case "CB":
			str = str.replaceFirst("CB", "CC");
			break;
		case "BC":
			str = str.replaceFirst("BC", "CC");
			break;
		case "AA":
			str = str.replaceFirst("AA", "A");
			break;
		case "CC":
			str = str.replaceFirst("CC", "C");
			break;
		}
		return applyRule(str);

	}
}
