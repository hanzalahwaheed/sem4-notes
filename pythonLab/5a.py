def filter_words_with_prefix(word_list, prefix):
    filtered_words = []
    for word in word_list:
        if (word.startswith(prefix)):
            filtered_words.append(word)
    return filtered_words


word_list = input("Enter a list of words (separated by spaces): ").lower().split()
prefix = input("Enter the prefix to filter: ")
filtered_words = filter_words_with_prefix(word_list, prefix)

print("Filtered words:")
for word in filtered_words:
    print(word)
