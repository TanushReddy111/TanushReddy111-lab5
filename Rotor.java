public class Rotor {

    
    private String rotorValues;
    private char startChar;
    // used to remember the initial ordering of rotor
    private final String originalValues; 
        
    public Rotor(String v, char c){
        this.originalValues = v;
        this.rotorValues = new String(v);
        this.startChar = c;
        
        // this will rotate until first character is startChar
        while (rotorValues.charAt(0) != startChar) {
            rotateOnce();
        }
    }
    // rotate one position of the rotor with this method
    private void rotateOnce() {
        int length = rotorValues.length();
        int last = length - 1;
        char lastChar = rotorValues.charAt(last);
        String allExceptLast = rotorValues.substring(0, last);
        rotorValues = lastChar + allExceptLast;
    }
    
    public boolean rotate(){
        //TODO
        // will rotate
        rotateOnce();
        boolean isReset = rotorValues.equals(originalValues);
        return isReset;
            
    }
    

    public int indexOf(char c){
        //TODO
        // this will find where a char is and return its position
        int pos = rotorValues.indexOf(c);
        return pos;
    }

    public char charAt(int idx){
        // Get the char at a position
        char result = rotorValues.charAt(idx);
        return result;
    }
}
    