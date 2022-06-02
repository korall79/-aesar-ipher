import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cipher {
    public static void main(String[] args) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\User\\IdeaProjects\\ProgectModul1\\out\\production\\ProgectModul1\\secret", "r");
             FileChannel channel = randomAccessFile.getChannel()) {     //создаем канал и добавляем файл

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());//создаем буфер размером канала
            StringBuilder builder = new StringBuilder();        //создаем обьект
            channel.read(byteBuffer);//читаем из канала в буфер
            byteBuffer.flip();//делаем куввырок на запись

            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());//пока в буфере что то есть добавляем в билдер
            }
            System.out.println("Text before encrypt:"+ builder);

            int key = 1;// задаем ключ

            char[] simvol = new char[builder.length()];// в массив запихиваем в параметр длину переданного файла
            for (int i = 0; i < builder.length(); i++) {
                if (Character.isLetter(builder.charAt(i)) && Character.isUpperCase(builder.charAt(i))) {
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 65 + key) % 26) + 65);
                } else if (Character.isLetter(builder.charAt(i)) && Character.isLowerCase(builder.charAt(i)))
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 97 + key) % 26) + 97);
                else simvol[i]= builder.charAt(i);
            }


            String encrypted = String.copyValueOf(simvol);// копируем все символы чар в строку
            System.out.println("Text after encrypt:"+encrypted);


            Path filepath = Paths.get("ciphr2.txt");// в файлпаф добавляем путь
            Files.createFile(filepath);//Создаем новый файл с путем path
            Files.write(filepath, encrypted.getBytes());//записываем защифр файл


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}