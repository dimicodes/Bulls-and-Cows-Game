# Bulls-and-Cows-Game

## Overview
Bulls and Cows is a classic mind game where the player tries to guess a secret code. This Java implementation offers a command-line interface for playing the game. The secret code is a sequence of unique characters, which can include digits ('0'-'9') and letters ('a'-'z').

## Features
- Customizable length of the secret code.
- Adjustable range of possible symbols (digits and letters) in the secret code.
- Dynamic feedback to the player in terms of "bulls" and "cows":
  - **Bull**: Correct character in the correct position.
  - **Cow**: Correct character but in the wrong position.
- Input validation to ensure the game runs smoothly.

## How to Play
1. Run the `Main` class in your Java environment.
2. Enter the desired length of the secret code.
3. Specify the number of possible symbols to be used in the code.
4. Start guessing the secret code based on the feedback provided after each guess.

## Code Structure
- `Main`: The entry point of the application. Handles user inputs and coordinates the game.
- `isNumeric`: A utility method to validate numeric inputs.
- `startGame`: Manages the game loop and processes player's guesses.
- `grade`: Evaluates the player's guess and provides feedback in terms of bulls and cows.
- `generateCode`: Generates the secret code based on the specified length and symbol range.

## Preview

![image](https://github.com/dimicodes/Bulls-and-Cows-Game/assets/45632694/5ab282f2-7f12-46bf-845e-eed683e501eb)

