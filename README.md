# BookWise
This app is a library console application implemented in Java, intended as a project for an advanced object-oriented programming course. The application provides full functionality for managing a library, including adding, removing, and searching for books, light novels, and games, calculating reader's budgets and searching for authors based on different criteria.

The project implements all the OOP concepts in Java: Inheritance, Polymorphism, Encapsulation and Abstraction.
It has 2 abstract classes, which serve as the base classes for 5 others: Reader, Author, Book, LightNovel and Game. Furthermore, the app implements exception handling to deal with invalid input from the user. Whenever the user enters an invalid input, the application throws an exception, which is caught by the appropriate catch block.

For example, when the user chooses to increase a reeader's budget, the application checks whether the input is a higher than 0. If it is not, an IllegalArgumentException with a custom error message is thrown, and the user is prompted to enter a valid number. The app avoids invalid input altogether.

While the other objects are kept in Array Lists, the authors are represented as a priority queue, sorted by the number of awards they have won.

Functionality
BookWise offers the following functionalities:

Adding a new product - book, light novel, or game

Removing an existing product

Searching for authors by nationality

Listing all products, readers, sections and authors in the library

Adding a new author

Testing how much money readers need in their account in order to buy certain products

Buying products for readers

Calculating total number of awards that authors have won

A super secret option that will tell you something about your future



Usage
To use the BookWise, simply download the source code and compile it using your favorite Java compiler.
