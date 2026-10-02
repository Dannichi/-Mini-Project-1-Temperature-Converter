# Temperature Converter

A Java console program that converts temperatures between Celsius, Fahrenheit, and Kelvin.

## Features
- Converts between Celsius (C), Fahrenheit (F), and Kelvin (K)
- Input validation (rejects letters, invalid units, and invalid Y/N answers)
- Rejects temperatures below absolute zero
- Reusable methods instead of repeated code

## How It Works

Instead of writing a formula for every pair of units, every conversion goes through Celsius:

```
Fahrenheit ──► Celsius ──► Kelvin
```

- `toCelsius` converts any unit to Celsius
- `fromCelsius` converts Celsius to any unit
- `convertTemperature` combines both

## Sample Output

### Normal conversion
```
Enter the temperature: 100

Enter the current unit: 
Enter unit (C, F, or K): c

Current temperature: 100.0°C

Enter the target unit (C, F, K): 
Enter unit (C, F, or K): f

Temperature: 100.0°C = 212.0°F

Convert another temperature (Y/N): n
Thank you for using the Temperature Converter!
```

### Invalid input handling
```
Enter the temperature: abc
Invalid Input. Please enter a number.

Enter the temperature: 100

Enter the current unit: 
Enter unit (C, F, or K): 123
Invalid input. Please input C, F, or K only.

Enter unit (C, F, K): c

Current temperature: 100.0°C

Enter the target unit (C, F, K): 
Enter unit (C, F, or K): abc
Invalid input. Please input C, F, or K only.

Enter unit (C, F, K): f

Temperature: 100.0°C = 212.0°F

Convert another temperature (Y/N): n
Thank you for using the Temperature Converter!
```

## Test Examples

| Input     | Expected Output |
|-----------|-----------------|
| 100°C → F |     212.0°F     |
| 32°F →  C |     0.0°C       |
| 212°F → K |     373.2 K     |

## How to Run

```
javac TempConverter.java
java TempConverter
```

## What I Learned
- Writing methods with parameters, new algorithm, and return values
- Using `while` and `do-while` loops for input validation
- Using `enhanced switch` expressions
- Breaking a big program into small, reusable pieces
