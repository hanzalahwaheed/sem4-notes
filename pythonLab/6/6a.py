def count_words(input_file, output_file):
    word_count = {}
    with open(input_file, 'r') as file:
        for line in file:
            words = line.lower().split()

            for word in words:
                if word in word_count:
                    word_count[word] += 1
                else:
                    word_count[word] = 1

    with open(output_file, 'w') as file:
        for word, count in word_count.items():
            file.write(f"{word}: {count}\n")


input_file = "input.txt"
output_file = "output.txt"

count_words(input_file, output_file)
