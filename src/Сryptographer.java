import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Сryptographer {
    public static void main(String[] args) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\User\\IdeaProjects\\ProgectModul1\\out\\production\\ProgectModul1\\secret", "rw");
             FileChannel channel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            StringBuilder builder = new StringBuilder();
            channel.read(byteBuffer);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());
            }
            System.out.println(builder);

            int key = 3;

            char[] simvol = new char[builder.length()];
            for (int i = 0; i < builder.length(); i++) {
                if (Character.isLetter(builder.charAt(i)) && Character.isUpperCase(builder.charAt(i))) {
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 65 + key) % 26) + 65);
                } else if (Character.isLetter(builder.charAt(i)) && Character.isLowerCase(builder.charAt(i)))
                    simvol[i] = (char) (((((int) (builder.charAt(i))) - 97 + key) % 26) + 97);
                else simvol[i]= builder.charAt(i);
            }

            System.out.println(simvol);
            String encrypted = String.copyValueOf(simvol);

            ByteBuffer byteBuffer1 = ByteBuffer.wrap(encrypted.getBytes());
            channel.write(byteBuffer1);
            System.out.println();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
