import re


def extract_email_addresses(sentence):
    pattern = r'\b[A-Za-z0-9._]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}\b'
    email_addresses = re.findall(pattern, sentence)
    return email_addresses


sentence = input("Enter a sentence: ")
email_addresses = extract_email_addresses(sentence)

print("Email addresses found:")
for email in email_addresses:
    print(email)
