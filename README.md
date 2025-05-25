# SeleniumCucumberGeneric 🚀

A scalable, modular, and reusable Selenium framework using Java, Cucumber, and TestNG designed for web automation testing. This project supports parallel execution and easy test data management using JSON, making it adaptable for real-world enterprise testing needs.

---

## 🔧 Tools & Technologies Used

| Tool/Library     | Purpose                                         |
|------------------|--------------------------------------------------|
| **Java**         | Core programming language                        |
| **Selenium WebDriver** | Browser automation framework             |
| **Cucumber (BDD)** | Behavior-driven development, feature files     |
| **TestNG**       | Test runner, parallel execution support          |
| **Maven**        | Build automation and dependency management       |
| **JSON**         | Test data management                             |
| **ThreadLocal**  | Thread-safe WebDriver for parallel testing       |
| **GitHub Actions (Optional)** | CI/CD support (if integrated)    |

---

## ✅ Key Features & Benefits

- 🧩 **Modular Framework Design**: Page Object Model (POM) for code reuse and maintainability.
- 🧪 **Parallel Execution**: Thread-safe driver management using `ThreadLocal` to run tests concurrently via TestNG.
- 🧾 **Data-Driven Testing**: Easily inject test data per scenario using external JSON files.
- 🛠️ **Hooks for Setup/Teardown**: Manages browser lifecycle and test data initialization cleanly.
- 🗂️ **Dynamic Test Data Loader**: Loads test data based on scenario names automatically.
- 📜 **Readable Feature Files**: Human-readable test cases using Gherkin syntax.
- 🧼 **Scalable & Maintainable**: Easy to extend with more test cases, browsers, and environments.

---

## 🗂️ Project Structure

```
SeleniumCucumberGeneric/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── hooks/            # Cucumber Hooks (Before, After)
│       │   ├── runner/           # Cucumber + TestNG Runner
│       │   ├── stepDefinitions/  # Step bindings
│       │   ├── utils/            # DriverFactory, TestDataLoader, etc.
│       └── resources/
│           ├── features/         # .feature files
│           └── testdata/         # JSON test data
├── testng.xml                    # TestNG suite for parallel execution
├── pom.xml                       # Maven dependencies
```

---

## ▶️ How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/theshoaibshaikh/SeleniumCucumberGeneric.git
   cd SeleniumCucumberGeneric
   ```

2. **Run tests via TestNG**
   ```bash
   mvn clean test
   ```

   Or directly from **IntelliJ** or **Eclipse** by right-clicking on `testng.xml` and choosing _Run_.

---

## 📌 Notes

- ✅ Ensure ChromeDriver is configured in your system's PATH or set via WebDriverManager.
- 🔄 You can extend support for other browsers by modifying `DriverFactory`.

---

## 🙌 Contributions

PRs and suggestions are welcome! Fork the repo, create a feature branch, and submit your pull request. Let's collaborate and make automation better!

---

## 📃 License

This project is licensed under the [MIT License](LICENSE).
