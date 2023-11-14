def calculate_string_similarity(string1, string2):
    string1 = string1.lower()
    string2 = string2.lower()
    common_chars = set(string1) & set(string2)
    similarity = len(common_chars) / max(len(string1), len(string2))
    return similarity


string1 = input("Enter the first string: ")
string2 = input("Enter the second string: ")

similarity_score = calculate_string_similarity(string1, string2)

print("The string similarity score is:", similarity_score)
