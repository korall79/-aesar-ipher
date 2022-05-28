import java.util.Scanner;

public class ShifrCezaria {
    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите путь к файлу:");//C:\Users\User\IdeaProjects\ProgectModul1\out\production\ProgectModul1\secret
        Scanner console =new Scanner(System.in);
        String file= console.nextLine();
        System.out.println("Пожалуйста, введите ключ:");
        Scanner console1=new Scanner(System.in);
        int key=console1.nextInt();
    }
}
