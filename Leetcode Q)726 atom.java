package atom;
//import java.util.*;
//import java.util.Map.Entry;
//public class simu {
	//public static String countOfAtoms(String formula)
	//{
		//Map<String,Integer> m1 = new HashMap<>();
		//Stack<Map<String,Integer>> s1 = new Stack<>();
		//int n = formula.length();
		/*
		 * for(int i=0;i<n;i++) { char a = formula.charAt(i); if(a == '(' || a == ')') {
		 * continue; } else { s1.push(formula.charAt(i)); }
		 * 
		 * System.out.println("Elements in the stack: "); for (char element : s1) {
		 * System.out.println(element); } }
		 */
		//int i=0;
		//while(i<n)
		//{
			//char c = formula.charAt(i); 
			//if(c == '(')
			//{
				//s1.push(m1);
				//Map<String,Integer> m2 = new HashMap<>();
				//m1 = new HashMap<>();
				//i++;
			//}
			//else if(c==')')
			//{
				//i++;
				//int start = i;
				//while(i<n && Character.isDigit(formula.charAt(i)))
				//{
					//i++;
				//}
				//int multiply = (start < i) ? (formula.charAt(start) -'0') : 1;
				// it's assuming that the multiplier for elements inside parentheses is always a single digit 
				//int multiply = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
				//if(!s1.isEmpty())
				//{
					//Map<String,Integer> d1 = m1;
					//s1.pop();
					// Map.entry structure deta hai map ka ,,,,, entryset se access kr rahe hai key or value ko
					//for(Map.Entry<String, Integer> entry : d1.entrySet())
					//{
						//m1.put(entry.getKey(), m1.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiply);
					//}
				//}
				
			//}
		//else
			//{
				//int begin = i++;
                //while (i < n && Character.isLowerCase(formula.charAt(i))) {
                  //  i++;
                //}
                //String a = formula.substring(begin, i);

                //begin = i;
                //int count = 0;
                //while (i < n && Character.isDigit(formula.charAt(i))) {
                  //  count = count * 10 + (formula.charAt(i) - '0');
                    //i++;
                //}
                //if (begin == i) {
                  //  count = 1;
                //}

            //    m1.put(a, m1.getOrDefault(a, 0) + count);
			//}
		//}
		// Direct convert hogya map to list
		//List<Map.Entry<String,Integer>> l1 = new ArrayList<>(m1.entrySet());
		//l1.sort(Map.Entry.comparingByKey());
		//StringBuilder sb = new StringBuilder();
		//for (Map.Entry<String, Integer> item : l1) {
			//only want 
			//sb.append(item.getKey());
            //if (item.getValue() > 1) {
              //  sb.append(item.getValue());
            //}
		//}
			//String result = sb.toString();
		//return result;
	//}
	//public static void main(String args[])
	//{
		//String formula = "Mg(OH)2";
		//String result1 = countOfAtoms(formula);
		//System.out.println(result1);
	//}
//}
import java.util.*;

public class atom {
    public static String countOfAtoms(String formula) {
        Map<String, Integer> m1 = new HashMap<>();
        Stack<Map<String, Integer>> s1 = new Stack<>();
        int n = formula.length();
        int i = 0;
        
        while (i < n) {
            char c = formula.charAt(i); 
            if (c == '(') {
                s1.push(m1); // Save current map state before entering new parentheses
                m1 = new HashMap<>(); // Reset m1 for nested parentheses
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiply = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                if (!s1.isEmpty()) {
                    Map<String, Integer> d1 = m1;
                    m1 = s1.pop(); // Restore previous map state
                    for (Map.Entry<String, Integer> entry : d1.entrySet()) {
                        m1.put(entry.getKey(), m1.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiply);
                    }
                }
            } else {
                int begin = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(begin, i);
                
                begin = i;
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (begin == i) {
                    count = 1; // If no digit found, default count is 1
                }
                
                m1.put(element, m1.getOrDefault(element, 0) + count);
            }
        }
        
        List<Map.Entry<String, Integer>> l1 = new ArrayList<>(m1.entrySet());
        l1.sort(Map.Entry.comparingByKey()); // Sort entries alphabetically by element name
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> item : l1) {
            sb.append(item.getKey());
            if (item.getValue() > 1) {
                sb.append(item.getValue());
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String formula = "Mg(OH)2";
        String result1 = countOfAtoms(formula);
        System.out.println(result1); 
    }
}
