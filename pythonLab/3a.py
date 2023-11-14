def count_word_occurrences(sentence, word):
    
    sentence = sentence.lower()
    word = word.lower()
    
    words = sentence.split()
    count = words.count(word)
    
    return count


sentence = input("Enter a sentence: ")
word = input("Enter the word to search for: ")

occurrences = count_word_occurrences(sentence, word)

print("The word", word, "occurs", occurrences, "times in the sentence.")
