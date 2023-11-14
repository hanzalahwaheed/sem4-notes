def count_word_frequencies(sentence):
    words = sentence.lower().split()
    frequencies = {}

    for word in words:
        if word in frequencies:
            frequencies[word] += 1
        else:
            frequencies[word] = 1

    return frequencies


sentence = input("Enter a sentence: ")
word_frequencies = count_word_frequencies(sentence)

print("Word frequencies:")
for word, frequency in word_frequencies.items():
    print(word, ":", frequency)
