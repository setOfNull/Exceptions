import java.util.*;

public class ExceptionCache  {
    static List <String> operatorList = new ArrayList<>();
    static String getCacheKey(int first, int second, String operation){
        StringBuilder builder = new StringBuilder();
        builder.append(first);
        builder.append(operation);
        builder.append(second);
        return builder.toString();
    }

    static void checkOperator(String operator){
        if (!operatorList.contains(operator))
            throw new InvalidOperationException("Operator not found");
    }

//    static void authetificationCheck(Map <String, String> loginPassword){
//        if(!loginPassword.containsKey(String login))
//    }


    public static void main(String[] args) {
        Map <String, Integer> map = new HashMap<>();
        Map <String, String> loginPassword = new HashMap<>();

        loginPassword.put("user1", "123");
        loginPassword.put("user2", "456");
        loginPassword.put("user3", "789");


        for (int i=0; i<100; i++){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter first number: ");
                int userFirst = sc.nextInt();
                System.out.println("Enter operation: ");
                String userOperation = sc.next();
                System.out.println("Enter second number: ");
                int userSecond = sc.nextInt();
            }catch (InvalidOperationException e){
                System.out.println(e.getMessage());
                e.getStackTrace();
            }



            int total = 0;

//            if (map.containsKey(getCacheKey(userFirst, userSecond, userOperation))&& map.containsValue(total)){
//                System.out.println(map);
//            }
//
//            operatorList.add("+");
//            operatorList.add("-");
//            operatorList.add("*");
//            operatorList.add("/");
//
//            if (userOperation.equals("+")){
//                total = userFirst + userSecond;
//            } else if (userOperation.equals("-")) {
//                total = userFirst - userSecond;
//            } else if (userOperation.equals("*")) {
//                total = userFirst * userSecond;
//            } else if (userOperation.equals("/")) {
//                total =  userFirst / userSecond;
//            }




//            map.put(getCacheKey(userFirst, userSecond, userOperation), total);

            System.out.println(map);


        }




    }
}
//notFoundException

