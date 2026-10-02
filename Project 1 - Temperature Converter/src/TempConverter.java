import java.util.Scanner;

public class TempConverter
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            do
            {
                double temp = getValidTemperature(input);

                System.out.println("\nEnter the current unit:");
                String currentUnit = getValidUnit(input);

                // Reject temperatures below absolute zero
                if (toCelsius(temp, currentUnit) < -273.15)
                {
                    System.out.println("That is below absolute zero. Try again.\n");
                    continue; // jumps to the loop condition (see note below)
                }

                System.out.printf("%nCurrent temperature: %.1f°%s%n", temp, currentUnit);

                System.out.println("\nEnter the target unit:");
                String targetUnit = getValidUnit(input);

                double newTemp = convertTemperature(temp, currentUnit, targetUnit);

                System.out.printf("%n%.1f°%s = %.1f°%s%n",
                        temp, currentUnit, newTemp, targetUnit);

            } while (askYesNo(input, "\nConvert another temperature? (Y/N): "));

            System.out.println("\nThank you for using the Temperature Converter.");
        }
    }

    static double getValidTemperature(Scanner input)
    {
        System.out.print("Enter the temperature: ");
        while (!input.hasNextDouble())
        {
            System.out.println("Invalid input. Please enter a number.");
            input.next(); // discard the bad token
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
            System.out.println("Invalid input. Please enter C, F, or K.");
            System.out.print("Enter unit (C, F, or K): ");
            unit = input.next().toUpperCase();
        }
        return unit;
    }

    static boolean askYesNo(Scanner input, String prompt)
    {
        System.out.print(prompt);
        String answer = input.next().toUpperCase();

        while (!answer.equals("Y") && !answer.equals("N"))
        {
            System.out.println("Invalid input. Please enter Y or N.");
            System.out.print(prompt);
            answer = input.next().toUpperCase();
        }
        return answer.equals("Y");
    }

    // Step 1: any unit -> Celsius
    static double toCelsius(double temp, String unit)
    {
        return switch (unit)
        {
            case "F" -> (temp - 32) * 5 / 9;
            case "K" -> temp - 273.15;
            default  -> temp;
        };
    }

    // Step 2: Celsius -> any unit
    static double fromCelsius(double celsius, String unit)
    {
        return switch (unit)
        {
            case "F" -> celsius * 9 / 5 + 32;
            case "K" -> celsius + 273.15;
            default  -> celsius;
        };
    }

    static double convertTemperature(double temp, String from, String to)
    {
        return fromCelsius(toCelsius(temp, from), to);
    }
}