import java.util.Scanner;

public class TempConverter
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double temp;
        double newTemp = 0;
        String currentUnit;
        String targetUnit;
        String tryAgain;

        do {
            System.out.print("Enter the temperature: ");

            while (!input.hasNextDouble())
            {
                System.out.print("Invalid input. Please enter a number.");
                input.nextLine();

                System.out.println();

                System.out.print("Enter the temperature: ");
            }

            temp = input.nextDouble();

            System.out.println("Enter the current unit (C, F, or K): ");
            currentUnit = input.next().toUpperCase();

                while (!currentUnit.equals("C") && !currentUnit.equals("F") && !currentUnit.equals("K"))
                {
                    System.out.print("\nInvalid input. Input C,F, or K only.");

                    System.out.print("Enter the current unit (C, F, or K): ");
                    currentUnit = input.next().toUpperCase();
                }

            System.out.print("Convert to Celsius, Fahrenheit, or Kelvin? (C, F, or K): ");
            targetUnit = input.next().toUpperCase();

            while (!targetUnit.equals("C") && !targetUnit.equals("F") && !targetUnit.equals("K"))
            {
                System.out.print("\nInvalid input. Input C, F, or K only.");

                System.out.print("Convert to Celsius, Fahrenheit, or Kelvin? (C, F, or K): ");
                targetUnit = input.next().toUpperCase();
            }

            newTemp = convertTemperature(temp, currentUnit, targetUnit);

            System.out.printf("Temperature: %.1f°%s%n", newTemp, targetUnit);

            System.out.print("\nDo you want to convert another temperature? (Y/N): ");
            tryAgain = input.next().toUpperCase();

            while (!tryAgain.equals("Y") && !tryAgain.equals("N"))
            {
                System.out.println("Invalid input. Please enter Y or N.");

                System.out.print("\nDo you want to convert another temperature? (Y/N): ");
                tryAgain = input.next().toUpperCase();
            }

        } while (tryAgain.equals("Y"));

        System.out.println("\nThank you for using the Temperature Converter.");

        input.close();
    }

    static double convertTemperature (double temp, String currentUnit, String targetUnit)
    {
        double newTemp;

        if (currentUnit.equals("C") && targetUnit.equals("F"))
        {
            newTemp = (temp * 9 / 5) + 32;
        }

        else if (currentUnit.equals("C") && targetUnit.equals("K"))
        {
            newTemp = temp + 273.15;
        }

        else if (currentUnit.equals("F") && targetUnit.equals("C"))
        {
            newTemp = (temp - 32) * 5 / 9;
        }

        else if (currentUnit.equals("F") && targetUnit.equals("K"))
        {
            newTemp = (temp - 32) * 5 / 9 + 273.15;
        }

        else if (currentUnit.equals("K") && targetUnit.equals("C"))
        {
            newTemp = temp - 273.15;
        }

        else if (currentUnit.equals("K") && targetUnit.equals("F"))
        {
            newTemp = (temp - 273.15) * 9 / 5 + 32;
        }

        else
        {
            newTemp = temp;
        }

        return newTemp;
    }
}