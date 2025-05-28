# Students Grades Manager

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  
![Java](https://img.shields.io/badge/Java-Programming-red.svg) ![OOP](https://img.shields.io/badge/Object--Oriented%20Programming-green.svg)

## Features

- Register students with name, grades, and final average.
- Automatically calculates the average from given grades.
- Displays organized student information.
- Clean and modular code using separate classes.
- Simple and functional terminal interface.

## Technologies Used

- Java (JDK 17 or higher recommended)
- Gson (for JSON parsing)
- Terminal / Console

## 📦 How to Compile and Run

### Requirements

- Java JDK 17 or higher installed.
- [Gson library](https://github.com/google/gson) `.jar` file downloaded.

### 1. Clone the repository:

```bash
git clone https://github.com/lemavos/studentsGrades.git
cd studentsGrades
```

### 2. Download Gson

Download the JAR file (e.g., `gson-2.10.1.jar`) from:

> https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar

Place it in the project root or in a `lib/` folder.

### 3. Compile the Java files:

```bash
javac -cp gson-2.10.1.jar -d bin src/*.java
```

> If using a `lib/` folder:  
> `javac -cp lib/gson-2.10.1.jar -d bin src/*.java`

### 4. Run the program:

```bash
java -cp gson-2.10.1.jar:bin Main
```

> On Windows, replace `:` with `;`:
> ```bash
> java -cp gson-2.10.1.jar;bin Main
> ```

## Example Usage

```text
Welcome to the grade management system!

Enter student name: Maria
Enter grade 1: 8.5
Enter grade 2: 9.0
Enter grade 3: 7.0

Student: Maria
Grades: 8.5, 9.0, 7.0
Average: 8.16
Status: Passed
```

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
