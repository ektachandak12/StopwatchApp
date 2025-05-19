# ⏱️ StopwatchApp

A simple Java-based stopwatch application built with Swing that provides basic stopwatch functionalities with a graphical user interface.

---

## 🚀 Features

* **Start**: Begins timing from the last stopped time or from zero.
* **Stop**: Pauses the stopwatch without resetting the elapsed time.
* **Reset**: Clears all recorded time and lap history.
* **Lap**: Records intermediate times and displays them in a scrollable list.
* **Responsive UI**: Controls are dynamically enabled or disabled depending on stopwatch state.

---

## 🛠️ Technologies Used

* Java (JDK 8 or above)
* Swing for building the GUI

---

## 📦 Project Structure

```
StopwatchApp/
├── src/
│   └── StopwatchApp.java
├── manifest.txt
├── StopwatchApp.class
└── StopwatchApp.jar
```

---

## 🖥️ How to Compile and Run

### 🔧 Command Line:

1. Navigate to the `src` directory:

   ```bash
   cd src
   ```
2. Compile the source code:

   ```bash
   javac StopwatchApp.java
   ```
3. Create a `manifest.txt` file containing:

   ```
   Main-Class: StopwatchApp
   ```
4. Package the application into a JAR file:

   ```bash
   jar cfm StopwatchApp.jar manifest.txt StopwatchApp.class
   ```
5. Run the application:

   ```bash
   java -jar StopwatchApp.jar
   ```

### 🧠 Using IntelliJ IDEA:

1. Open the project in IntelliJ.
2. Go to **File > Project Structure > Artifacts**.
3. Click **+ > JAR > From modules with dependencies**.
4. Choose the main class: `StopwatchApp`
5. Apply and OK.
6. Go to **Build > Build Artifacts > Build**.
7. Find the JAR in the `out/artifacts` folder.

---

## 🧪 Compatibility

Tested with:

* Java 8, 11, 17
* Windows 10/11

---

## 📄 License

This application is open-source and available for personal and educational use.

---

## ✉️ Contact

For feedback or suggestions, please contact: `your.email@example.com`

---

> Created with 💙 using Java Swing
