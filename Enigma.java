public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        StringBuilder result = new StringBuilder();
        int i = 0;
        int len = message.length();
        while (i < len) {
            char ch = message.charAt(i);

            int id1 = rotors[2].indexOf(ch);
            char ch1 = rotors[1].charAt(id1);

            int id2 = rotors[2].indexOf(ch1);
            char ch2 = rotors[0].charAt(id2);

            result.append(ch2);

            rotate();
            i = i + 1;
        }
        String decrypted = result.toString();
        return decrypted;
    }


    
    public String encrypt(String message){
        //TODO
        StringBuilder result = new StringBuilder();
        int i = 0;
        int len = message.length();
        while (i < len) {
            char ch = message.charAt(i);

            int id1 = rotors[0].indexOf(ch);
            char ch1 = rotors[2].charAt(id1);

            int id2 = rotors[1].indexOf(ch1);
            char ch2 = rotors[2].charAt(id2);

            result.append(ch2);

            rotate();
            i = i + 1;
        }
        String encrypted = result.toString();
        return encrypted;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}