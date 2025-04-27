import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int n = sc.nextInt();
        sc.nextLine(); // 개행 처리

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("1")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
            } else if (command.equals("2")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (command.equals("3")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("4")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("5")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
