/* No.273
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

/*
  Time:  O( n ). N can never be too big!!
  Space: O( n )
*/

class Solution {
    // String Components used later
    private String[] units = {"","Thousand ","Million ","Billion "};
    private String[] NumInString10To20 = {"Ten ","Eleven ","Twelve ",
			"Thirteen ","Fourteen ","Fifteen ","Sixteen ",
			"Seventeen ","Eighteen ","Nineteen "}; 		// corner case
    private String[] NumInStringSingleDigit = {"","One ","Two ","Three ",
			"Four ","Five ","Six ","Seven ","Eight ","Nine "};
    private String[] NumInStringTens = {"","","Twenty ","Thirty ",
			"Forty ","Fifty ","Sixty ","Seventy ","Eighty ",
			"Ninety "};
    
    public String numberToWords(int num) {
    // first divide num into thousands, then assemble
        
        // corner case
        if ( num == 0 ) return "Zero";
        // initialize result & wordlist used in assembling
        StringBuilder result = new StringBuilder();
        
        // divide num into thousands
        int[] division = divide(num);
        
        // assembling
        for (int i = 3; i > -1; i--) {
            int NumInThousand = division[i];
            if (NumInThousand != 0) {
                String SubStringInThousand = getStringInThousand( NumInThousand );
                result.append( SubStringInThousand ).append( units[i] );
            }
        }
        
        // delete redundent blankspace
        result.deleteCharAt(result.length() - 1);
        
        return result.toString();
    }
    private int[] divide(int num) {
    // e.g. 1,234,567,890
        
        //initialize result
        int[] result = new int[4];
        
        for (int i = 0; i < 4; i++) {
            result[i] = num % 1000;
            num /= 1000;
        }
        
        return result;
    }
    private String getStringInThousand( int num ) {
    // return String representation for num < 1000 ( end in a blank space )
        
        // initialize result & wordList for assembling
        StringBuilder result = new StringBuilder();
        
        // assembling
        if (num >= 100) {
            result.append( NumInStringSingleDigit[num / 100] ).append("Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            result.append( NumInStringTens[num / 10] )
                  .append( NumInStringSingleDigit[num % 10] );
        } else if (num > 9) {
            result.append( NumInString10To20[num % 10] );
        } else {
            result.append( NumInStringSingleDigit[ num ] );
        }
        
        return result.toString();
    }
}