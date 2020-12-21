print("Today we will play a number game.") #Beginning of the game.
print("You will take a guess at a number and if you are correct, you win!")

from textblob import TextBlob #importing the TextBlob Python Library

inpt = input("Enter a number between 0-10:") #giving the user the option to guess a number

text = TextBlob(inpt) #using TextBlob for the input

import random #Here we input random to randomize a number 1 through 10
t = random.randint(1,10)

#The following is the else if loop for the game.
if t == 0:
    print("Too low, haha.")
elif t == 1:
    print("Too low, haha.")
elif t == 2:
    print("Too low, haha.")
elif t == 3:
    print("You almost had it.")
elif t == 4:
    print("Very close buddy.")
elif t == 5:
    print("You got it right!")
elif t == 6:
    print("Very close buddy.")
elif t == 7:
    print("You almost had it.")
elif t == 8:
    print("Too low, haha.")
elif t ==9:
    print("Too low, haha.")
elif t == 10:
    print("Too low, haha.")

if inpt == t: #Telling the player whether or not they guessed right or not
    print("You got it!")
else:
    print("Gameover")
