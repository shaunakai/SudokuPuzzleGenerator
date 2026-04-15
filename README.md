# SudokuPuzzleGenerator
Created by Shaunak Thamke

Description: This project generates a completed 9x9 Sudoku board using randomized backtracking and following logic rules.

How to run the program: 
1. Preferably download and install Visual Studio Code
2. Download the Sudoku.java file and note its location in File Explorer
3. Open the file from the file explorer and open it with VS Code
4. Make sure Java is installed
5. Run the program

Summary of how the Sudoku board was generated: The Sudoku board was generated using a backtracking algorithm, where the grid is filled one cell at a time. For each empty cell, the program creates a list of numbers 1-9 and then randomizes their order. Then it tries each number and checks whether it follows Sudoku rules for the row, column, and 3x3 subgrid. If the number is valid, it gets placed in the cell, and the algorithm moves forward. If no number works, the program backtracks and tries a different value in a previous cell. This process goes on until the board is filled with a valid solution.  

Files included in the project:
Sudoku.java (Java File)
Shaunak Thamke - Sudoku Design Document.pdf (Design Document)
