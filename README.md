# Notepad Application

## Overview
This Notepad application is a simple text editor built using Java Swing. It provides basic text editing features such as opening, saving, and editing text files, as well as additional functionalities like bold, italic text formatting, and date/time insertion.

## Features
- Create, open, and save text files.
- Text formatting options: Bold and Italic.
- Date and time insertion.
- Word wrap functionality.
- Adjustable font styles and sizes.
- Zoom in and zoom out.

## Files

### 1. `Edit.java`
This file contains the `Edit` class which is responsible for text editing features such as:
- Inserting the current date and time.
- Applying bold and italic formatting to the selected text.

### 2. `File.java`
This file contains the `File` class which handles file operations such as:
- Creating a new file.
- Opening an existing file.
- Saving the current file.
- Saving the file with a new name (Save As).

### 3. `Format.java`
This file contains the `Format` class which provides text formatting functionalities:
- Enabling or disabling word wrap.
- Setting the font style (Arial, Comic Sans MS, Times New Roman).
- Setting the font size (e.g., 8, 12, 16, 20, 24, 28).
- Zooming in and out of the text area.

### 4. `GUI.java`
This file contains the `GUI` class which builds the graphical user interface of the Notepad application. It includes:
- Initialization of the main window and text area.
- Setup of the menu bar with options for File, Edit, Format, and Help.
- Action listeners for menu items to trigger corresponding functionalities.

## Installation
To run this Notepad application on your local machine, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/bilalkhantanoli/JAVA-PROJECT.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd JAVA-PROJECT
    ```

3. **Compile the Java files:**
    ```bash
    javac *.java
    ```

4. **Run the application:**
    ```bash
    java GUI
    ```

## Usage
1. **Creating a new file:**
    - Go to `File` -> `New` to create a new text file.

2. **Opening an existing file:**
    - Go to `File` -> `Open` to open an existing text file.

3. **Saving the current file:**
    - Go to `File` -> `Save` to save the current file.

4. **Saving the file with a new name (Save As):**
    - Go to `File` -> `Save As` to save the file with a new name.

5. **Applying bold or italic formatting:**
    - Select the text and go to `Edit` -> `Bold` or `Edit` -> `Italic`.

6. **Inserting the current date and time:**
    - Go to `Edit` -> `Insert Date/Time`.

7. **Enabling or disabling word wrap:**
    - Go to `Format` -> `Word Wrap`.

8. **Setting the font style and size:**
    - Go to `Format` -> `Font` to choose the font style and size.

9. **Zooming in and out:**
    - Go to `Format` -> `Zoom In` or `Format` -> `Zoom Out`.
