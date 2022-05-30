class vzlom {
    private Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] decodedText;
    private String[] plainText;
    private java.util.List<Character> alphabetList;

        public  vzlom () {
            alphabetList = java.util.Arrays.asList(alphabet);
            plainText = new String[alphabet.length];
        }

        public String[] producePlaintext (String cipherText){

            char[] message = cipherText.toUpperCase().toCharArray();//поместить каждую букву зашифрованного текста в массив символов в формате верхнего регистра

            for (int key = 0; key < alphabet.length; key++) {   //перебрать все возможные ключи

                decodedText = new char[message.length];//установить значение расшифрованного массива символов таким же, как длина зашифрованного текста

                for (int i = 0; i < message.length; i++) {  //перебирать символы зашифрованного текста


                    if (message[i] != ' ') {        //если символ не пробел

                        decodedText[i] = alphabet[(alphabetList.indexOf(message[i]) + key) % alphabet.length];//переставить буквы
                    } else {
                        decodedText[i] = ' ';
                    }
                }
                plainText[key] = String.valueOf(decodedText);
            }
            return plainText;
        }
    public static void main(String[] args) {
        vzlom t = new vzlom();
        for (String pt : t.producePlaintext("bmjt")) {//сохраняем в переменную pt зашифрованный текст
            System.out.println(pt);
        }
    }
}
