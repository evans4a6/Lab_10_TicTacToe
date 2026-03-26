import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args) {

    }

   // NONZERO-STRING
    // NONZERO-STRING
    // NONZERO-STRING


    /**
     * A method that gets a non-zero length string from the user.
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    // GET-INT
    // GET-INT
    // GET-INT


    /**
     * A method that gets an integer from the user.
     * @param pipe Scanner to read the integer.
     * @param prompt Prompt to show the user.
     * @return an integer value from the user.
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        int val = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);
            }
        }while(!done);
        return val;
    }

    // GET-DOUBLE
    // GET-DOUBLE
    // GET-DOUBLE


    /**
     * A method that gets a double from the user.
     * @param pipe Scanner to read the double.
     * @param prompt Prompt to show the user.
     * @return a double value from the user.
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        double val = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
            {
                val = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
            }
        }while(!done);
        return val;
    }

    // GET-RANGED_INTEGER
    // GET-RANGED_INTEGER
    // GET-RANGED_INTEGER


    /**
     * A method that gets a ranged integer from the user.
     * @param pipe Scanner to read the ranged integer.
     * @param prompt Prompt to show the user.
     * @param low low bound of the range.
     * @param high high bound of the range
     * @return a ranged integer value from the user.
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        int val = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();
                if (val >= low && val <= high)
                    done = true;
                else
                {
                    System.out.println("The integer must be between " + low + " and " + high);
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);
            }
        }while(!done);
        return val;
    }


    // GET-RANGED_DOUBLE
    // GET-RANGED_DOUBLE
    // GET-RANGED_DOUBLE


    /**
     * A method that gets a ranged double from the user.
     *
     * @param pipe   Scanner to read the ranged double.
     * @param prompt Prompt to show the user.
     * @param low    low bound of the range.
     * @param high   high bound of the range
     * @return a ranged double value from the user.
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        double val = 0;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                val = pipe.nextDouble();
                pipe.nextLine();
                if (val >= low && val <= high)
                    done = true;
                else {
                    System.out.println("The double must be between " + low + " and " + high);
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
            }
        } while (!done);
        return val;
    }


    // GET Y/N
    // GET Y/N
    // GET Y/N


    /**
     * A method that gets a true or false from the user.
     *
     * @param pipe Scanner to read the boolean.
     * @param prompt Prompt to show the user.
     * @return a true or false value from the user.
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {


        boolean done = false;

        String val = "";
        do {
            System.out.print(prompt + " [Y/N]: ");
            val = pipe.nextLine();
            if (val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("Enter Y or N");
            }
        } while (!done);
        return val.equalsIgnoreCase("Y");
    }


    // GET REGEX STRING
    // GET REGEX STRING
    // GET REGEX STRING


    /**
     * A method that gets a regular expression from the user.
     *
     * @param pipe Scanner to read the regEx.
     * @param prompt Prompt to show the user.
     * @return a regEx value from the user.
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;

        String val = "";
        do {
            System.out.print(prompt + ": ");
            val = pipe.nextLine();
            if (val.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("The value must match the pattern: " + regEx + ", Not: " + val);
            }
        } while (!done);
        return val;
    }


    // BORDER
    // BORDER
    // BORDER


    /**
     * A method that gets a puts a message from the user into a pretty header.
     * @param msg gets the message from the user
     * @return a pretty header with the message from the user.
     */
    public static void prettyHeader(String msg)
    {

        int width = 60;

        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();
        int msgLength = msg.length();
        int totalSpaces = width - 6 - msgLength;
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        System.out.print("***");

        for (int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);

        for (int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.print("***");

        System.out.println();
        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();

    }
}