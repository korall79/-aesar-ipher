//class vzlom {
//    private Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//    private char[] decodedText;
//    private String[] plainText;
//    private java.util.List<Character> alphabetList;
//    public static void main(String[] args) {
//        Test01 t = new Test01();
//        for (String pt : t.producePlaintext("abc")) {
//            System.out.println(pt);
//        }
//    }
//        public void Test01 () {
//            alphabetList = java.util.Arrays.asList(alphabet);
//            plainText = new String[alphabet.length];
//        }
//
//        public String[] producePlaintext (String cipherText){
//            //поместить каждую букву зашифрованного текста в массив символов в формате верхнего регистра
//            char[] message = cipherText.toUpperCase().toCharArray();
//            //перебрать все возможные ключи
//            for (int key = 0; key < alphabet.length; key++) {
//                //установить значение расшифрованного массива символов таким же, как длина зашифрованного текста
//                decodedText = new char[message.length];
//                //перебирать символы зашифрованного текста
//                for (int i = 0; i < message.length; i++) {
//
//                    //если символ не пробел
//                    if (message[i] != ' ') {
//                        //переставить буквы
//                        decodedText[i] = alphabet[(alphabetList.indexOf(message[i]) + key) % alphabet.length];
//                    } else {
//                        decodedText[i] = ' ';
//                    }
//                }
//                plainText[key] = String.valueOf(decodedText);
//            }
//            return plainText;
//        }
//
//}
