# Project Tasks

All tasks are located in the **/src** directory.

---

## **Week 1 Tasks**

### **Code Quality Guidelines:**
- Use proper and specific variable names.
- Apply appropriate naming conventions:
  - **Class Names:** `PascalCase`
  - **Variable Names:** `camelCase`
  - **Constants:** `NAMED_CONSTANTS`
- Maintain proper code formatting.
- Add useful comment blocks before complex logic.
- Use `final` and `static` string variables in print statements instead of string literals.
- Ensure there are no warnings (e.g., unused imports, unused variables).

---

### **1. Object-Oriented Programming (OOPS):**
- **Car Class:** Encapsulates properties (make, model, year) with private variables and public getters/setters. Includes `startEngine()` method.
- **ElectricCar Subclass:** Inherits from `Car`, adds `batteryRange` property, and `chargeBattery()` method.
- **Polymorphism:** Demonstrates polymorphism with an array of `Car` and `ElectricCar` objects, invoking `startEngine()` for each.

### **2. Arithmetic Program:**
- **Division Program:** Divides two numbers and prints the remainder and quotient using only `+` and `-` operators.

---

### **3. Exception Handling:**
- **processInput() Method:** Reads numerical input, calculates the reciprocal, and handles exceptions for invalid inputs (non-numeric, division by zero).

---

### **4. Final Keyword Demonstration:**
- Program demonstrating `final` with variables, methods, and classes to observe its effects.

---

### **5. Abstraction and Interface Basics:**
- **Animal Abstract Class:** Defines `makeSound()` method.
- **Dog Subclass:** Overrides `makeSound()` to indicate barking.

---

### **6. Primitive and Reference Variables:**
- Program passing an integer (primitive) and an array (reference) to a method, modifying them, and observing behavior after method execution.

---

### **7. Enum Demonstration:**
- Program using `DaysOfWeek` enum to print "Holiday" or "Not Holiday" based on the day of the week.

---

### **8. Factorial Trailing Zeroes:**
- Program to find all trailing zeroes in the factorial of a given number.

---

### **9. Utility Package:**
- Utility method to find the length of an integer, accessible without creating an object.

---

### **10. Object Class Methods:**
- **User & SecondUser Classes:**
  - Same variables (name, age).
  - Getters, setters, constructors.
  - `User` class overrides `toString()`, `hashCode()`, and `equals()`.
  - Demonstrates behavior with and without overridden methods.

---

### **11. String Handling:**
- **StringProcessor Class:**
  - `reverseString(String str)`: Reverses the string.
  - `countOccurrences(String text, String sub)`: Counts occurrences of `sub` in `text`.
  - `splitAndCapitalize(String str)`: Splits the string by spaces and capitalizes each word.

---

### **12. Finding All Anagrams in a String:**
- **findAnagrams(String s, String p):** Returns a list of starting indices of all anagrams of `p` in `s`.

---

## **Project Structure:**
```
/src
├── oops
├── exception_handling
├── final_keyword
├── abstraction_interface
├── primitive_reference
├── enums
├── factorial_trailing_zeroes
├── utility
├── object_class
├── string_handling
└── anagrams
```

---

## **How to Run:**
1. Clone the repository:
   ```bash
   git clone https://github.com/muthumeenal12/Java_FullStack
   ```
2. Navigate to the project folder:
   ```bash
   cd https://github.com/muthumeenal12/Java_FullStack/tree/main/Tasks/src
   ```
3. Compile and run the desired program:
   ```bash
   javac ClassName.java
   java ClassName
   ```

