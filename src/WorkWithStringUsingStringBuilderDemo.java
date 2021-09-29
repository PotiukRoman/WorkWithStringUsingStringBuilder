public class WorkWithStringUsingStringBuilderDemo {

    static void show(StringBuilder stringBuilder){
        System.out.println(stringBuilder);
    }

    static String textTransformation(String text){
        StringBuilder inputSb=new StringBuilder(text);
        show(inputSb);
        deleteSpaces(inputSb);
        toUpperCaseEveryWord(inputSb);
        deleteBeginEndSpaces(inputSb);
        return inputSb.toString();
    }

    static void deleteSpaces(StringBuilder inputSb){
        int currentPosition = 0;
        int spacePosition = -1;

        for(int k=0;k<inputSb.length();k++){
            if(!Character.isWhitespace(inputSb.charAt(k))){
                inputSb.setCharAt(currentPosition++,inputSb.charAt(k));
                spacePosition=-1;

            } else if(spacePosition<0) {
                inputSb.setCharAt(currentPosition++,inputSb.charAt(k));
                spacePosition=k;
            }
        }
        inputSb.setLength(currentPosition);
    }

    static void deleteBeginEndSpaces(StringBuilder inputSb){
        if(Character.isWhitespace(inputSb.charAt(0))){
            inputSb.deleteCharAt(0);
        }
        if(Character.isWhitespace(inputSb.charAt(inputSb.length()-1))){
            inputSb.deleteCharAt(inputSb.length()-1);
        }

    }


    static void  toUpperCaseEveryWord(StringBuilder inputSb){
        int wordIsBegin = 0;

        for(int k=0;k<inputSb.length();k++){
            if( Character.isLetter(inputSb.charAt(k)) & wordIsBegin==0 ){
                inputSb.setCharAt(k,Character.toUpperCase(inputSb.charAt(k)));
                wordIsBegin=1;
            } else if(wordIsBegin==1 & Character.isLetter(inputSb.charAt(k))) {
                inputSb.setCharAt(k,Character.toLowerCase(inputSb.charAt(k)));
            }
            else {
                wordIsBegin = 0;
            }
        }
    }


    public static void main(String[] args) {
        String input="       onE    oF the biGGest REASONS why    Java is SO poPular is the platform     independence.     PROGRAMS can run on several different types   OF COMPUTER; as long as THE    computer    has a    JaVa RUNtime environment (jRE) installed, a jAVA program CAN run oN it. ";
        System.out.println(textTransformation(input));
    }
}
