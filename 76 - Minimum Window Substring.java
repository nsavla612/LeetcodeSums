class Solution {
    public String minWindow(String s, String t) {
        String minString = new String();
        Map<Character, Integer> mapOfT = new HashMap<>();
        Map<Character, Integer> mapOfS = new HashMap<>();
        int start = 0, end = 0;
        
        for(Character c : t.toCharArray())
        {
            mapOfT.put( c , mapOfT.getOrDefault(c, 0) + 1);
        }

        while(end < s.length() )
        {
            mapOfS.put( s.charAt(end) , mapOfS.getOrDefault(s.charAt(end), 0) + 1);
            if(isAllCharactersOfTPresent(mapOfT, mapOfS))
            {
                while(isAllCharactersOfTPresent(mapOfT, mapOfS ))
                {
                    if(minString.length() == 0 || minString.length() > end - start + 1 )
                        minString = s.substring(start, end + 1);
                    
                    mapOfS.put( s.charAt(start) , mapOfS.get(s.charAt(start)) - 1);
                    start++;
                }
            }
            end++;
        }
        return  minString;
    
    }

    // check if all characters in t have equal or more characters in s
    public static boolean isAllCharactersOfTPresent( Map<Character, Integer> mapOfT, Map<Character, Integer> mapOfS)
    {
        for(Map.Entry<Character,Integer> entry : mapOfT.entrySet())
        {
            if( mapOfS.get(entry.getKey()) == null ||  mapOfS.get(entry.getKey()) < entry.getValue() ) 
                return false;
        }
        return true;
    }   
}
