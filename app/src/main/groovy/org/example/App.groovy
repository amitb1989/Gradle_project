package org.example

class App {
    String getGreeting() {
        return 'Hello World!'
    }

    static void main(String[] args) {
        println new App().greeting

        // Read properties from Gradle for calculation
        def num1 = System.getProperty("num1", "0").toBigDecimal()
        def num2 = System.getProperty("num2", "0").toBigDecimal()
        def operation = System.getProperty("operation", "add")

        try {
            def result
            switch (operation) {
                case "add": result = num1 + num2; break
                case "subtract": result = num1 - num2; break
                case "multiply": result = num1 * num2; break
                case "divide":
                    if (num2 == 0) {
                        println "Error: Division by zero is not allowed!"
                        return
                    }
                    result = num1 / num2
                    break
                default:
                    println "Invalid operation! Use: add, subtract, multiply, divide."
                    return
            }

            println "Result of $num1 $operation $num2 = $result"
        } catch (Exception e) {
            println "Oops! Invalid number format. Please enter valid numbers."
        }
    }
}
