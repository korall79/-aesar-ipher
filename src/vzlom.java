class vzlom {
    private Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private char[] decodedText;
    private String[] plainText;
    private java.util.List<Character> alphabetList;
    public static void main(String[] args) {
        vzlom t = new vzlom();
        for (String pt : t.producePlaintext("bmjt")) {// сохраняем зашифрованный текс в перем pt
            System.out.println(pt);
        }
    }
        public void vzlom () {
            alphabetList = java.util.Arrays.asList(alphabet);
            plainText = new String[alphabet.length];
        }

        public String[] producePlaintext (String cipherText){
            //поместить каждую букву зашифрованного текста в массив символов в формате верхнего регистра
            char[] message = cipherText.toUpperCase().toCharArray();
            //перебрать все возможные ключи
            for (int key = 0; key < alphabet.length; key++) {
                //установить значение расшифрованного массива символов таким же, как длина зашифрованного текста
                decodedText = new char[message.length];

                for (int i = 0; i < message.length; i++) {//перебирать символы зашифрованного текста

                    if (message[i] != ' ') {//если символ не пробел

                        decodedText[i] = alphabet[(alphabetList.indexOf(message[i]) + key) % alphabet.length];//переставить буквы
                    } else {
                        decodedText[i] = ' ';
                    }
                }
                plainText[key] = String.valueOf(decodedText);
            }
            return plainText;
        }

}
