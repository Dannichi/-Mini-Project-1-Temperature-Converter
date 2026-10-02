import java.util.Scanner;

public class TempConverter
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            do
            {
                double temp = getValidTemp(input);

                System.out.print("\nEnter the current unit: ");
                String currentUnit = getValidUnit(input);

                //Rejects if the temperature below absolute zero
                if(toCelsius(temp, currentUnit) < -273.15)
                {
                    System.out.println("That is an absolute zero. Try again.\n");
                    continue; // jumps the loop condition
                }

                System.out.printf("%nCurrent temperature: %.1f°%s%n", temp, currentUnit);

                System.out.print("\nEnter the target unit (C, F, K): ");
                String targetUnit = getValidUnit(input);

                double newTemp = convertTemp(temp, currentUnit, targetUnit);

                System.out.printf("%nTemperature: %.1f°%s = %.1f°%s%n", temp, currentUnit, newTemp, targetUnit);


            } while (choice(input, "\nConvert another temperature (Y/N): "));

            System.out.println("Thank you for using the Temperature Converter!");
        }
    }

    static double getValidTemp(Scanner input)
    {
        System.out.print("Enter the temperature: ");

        while (!input.hasNextDouble())
        {
            System.out.println("Invalid Input. Please enter a number.");
            input.next(); // Throws away the wrong input from the "Enter the temperature" to avoid infinite loop from the while loop and the user can type again an input.

            System.out.print("\nEnter the temperature: ");
        }
        return input.nextDouble();
    }

    static String getValidUnit(Scanner input)
    {
        System.out.print("Enter unit (C, F, or K): ");
        String unit = input.next().toUpperCase();

        while (!unit.equals("C") && !unit.equals("F") && !unit.equals("K"))
        {
            System.out.println("Invalid input. Please input C, F, or K only.");
            System.out.print("Enter unit (C, F, K): ");
            unit = input.next().toUpperCase();
        }
        return unit;
    }

    static boolean choice(Scanner input, String prompt)
    {
        System.out.print(prompt);
        String answer = input.next().toUpperCase();

        while (!answer.equals("Y") && !answer.equals("N"))
        {
            System.out.println("Invalid Input. Please enter Y or N only.");
            System.out.print(prompt);
            answer = input.next().toUpperCase();
        }
        return answer.equals("Y");
    }

    static double toCelsius(double temp, String unit)
    {
        return switch (unit)
        {
            case "F" -> (temp - 32) * 5 / 9;
            case "K" -> temp - 273.15;
            default  -> temp;
        };
    }

    static double fromCelsius(double celsius, String unit)
    {
        return switch (unit)
        {
            case "F" -> celsius * 9 / 5 + 32;
            case "K" -> celsius + 273.15;
            default  -> celsius;
        };
    }

    static double convertTemp(double temp, String from, String to  )
    {
        return fromCelsius(toCelsius(temp, from), to);
    }
}