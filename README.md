
# Quiz Application

## Overview
This application, developed in Java, is inspired by flashcard-based tools like Quizlet. It provides a quiz platform with customizable questions and multiple-choice answers. Users can easily add, delete, and manage quiz content through an intuitive graphical user interface, enhancing the application's flexibility and functionality.

## Key Features
- **Question Management**: Users can insert, remove, and store questions and answers.
- **Graphical User Interface (GUI)**: Built with the Swing library, the GUI offers a seamless, user-friendly experience that accommodates various technical backgrounds.
- **Object-Oriented Design**: Employs object-oriented principles to improve scalability and maintainability, allowing for efficient question creation and management.
- **Point System**: Tracks scores for each correct answer, enhancing the quiz experience.

## Intended Users
- **Students**: Ideal for students using the application as a digital flashcard tool to support memorization and study.
- **Teachers**: Useful for educators conducting multiple-choice quizzes to assess students.

## Project Inspiration
Flashcards have been instrumental throughout my academic journey, aiding in memorization and knowledge retention. My mother used to create handmade flashcards for me, making this project personally meaningful. By developing this app, I aim to leverage technology to accelerate the learning process and make studying more engaging.

## User Stories 
1. As a user, I want to add new questions.
2. As a user, I want to input multiple-choice answers for each question.
3. As a user, I want to view all questions and answers in the order they were entered.
4. As a user, I want to assign points to questions and track my score.
5. As a user, I want the app to evaluate my answers and track correct responses.
6. As a user, I want the flexibility to add an arbitrary number of questions.
7. As a user, I want to save and reload quiz data to continue from where I left off.

**Action Triggers**
- The "Insert Question" button in the Main Menu GUI allows users to add questions.
- The "Save" button saves the current application state, and the "Reload" button restores it.

## Logging System 
- **Delete Question**: Logs "Question is removed" when a question is deleted.
- **Insert Question**: Logs "Question is added" when a new question is added.
- **Quiz Start**: Logs "New question is shown in Start Quiz" whenever a question is displayed.
- **Correct Answer**: Logs "Total points for the quiz has increased, and answer input is correct."
- **Incorrect Answer**: Logs "Answer input is wrong."



This version provides a concise, professional overview of the Quiz Application and its functionality. Let me know if you need further adjustments!
