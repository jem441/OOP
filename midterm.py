from textblob import TextBlob #importing the TextBlob Python Library

inpt = input("Enter a Sentence:") #giving the user the option to type in a message

text = TextBlob(inpt) #using TextBlob for the input

t = text.sentiment.polarity #This is used to check the polarity of the sentence(whether if it is a positive, negative, or neutral response)

#The following is my else if loop for the sentence
if t < 0:
    print("The Sentence is Negative.")
elif t > 0 and t <= 1:
    print("This Sentence is Positive.")
elif t== 0:
    print("This Sentence is Neutral.")

#The following is my knowledge of functions and docstrings
def my_function():
    """I am demonstrating my knowledge of a function with a simple doc string."""
    return None

print("Using __doc__:")
print(my_function.__doc__) #Using the docstring function
