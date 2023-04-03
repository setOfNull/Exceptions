import java.util.*;

public class ExceptionCache {
    static List<String> operatorList = new ArrayList<>();
    static Map<String, String> loginPassword = new HashMap<>();


    //метод на преобразование в StringBuilder
    static String getCacheKey(int first, int second, String operation) {
        StringBuilder builder = new StringBuilder();
        builder.append(first);
        builder.append(operation);
        builder.append(second);
        return builder.toString();
    }

    //метод-исключение для проверки на наличие определенных операций
    static void checkOperator(String operator) {
        if (!operatorList.contains(operator))
            throw new InvalidOperationException("Invalid operator");
    }

    //метод-исключение для проверки аутентификации
    static void authenticationCheck(String login, String password) {
        if (!(loginPassword.containsKey(login) && loginPassword.containsValue(password)))
            throw new AuthenticationException("Login or Password is wrong");
    }

    //метод-исключение для проверки на существования пользователя
    static void loginCheck(String login) {
        if (!loginPassword.containsKey(login)) {
            throw new IllegalArgumentException("This user not found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");

        String str = "1.Operation check " + "\n" +
                "2.Login/Authentication check " + "\n";

    //Цикл с повтором программы
        for (int i = 0; i < 10; i++) {

            System.out.println("Choose: ");
            System.out.println(str);
            int user_choiсe = sc.nextInt();

    //1.Operation check
            if (user_choiсe == 1) {

                int total = 0;

    //Вводим наши данные
                System.out.println("Enter first number: ");
                int userFirst = sc.nextInt();
                System.out.println("Enter operation: ");
                String userOperation = sc.next();
                System.out.println("Enter second number: ");
                int userSecond = sc.nextInt();

    //Проверяем на правильность введения знака
                try {

    //if, проверяющий на наличие одинаковой операции. В случае уже существующей операции достает из кэша готовое решение
                    if (map.containsKey(getCacheKey(userFirst, userSecond, userOperation)) && map.containsValue(total)) {
                        System.out.println(map);
                    }
                    checkOperator(userOperation);

    //Осуществляем операции с учетом введенного пользователем знака
                    switch (userOperation) {
                        case "+":
                            total = userFirst + userSecond;
                            break;
                        case "-":
                            total = userFirst - userSecond;
                            break;
                        case "*":
                            total = userFirst * userSecond;
                            break;
                        case "/":
                            total = userFirst / userSecond;
                            break;
                    }
    //Закидываем в map key и value
                    map.put(getCacheKey(userFirst, userSecond, userOperation), total);

                    System.out.println(map);

                } catch (InvalidOperationException e) {
                    e.printStackTrace();
                }


    //2.Login/Authentication check
            } else if (user_choiсe == 2) {

    //Данные пользователей(логин и пароль)
                loginPassword.put("user1", "123");
                loginPassword.put("user2", "456");
                loginPassword.put("user3", "789");

                try {
                    System.out.println("Enter your login");
                    String userLogin = sc.next();
                    loginCheck(userLogin);
                    if (loginPassword.containsKey(userLogin)) {
                        try {
                            System.out.println("Enter your password");
                            String userPassword = sc.next();
                            authenticationCheck(userLogin, userPassword);
                            System.out.println("Authentication successful!");
                        } catch (AuthenticationException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("!Invalid choise!");
            }
        }
    }
}

