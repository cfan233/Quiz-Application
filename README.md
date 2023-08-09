# Quiz App


## Application Description
The application is very similar to that of quizlet with the function of 1 question and 4 answers.
Users can insert and delete questions and answers the corresponding list.




## Who will use it?
Students can use it for memorization using it as a flash card. Teaching staffs could use this asa
a quiz app for multiple choices.


## Why is this project of interest to you?
The idea of flashcards has helped me through the 13 years of my education.
My mother used to make hand made flash cards so that I can remember school work.
The project offers the opportunity for me to use technology to speed up the
learning process.




## UserStory phase 3:
- As a user I want to insert new questions
- As a user I want to insert answers
- As a user I want to show all questions in the order it is entered
- As a user I want to show all answers to the questions in the order it is entered
- As a user I want to show all assigned points to the questions in the order it is entered
- As a user I want to add a point system
- As a user I want to be able to let the system determine if I got the correct answer
- As a user I want to be able to insert arbitrary amount of questions
- As a user I want to save questions and its corresponding answers and associated points entered previously
- As a user I want to load questions and its corresponding answers and associated points entered previously
- You can generate the first required action related to adding Xs to a Y by insert question button in MainMenuGui
- You can generate the second required action related to adding Xs to a Y by insert question button in MainMenuGui
- You can locate my visual component by inserting a question that fits the insert question requirement, when answering 
a question correctly or falsely
- You can save the state of my application by clicking on the save button in MainGui
- You can reload the state of my application by clicking on the reload button in MainGui

## Phase 4: Task 2:
- Delete question logs "Question is removed".
- Insert Question logs "Question is added".
- Start Quiz Logs "Quiz is running".
- When points are shown "Points are added or assigned points are shown".
- When questions has been shown "Points are added or assigned points are shown".
- When answers has been shown "Points are added or assigned points are shown".
- Due to the design choice problems, the log events do show duplicates as I had to implement the for loop in the ui 
package. Instead of laying out the logic in the model, I have used getters in the model to implement the behaviour for 
the project which can be improved in the future.

## Phase 4: Task 3:
- Refactoring:
- i. As mentioned in task2, the logic could be improved if the methods could be implemented in model instead 
of stacking in ui. 
- ii. There is high coupling as shown in UML, such that listofquestion is field of app, and app is a
field of the MainMenuGui. The APP class can be simplified if more time is given.
- iii. Furthuremore, the gui could be simplified such that similar behaviour buttons such as showing questions, answers
and assigned points can be extending to one abstract class or interface for the sake of clarity.

