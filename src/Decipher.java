import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

 class Decipher {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\User\\IdeaProjects\\ProgectModul1\\ciphr2.txt", "rw");
             FileChannel channel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            StringBuilder builder = new StringBuilder();
            channel.read(byteBuffer);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());
            }
            System.out.println("Text after encrypt:"+builder);

            int key = 1;

            char[] simvol = new char[builder.length()];
            for (int i = 0; i < builder.length(); i++) {
                if (Character.isLetter(builder.charAt(i)) && Character.isUpperCase(builder.charAt(i))) {
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 65 - key) % 26) + 65);
                } else if (Character.isLetter(builder.charAt(i)) && Character.isLowerCase(builder.charAt(i)))
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 97 - key) % 26) + 97);
                else simvol[i]= builder.charAt(i);
            }


            String encrypted = String.copyValueOf(simvol);
            System.out.println("text after decoding:"+encrypted);


            Path filepath = Paths.get("Deciphr.txt");
            Files.createFile(filepath);
            Files.write(filepath, encrypted.getBytes());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


