# Memories Management Console App

The Memories Management Console App is a Java-based application designed to manage and organize memories. It allows users to add, update, delete, and view memories. The app provides a simple text-based interface for users while demonstrating best practices in object-oriented programming, file handling, and testing.

---

### Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [How It Works](#how-it-works)
- [Setup](#setup)
- [Usage](#usage)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [License](#license)

---

### Features

- **View Memories**: Retrieve a list of memories, filtered by public or private status.
- **Add a Memory**: Create a new memory with attributes such as sender, content, and shareability.
- **Update a Memory**: Edit the details of an existing memory.
- **Delete a Memory**: Remove a memory by its ID.
- **Validation**: Ensures input constraints are followed, such as mandatory fields for "from" and "content."

---

### Technologies

- **Java**: Core language for implementation.
- **Spring Framework**: Provides dependency injection for managing application components.
- **JUnit**: Used for creating and running unit tests.
- **Maven**: Manages project dependencies and build lifecycle.
- **File I/O**: Handles data storage in text files with serialization and deserialization.

---

### How It Works

1. **Controller**: Coordinates interactions between the view and service layers.
2. **Service Layer**: Handles business logic and validation for operations on memories.
3. **Repository Layer**: Manages file-based data persistence for storing and retrieving memories.
4. **Model Layer**: Defines the structure of a memory, including its attributes.
5. **View Layer**: Provides a text-based console interface for user interaction.

---

### Setup

### Prerequisites

- **Java JDK** (17 or later)
- **Maven** for dependency management
- A terminal or IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository.
    ```bash
    git clone https://github.com/Forestbriggs/memories.git
    cd memories
    ```
2. Build the project using Maven.
    ```bash
    mvn clean install
    ```
3. Run the application.
    ```bash
    mvn exec:java -Dexec.mainClass="learn.memories.App"
    ```

---

### Usage

Navigate the text-based menu with the following options:

1. **View Memories**  
   View a list of memories, filtered by public or private status.

2. **Add a Memory**  
   Create a new memory by specifying the sender, content, and whether it is shareable.

3. **Update a Memory**  
   Edit the details of an existing memory by selecting its ID.

4. **Delete a Memory**  
   Remove a memory by selecting its ID.

5. **Exit**  
   Exit the application.

---

### Testing

Unit tests have been implemented using **JUnit** to ensure application stability and reliability. The tests cover:

1. **Service Layer**: Validates business logic and ensures proper error handling for invalid inputs.
2. **Repository Layer**: Confirms correct file operations, such as adding, updating, and deleting memories.
3. **Integration Testing**: Verifies the complete workflow from user input to file storage.

### Running Tests
```bash
mvn test
```

---

### Future Enhancements

- **Database Integration**: Replace file-based storage with a database for scalability.
- **Search Functionality**: Allow users to search memories by keywords or sender.
- **Categorization**: Enable tagging or categorizing memories for better organization.

---

### License

This project is licensed under the MIT License. Feel free to use, modify, and distribute the application as needed.
